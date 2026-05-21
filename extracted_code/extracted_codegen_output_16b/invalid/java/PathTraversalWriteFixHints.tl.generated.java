```python
import os
import sys
import json
import time
import logging
import argparse
import threading
import queue
import re
from datetime import datetime
from typing import Dict, List, Optional, Any, Tuple
from dataclasses import dataclass, field, asdict
from enum import Enum

# Third-party imports
try:
    import requests
    from requests.adapters import HTTPAdapter
    from urllib3.util.retry import Retry
except ImportError:
    print("Error: 'requests' library is required. Install with: pip install requests")
    sys.exit(1)

try:
    from bs4 import BeautifulSoup
except ImportError:
    print("Error: 'beautifulsoup4' library is required. Install with: pip install beautifulsoup4")
    sys.exit(1)

try:
    from selenium import webdriver
    from selenium.webdriver.chrome.options import Options
    from selenium.webdriver.chrome.service import Service
    from selenium.webdriver.common.by import By
    from selenium.webdriver.support.ui import WebDriverWait
    from selenium.webdriver.support import expected_conditions as EC
    from selenium.common.exceptions import TimeoutException, WebDriverException
except ImportError:
    print("Error: 'selenium' library is required. Install with: pip install selenium")
    sys.exit(1)

# Optional imports for better performance
try:
    from urllib.parse import urlparse, urljoin
except ImportError:
    from urlparse import urlparse, urljoin

# Configure logging
logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s',
    handlers=[
        logging.FileHandler("web_scraper.log"),
        logging.StreamHandler()
    ]
)
logger = logging.getLogger(__name__)


class ScrapingStrategy(Enum):
    """Enum for different scraping strategies"""
    STATIC = "static"
    DYNAMIC = "dynamic"
    HYBRID = "hybrid"


class OutputFormat(Enum):
    """Enum for output formats"""
    JSON = "json"
    CSV = "csv"
    TEXT = "text"


@dataclass
class ScrapedData:
    """Data class to hold scraped content"""
    url: str
    title: str
    content: str
    metadata: Dict[str, Any] = field(default_factory=dict)
    timestamp: str = field(default_factory=lambda: datetime.now().isoformat())
    status: str = "success"
    error: Optional[str] = None


@dataclass
class ScrapingConfig:
    """Configuration for web scraping"""
    urls: List[str]
    output_format: OutputFormat = OutputFormat.JSON
    output_file: str = "scraped_data"
    max_depth: int = 1
    max_pages: int = 100
    delay: float = 1.0
    timeout: int = 30
    user_agent: str = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36"
    strategy: ScrapingStrategy = ScrapingStrategy.HYBRID
    follow_links: bool = False
    extract_images: bool = False
    extract_links: bool = False
    css_selectors: Optional[Dict[str, str]] = None
    javascript_enabled: bool = True
    headless: bool = True
    proxy: Optional[str] = None
    cookies: Optional[Dict[str, str]] = None
    headers: Optional[Dict[str, str]] = None
    rate_limit: int = 10  # requests per second
    retry_attempts: int = 3
    respect_robots_txt: bool = True


class RateLimiter:
    """Rate limiter to control request frequency"""
    
    def __init__(self, max_per_second: int = 10):
        self.max_per_second = max_per_second
        self.min_interval = 1.0 / max_per_second
        self.last_request_time = 0
        self.lock = threading.Lock()
    
    def wait(self):
        """Wait if necessary to maintain rate limit"""
        with self.lock:
            current_time = time.time()
            time_since_last = current_time - self.last_request_time
            if time_since_last < self.min_interval:
                time.sleep(self.min_interval - time_since_last)
            self.last_request_time = time.time()


class RobotsParser:
    """Simple robots.txt parser"""
    
    def __init__(self):
        self.rules: Dict[str, List[str]] = {}
        self.crawl_delay: float = 0
    
    def parse(self, robots_txt_content: str):
        """Parse robots.txt content"""
        current_user_agent = "*"
        for line in robots_txt_content.split('\n'):
            line = line.strip()
            if line.startswith('User-agent:'):
                current_user_agent = line.split(':', 1)[1].strip()
                if current_user_agent not in self.rules:
                    self.rules[current_user_agent] = []
            elif line.startswith('Disallow:'):
                path = line.split(':', 1)[1].strip()
                if path:
                    self.rules.setdefault(current_user_agent, []).append(path)
            elif line.startswith('Crawl-delay:'):
                try:
                    self.crawl_delay = float(line.split(':', 1)[1].strip())
                except ValueError:
                    pass
    
    def is_allowed(self, url: str, user_agent: str = "*") -> bool:
        """Check if URL is allowed to be scraped"""
        if user_agent in self.rules:
            for disallowed_path in self.rules[user_agent]:
                if disallowed_path in url:
                    return False
        if "*" in self.rules:
            for disallowed_path in self.rules["*"]:
                if disallowed_path in url:
                    return False
        return True


class WebScraper:
    """Main web scraper class with advanced features"""
    
    def __init__(self, config: ScrapingConfig):
        self.config = config
        self.session = self._create_session()
        self.driver = None
        self.rate_limiter = RateLimiter(config.rate_limit)
        self.robots_parser = RobotsParser()
        self.visited_urls: set = set()
        self.scraped_data: List[ScrapedData] = []
        self.progress_callback = None
        self._stop_event = threading.Event()
        
        # Initialize Selenium if needed
        if config.strategy in [ScrapingStrategy.DYNAMIC, ScrapingStrategy.HYBRID]:
            self._init_selenium()
    
    def _create_session(self) -> requests.Session:
        """Create a requests session with retry logic"""
        session = requests.Session()
        
        # Set up retry strategy
        retry_strategy = Retry(
            total=self.config.retry_attempts,
            backoff_factor=1,
            status_forcelist=[429, 500, 502, 503, 504],
        )
        adapter = HTTPAdapter(max_retries=retry_strategy)
        session.mount("http://", adapter)
        session.mount("https://", adapter)
        
        # Set headers
        headers = {
            'User-Agent': self.config.user_agent,
            'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8',
            'Accept-Language': 'en-US,en;q=0.5',
            'Accept-Encoding': 'gzip, deflate',
            'Connection': 'keep-alive',
        }
        if self.config.headers:
            headers.update(self.config.headers)
        session.headers.update(headers)
        
        # Set proxy if configured
        if self.config.proxy:
            session.proxies = {
                'http': self.config.proxy,
                'https': self.config.proxy
            }
        
        # Set cookies if configured
        if self.config.cookies:
            session.cookies.update(self.config.cookies)
        
        return session
    
    def _init_selenium(self):
        """Initialize Selenium WebDriver"""
        try:
            chrome_options = Options()
            if self.config.headless:
                chrome_options.add_argument("--headless")
            chrome_options.add_argument(f"user-agent={self.config.user_agent}")
            chrome_options.add_argument("--no-sandbox")
            chrome_options.add_argument("--disable-dev-shm-usage")
            chrome_options.add_argument("--disable-gpu")
            chrome_options.add_argument("--window-size=1920,1080")
            
            if self.config.proxy:
                chrome_options.add_argument(f'--proxy-server={self.config.proxy}')
            
            # Try to find ChromeDriver automatically
            try:
                from selenium.webdriver.chrome.service import Service as ChromeService
                from webdriver_manager.chrome import ChromeDriverManager
                service = ChromeService(ChromeDriverManager().install())
                self.driver = webdriver.Chrome(service=service, options=chrome_options)
            except:
                # Fallback to system ChromeDriver
                self.driver = webdriver.Chrome(options=chrome_options)
            
            self.driver.set_page_load_timeout(self.config.timeout)
            logger.info("Selenium WebDriver initialized successfully")
        except Exception as e:
            logger.error(f"Failed to initialize Selenium: {e}")
            if self.config.strategy == ScrapingStrategy.DYNAMIC:
                raise
            logger.warning("Falling back to static scraping")
            self.config.strategy = ScrapingStrategy.STATIC
    
    def _fetch_robots_txt(self, base_url: str):
        """Fetch and parse robots.txt"""
        if not self.config.respect_robots_txt:
            return
        
        try:
            parsed_url = urlparse(base_url)
            robots_url = f"{parsed_url.scheme}://{parsed_url.netloc}/robots.txt"
            response = self.session.get(robots_url, timeout=10)
            if response.status_code == 200:
                self.robots_parser.parse(response.text)
                logger.info(f"Parsed robots.txt from {robots_url}")
        except Exception as e:
            logger.warning(f"Failed to fetch robots.txt: {e}")
    
    def _static_scrape(self, url: str) -> Optional[str]:
        """Scrape static content using requests and BeautifulSoup"""
        try:
            self.rate_limiter.wait()
            response = self.session.get(url, timeout=self.config.timeout)
            response.raise_for_status()
            
            # Check content type
            content_type = response.headers.get('content-type', '').lower()
            if 'text/html' not in content_type and 'application/xhtml' not in content_type:
                logger.warning(f"Non-HTML content at {url}: {content_type}")
                return response.text
            
            return response.text
        except requests.exceptions.RequestException as e:
            logger.error(f"Request failed for {url}: {e}")
            return None
    
    def _dynamic_scrape(self, url: str) -> Optional[str]:
        """Scrape dynamic content using Selenium"""
        if not self.driver:
            logger.error("Selenium driver not initialized")
            return None
        
        try:
            self.rate_limiter.wait()
            self.driver.get(url)
            
            # Wait for page to load
            WebDriverWait(self.driver, self.config.timeout).until(
                EC.presence_of_element_located((By.TAG_NAME, "body"))
            )
            
            # Additional wait for JavaScript to execute
            time.sleep(2)
            
            return self.driver.page_source
        except TimeoutException:
            logger.error(f"Timeout loading {url}")
            return None
        except WebDriverException as e:
            logger.error(f"Selenium error for {url}: {e}")
            return None
    
    def _extract_content(self, html: str, url: str) -> ScrapedData:
        """Extract content from HTML using BeautifulSoup"""
        soup = BeautifulSoup(html, 'html.parser')
        
        # Remove script and style elements
        for script in soup(["script", "style", "nav", "footer", "header"]):
            script.decompose()
        
        # Extract title
        title = ""
        if soup.title:
            title = soup.title.get_text(strip=True)
        
        # Extract content based on CSS selectors or default
        content = ""
        if self.config.css_selectors:
            for name, selector in self.config.css_selectors.items():
                elements = soup.select(selector)
                if elements:
                    content += f"\n=== {name} ===\n"
                    for elem in elements:
                        content += elem.get_text(strip=True) + "\n"
        else:
            # Default: extract main content
            for tag in ['article', 'main', 'div.content', 'div#content', 'body']:
                main_content = soup.select_one(tag)
                if main_content:
                    content = main_content.get_text(separator='\n', strip=True)
                    break
            if not content:
                content = soup.get_text(separator='\n', strip=True)
        
        # Clean up content
        content = re.sub(r'\n\s*\n', '\n\n', content)
        content = content.strip()
        
        # Extract metadata
        metadata = {
            'url': url,
            'title': title,
            'content_length': len(content),
            'word_count': len(content.split()),
        }
        
        # Extract links if configured
        if self.config.extract_links:
            links = []
            for a in soup.find_all('a', href=True):
                href = a['href']
                full_url = urljoin(url, href)
                links.append({
                    'text': a.get_text(strip=True),
                    'url': full_url
                })
            metadata['links'] = links
        
        # Extract images if configured
        if self.config.extract_images:
            images = []
            for img in soup.find_all('img', src=True):
                images.append({
                    'src': urljoin(url, img['src']),
                    'alt': img.get('alt', '')
                })
            metadata['images'] = images
        
        return ScrapedData(
            url=url,
            title=title,
            content=content,
            metadata=metadata
        )
    
    def scrape_url(self, url: str) -> Optional[ScrapedData]:
        """Scrape a single URL"""
        if url in self.visited_urls:
            logger.debug(f"Already visited: {url}")
            return None
        
        # Check robots.txt
        if self.config.respect_robots_txt:
            if not self.robots_parser.is_allowed(url, self.config.user_agent):
                logger.warning(f"URL disallowed by robots.txt: {url}")
                return ScrapedData(
                    url=url,
                    title="",
                    content="",
                    status="blocked",
                    error="Disallowed by robots.txt"
                )
        
        self.visited_urls.add(url)
        logger.info(f"Scraping: {url}")
        
        html = None
        try:
            # Choose scraping strategy
            if self.config.strategy == ScrapingStrategy.STATIC:
                html = self._static_scrape(url)
            elif self.config.strategy == ScrapingStrategy.DYNAMIC:
                html = self._dynamic_scrape(url)
            else:  # HYBRID
                html = self._static_scrape(url)
                if not html:
                    logger.info(f"Falling back to dynamic scraping for {url}")
                    html = self._dynamic_scrape(url)
            
            if html:
                data = self._extract_content(html, url)
                self.scraped_data.append(data)
                
                # Follow links if configured
                if self.config.follow_links and len(self.visited_urls) < self.config.max_pages:
                    self._follow_links(html, url)
                
                return data
            else:
                logger.error(f"Failed to scrape {url}")
                return ScrapedData(
                    url=url,
                    title="",
                    content="",
                    status="failed",
                    error="Failed to retrieve content"
                )
        
        except Exception as e:
            logger.error(f"Error scraping {url}: {e}")
            return ScrapedData(
                url=url,
                title="",
                content="",
                status="error",
                error=str(e)
            )
    
    def _follow_links(self, html: str, base_url: str):
        """Extract and follow links from HTML"""
        soup = BeautifulSoup(html, 'html.parser')
        links = []
        
        for a in soup.find_all('a', href=True):
            href = a['href']
            full_url = urljoin(base_url, href)
            
            # Only follow same-domain links
            if urlparse(full_url).netloc == urlparse(base_url).netloc:
                # Skip non-HTML resources
                if not any(full_url.endswith(ext) for ext in ['.pdf', '.jpg', '.png', '.gif', '.zip']):
                    links.append(full_url)
        
        # Scrape found links (limited by max_pages)
        for link in links[:self.config.max_pages - len(self.visited_urls)]:
            if self._stop_event.is_set():
                break
            self.scrape_url(link)
            time.sleep(self.config.delay)
    
    def scrape_all(self, progress_callback=None):
        """Scrape all configured URLs"""
        self.progress_callback = progress_callback
        
        # Fetch robots.txt for each unique domain
        domains = set()
        for url in self.config.urls:
            domain = urlparse(url).netloc
            if domain not in domains:
                domains.add(domain)
                self._fetch_robots_txt(url)
        
        total_urls = len(self.config.urls)
        for i, url in enumerate(self.config.urls):
            if self._stop_event.is_set():
                break
            
            self.scrape_url(url)
            
            if progress_callback:
                progress_callback(i + 1, total_urls, url)
            
            # Rate limiting delay
            time.sleep(self.config.delay)
        
        return self.scraped_data
    
    def stop(self):
        """Stop the scraping process"""
        self._stop_event.set()
        logger.info("Scraping stopped by user")
    
    def save_output(self):
        """Save scraped data to file"""
        if not self.scraped_data:
            logger.warning("No data to save")
            return
        
        timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
        
        if self.config.output_format == OutputFormat.JSON:
            filename = f"{self.config.output_file