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

try:
    from urllib.parse import urlparse, urljoin
except ImportError:
    from urlparse import urlparse, urljoin

# Optional imports for enhanced functionality
try:
    import tldextract
except ImportError:
    tldextract = None

try:
    from fake_useragent import UserAgent
except ImportError:
    UserAgent = None

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
    MARKDOWN = "markdown"


@dataclass
class ScrapingConfig:
    """Configuration for web scraping"""
    urls: List[str]
    output_file: str = "scraped_data.json"
    output_format: OutputFormat = OutputFormat.JSON
    strategy: ScrapingStrategy = ScrapingStrategy.HYBRID
    max_depth: int = 2
    max_pages: int = 50
    delay: float = 1.0
    timeout: int = 30
    user_agent: str = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36"
    headers: Dict[str, str] = field(default_factory=lambda: {
        "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
        "Accept-Language": "en-US,en;q=0.5",
        "Accept-Encoding": "gzip, deflate",
        "Connection": "keep-alive",
        "Upgrade-Insecure-Requests": "1"
    })
    proxies: Optional[Dict[str, str]] = None
    verify_ssl: bool = True
    follow_redirects: bool = True
    extract_links: bool = True
    extract_images: bool = True
    extract_metadata: bool = True
    extract_text: bool = True
    extract_tables: bool = False
    extract_forms: bool = False
    javascript_enabled: bool = True
    headless: bool = True
    chrome_driver_path: Optional[str] = None
    chrome_binary_path: Optional[str] = None
    selenium_implicit_wait: int = 10
    selenium_page_load_timeout: int = 30
    retry_attempts: int = 3
    retry_delay: float = 2.0
    concurrent_requests: int = 5
    rate_limit: float = 1.0
    respect_robots_txt: bool = True
    custom_selectors: Dict[str, str] = field(default_factory=dict)
    exclude_patterns: List[str] = field(default_factory=list)
    include_patterns: List[str] = field(default_factory=list)
    cookies: Dict[str, str] = field(default_factory=dict)
    auth: Optional[Tuple[str, str]] = None
    session_id: Optional[str] = None


@dataclass
class ScrapedPage:
    """Data class for scraped page data"""
    url: str
    title: Optional[str] = None
    content: Optional[str] = None
    text: Optional[str] = None
    html: Optional[str] = None
    links: List[str] = field(default_factory=list)
    images: List[str] = field(default_factory=list)
    metadata: Dict[str, Any] = field(default_factory=dict)
    tables: List[List[List[str]]] = field(default_factory=list)
    forms: List[Dict[str, Any]] = field(default_factory=list)
    status_code: Optional[int] = None
    headers: Dict[str, str] = field(default_factory=dict)
    cookies: Dict[str, str] = field(default_factory=dict)
    timestamp: str = field(default_factory=lambda: datetime.now().isoformat())
    depth: int = 0
    error: Optional[str] = None
    strategy_used: Optional[str] = None


class RateLimiter:
    """Rate limiter for controlling request frequency"""
    
    def __init__(self, requests_per_second: float = 1.0):
        self.min_interval = 1.0 / requests_per_second if requests_per_second > 0 else 0
        self.last_request_time = 0
        self.lock = threading.Lock()
    
    def wait(self):
        """Wait if necessary to maintain rate limit"""
        with self.lock:
            current_time = time.time()
            time_since_last = current_time - self.last_request_time
            if time_since_last < self.min_interval:
                sleep_time = self.min_interval - time_since_last
                time.sleep(sleep_time)
            self.last_request_time = time.time()


class RobotsParser:
    """Simple robots.txt parser"""
    
    def __init__(self, user_agent: str = "*"):
        self.user_agent = user_agent
        self.disallowed = set()
        self.allowed = set()
        self.crawl_delay = 0
        self.parsed = False
    
    def parse(self, robots_txt_content: str):
        """Parse robots.txt content"""
        current_agent = None
        for line in robots_txt_content.split('\n'):
            line = line.strip()
            if not line or line.startswith('#'):
                continue
            
            if line.lower().startswith('user-agent:'):
                current_agent = line.split(':', 1)[1].strip()
            elif current_agent == '*' or current_agent == self.user_agent:
                if line.lower().startswith('disallow:'):
                    path = line.split(':', 1)[1].strip()
                    if path:
                        self.disallowed.add(path)
                elif line.lower().startswith('allow:'):
                    path = line.split(':', 1)[1].strip()
                    if path:
                        self.allowed.add(path)
                elif line.lower().startswith('crawl-delay:'):
                    try:
                        self.crawl_delay = float(line.split(':', 1)[1].strip())
                    except ValueError:
                        pass
        
        self.parsed = True
    
    def is_allowed(self, url: str) -> bool:
        """Check if URL is allowed to be crawled"""
        if not self.parsed:
            return True
        
        parsed_url = urlparse(url)
        path = parsed_url.path or '/'
        
        # Check if explicitly allowed
        for allowed_path in self.allowed:
            if path.startswith(allowed_path):
                return True
        
        # Check if explicitly disallowed
        for disallowed_path in self.disallowed:
            if path.startswith(disallowed_path):
                return False
        
        return True


class WebScraper:
    """Main web scraper class with support for static and dynamic content"""
    
    def __init__(self, config: ScrapingConfig):
        self.config = config
        self.session = self._create_session()
        self.driver = None
        self.rate_limiter = RateLimiter(config.rate_limit)
        self.robots_parsers: Dict[str, RobotsParser] = {}
        self.visited_urls: set = set()
        self.scraped_data: List[ScrapedPage] = []
        self.url_queue = queue.Queue()
        self.results_queue = queue.Queue()
        self.active_threads = 0
        self.lock = threading.Lock()
        self.stop_event = threading.Event()
        
        # Initialize Selenium if needed
        if config.strategy in [ScrapingStrategy.DYNAMIC, ScrapingStrategy.HYBRID]:
            self._init_selenium()
    
    def _create_session(self) -> requests.Session:
        """Create and configure requests session"""
        session = requests.Session()
        
        # Configure retries
        retry_strategy = Retry(
            total=self.config.retry_attempts,
            backoff_factor=self.config.retry_delay,
            status_forcelist=[429, 500, 502, 503, 504]
        )
        adapter = HTTPAdapter(max_retries=retry_strategy)
        session.mount("http://", adapter)
        session.mount("https://", adapter)
        
        # Set headers
        session.headers.update(self.config.headers)
        if self.config.user_agent:
            session.headers.update({"User-Agent": self.config.user_agent})
        
        # Set proxies
        if self.config.proxies:
            session.proxies.update(self.config.proxies)
        
        # Set cookies
        if self.config.cookies:
            session.cookies.update(self.config.cookies)
        
        # Set auth
        if self.config.auth:
            session.auth = self.config.auth
        
        session.verify = self.config.verify_ssl
        
        return session
    
    def _init_selenium(self):
        """Initialize Selenium WebDriver"""
        try:
            chrome_options = Options()
            if self.config.headless:
                chrome_options.add_argument("--headless")
            chrome_options.add_argument("--no-sandbox")
            chrome_options.add_argument("--disable-dev-shm-usage")
            chrome_options.add_argument("--disable-gpu")
            chrome_options.add_argument("--window-size=1920,1080")
            chrome_options.add_argument(f"user-agent={self.config.user_agent}")
            
            if self.config.chrome_binary_path:
                chrome_options.binary_location = self.config.chrome_binary_path
            
            service = None
            if self.config.chrome_driver_path:
                service = Service(executable_path=self.config.chrome_driver_path)
            
            self.driver = webdriver.Chrome(
                service=service,
                options=chrome_options
            )
            self.driver.implicitly_wait(self.config.selenium_implicit_wait)
            self.driver.set_page_load_timeout(self.config.selenium_page_load_timeout)
            
            logger.info("Selenium WebDriver initialized successfully")
        except Exception as e:
            logger.error(f"Failed to initialize Selenium WebDriver: {e}")
            if self.config.strategy == ScrapingStrategy.DYNAMIC:
                raise
            logger.warning("Falling back to static scraping")
            self.config.strategy = ScrapingStrategy.STATIC
    
    def _get_robots_parser(self, base_url: str) -> RobotsParser:
        """Get or create robots.txt parser for a domain"""
        parsed_url = urlparse(base_url)
        domain = f"{parsed_url.scheme}://{parsed_url.netloc}"
        
        if domain not in self.robots_parsers:
            parser = RobotsParser(self.config.user_agent)
            try:
                robots_url = urljoin(domain, "/robots.txt")
                response = self.session.get(robots_url, timeout=self.config.timeout)
                if response.status_code == 200:
                    parser.parse(response.text)
                    logger.info(f"Parsed robots.txt for {domain}")
            except Exception as e:
                logger.warning(f"Failed to fetch robots.txt for {domain}: {e}")
            self.robots_parsers[domain] = parser
        
        return self.robots_parsers[domain]
    
    def _should_crawl(self, url: str, depth: int) -> bool:
        """Check if URL should be crawled based on configuration"""
        # Check depth
        if depth > self.config.max_depth:
            return False
        
        # Check if already visited
        if url in self.visited_urls:
            return False
        
        # Check robots.txt
        if self.config.respect_robots_txt:
            parser = self._get_robots_parser(url)
            if not parser.is_allowed(url):
                logger.debug(f"Blocked by robots.txt: {url}")
                return False
        
        # Check include/exclude patterns
        if self.config.include_patterns:
            if not any(re.search(pattern, url) for pattern in self.config.include_patterns):
                return False
        
        if self.config.exclude_patterns:
            if any(re.search(pattern, url) for pattern in self.config.exclude_patterns):
                return False
        
        return True
    
    def _scrape_static(self, url: str) -> ScrapedPage:
        """Scrape static content using requests and BeautifulSoup"""
        page = ScrapedPage(url=url, strategy_used="static")
        
        try:
            self.rate_limiter.wait()
            response = self.session.get(
                url,
                timeout=self.config.timeout,
                allow_redirects=self.config.follow_redirects
            )
            
            page.status_code = response.status_code
            page.headers = dict(response.headers)
            page.cookies = dict(response.cookies)
            
            if response.status_code == 200:
                content_type = response.headers.get('Content-Type', '')
                
                if 'text/html' in content_type or 'application/xhtml' in content_type:
                    soup = BeautifulSoup(response.content, 'html.parser')
                    
                    # Extract title
                    if soup.title:
                        page.title = soup.title.get_text(strip=True)
                    
                    # Extract text content
                    if self.config.extract_text:
                        # Remove script and style elements
                        for script in soup(["script", "style"]):
                            script.decompose()
                        page.text = soup.get_text(separator='\n', strip=True)
                    
                    # Extract links
                    if self.config.extract_links:
                        for link in soup.find_all('a', href=True):
                            absolute_url = urljoin(url, link['href'])
                            if absolute_url.startswith(('http://', 'https://')):
                                page.links.append(absolute_url)
                    
                    # Extract images
                    if self.config.extract_images:
                        for img in soup.find_all('img', src=True):
                            absolute_url = urljoin(url, img['src'])
                            page.images.append(absolute_url)
                    
                    # Extract metadata
                    if self.config.extract_metadata:
                        for meta in soup.find_all('meta'):
                            if meta.get('name') and meta.get('content'):
                                page.metadata[meta['name']] = meta['content']
                            elif meta.get('property') and meta.get('content'):
                                page.metadata[meta['property']] = meta['content']
                    
                    # Extract tables
                    if self.config.extract_tables:
                        for table in soup.find_all('table'):
                            table_data = []
                            for row in table.find_all('tr'):
                                row_data = []
                                for cell in row.find_all(['td', 'th']):
                                    row_data.append(cell.get_text(strip=True))
                                table_data.append(row_data)
                            page.tables.append(table_data)
                    
                    # Extract forms
                    if self.config.extract_forms:
                        for form in soup.find_all('form'):
                            form_data = {
                                'action': form.get('action', ''),
                                'method': form.get('method', 'get'),
                                'inputs': []
                            }
                            for input_tag in form.find_all('input'):
                                input_data = {
                                    'name': input_tag.get('name', ''),
                                    'type': input_tag.get('type', 'text'),
                                    'value': input_tag.get('value', '')
                                }
                                form_data['inputs'].append(input_data)
                            page.forms.append(form_data)
                    
                    # Store HTML
                    page.html = str(soup)
                    page.content = response.text
                
                elif 'application/json' in content_type:
                    page.content = response.text
                    page.metadata['content_type'] = 'json'
                
                else:
                    page.content = response.text
            
            logger.info(f"Successfully scraped (static): {url}")
            
        except requests.exceptions.RequestException as e:
            page.error = str(e)
            logger.error(f"Failed to scrape {url}: {e}")
        
        return page
    
    def _scrape_dynamic(self, url: str) -> ScrapedPage:
        """Scrape dynamic content using Selenium"""
        page = ScrapedPage(url=url, strategy_used="dynamic")
        
        if not self.driver:
            logger.error("Selenium WebDriver not initialized")
            page.error = "Selenium WebDriver not initialized"
            return page
        
        try:
            self.rate_limiter.wait()
            self.driver.get(url)
            
            # Wait for page to load
            WebDriverWait(self.driver, self.config.selenium_page_load_timeout).until(
                EC.presence_of_element_located((By.TAG_NAME, "body"))
            )
            
            # Get page source
            page.html = self.driver.page_source
            page.title = self.driver.title
            page.status_code = 200  # Selenium doesn't provide status code
            
            # Extract text
            if self.config.extract_text:
                body = self.driver.find_element(By.TAG_NAME, "body")
                page.text = body.text
            
            # Extract links
            if self.config.extract_links:
                links = self.driver.find_elements(By.TAG_NAME, "a")
                for link in links:
                    href = link.get_attribute("href")
                    if href and href.startswith(('http://', 'https://'