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
from pathlib import Path

# Third-party imports
import requests
from requests.adapters import HTTPAdapter
from urllib3.util.retry import Retry
from tqdm import tqdm

# Optional imports with fallbacks
try:
    import yaml
    YAML_AVAILABLE = True
except ImportError:
    YAML_AVAILABLE = False

try:
    from bs4 import BeautifulSoup
    BEAUTIFULSOUP_AVAILABLE = True
except ImportError:
    BEAUTIFULSOUP_AVAILABLE = False

try:
    import pandas as pd
    PANDAS_AVAILABLE = True
except ImportError:
    PANDAS_AVAILABLE = False

# Configure logging
logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s',
    handlers=[
        logging.FileHandler('web_scraper.log'),
        logging.StreamHandler()
    ]
)
logger = logging.getLogger(__name__)


@dataclass
class ScrapedData:
    """Data class to hold scraped content"""
    url: str
    title: str
    content: str
    metadata: Dict[str, Any] = field(default_factory=dict)
    timestamp: str = field(default_factory=lambda: datetime.now().isoformat())
    status_code: int = 200
    error: Optional[str] = None


@dataclass
class ScraperConfig:
    """Configuration for the web scraper"""
    urls: List[str] = field(default_factory=list)
    output_format: str = "json"
    output_dir: str = "scraped_data"
    max_retries: int = 3
    timeout: int = 30
    delay: float = 1.0
    user_agent: str = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36"
    max_concurrent: int = 5
    extract_links: bool = False
    extract_images: bool = False
    follow_links: bool = False
    max_depth: int = 2
    respect_robots: bool = True
    save_raw_html: bool = False
    verbose: bool = False


class RateLimiter:
    """Rate limiter to control request frequency"""
    
    def __init__(self, calls_per_second: float = 1.0):
        self.min_interval = 1.0 / calls_per_second
        self.last_call_time = 0.0
        self.lock = threading.Lock()
    
    def wait(self):
        """Wait if necessary to maintain rate limit"""
        with self.lock:
            current_time = time.time()
            time_since_last_call = current_time - self.last_call_time
            if time_since_last_call < self.min_interval:
                sleep_time = self.min_interval - time_since_last_call
                time.sleep(sleep_time)
            self.last_call_time = time.time()


class RobotsChecker:
    """Simple robots.txt checker"""
    
    def __init__(self):
        self.cache = {}
        self.lock = threading.Lock()
    
    def is_allowed(self, url: str, user_agent: str = "*") -> bool:
        """Check if URL is allowed by robots.txt"""
        from urllib.parse import urlparse
        parsed = urlparse(url)
        base_url = f"{parsed.scheme}://{parsed.netloc}"
        
        with self.lock:
            if base_url not in self.cache:
                self.cache[base_url] = self._fetch_robots(base_url)
        
        return self.cache[base_url].get(user_agent, True)
    
    def _fetch_robots(self, base_url: str) -> Dict[str, bool]:
        """Fetch and parse robots.txt"""
        try:
            response = requests.get(f"{base_url}/robots.txt", timeout=10)
            if response.status_code == 200:
                return self._parse_robots(response.text)
        except:
            pass
        return {"*": True}
    
    def _parse_robots(self, content: str) -> Dict[str, bool]:
        """Simple robots.txt parser"""
        rules = {"*": True}
        current_agent = "*"
        
        for line in content.split('\n'):
            line = line.strip()
            if line.startswith('User-agent:'):
                current_agent = line.split(':', 1)[1].strip()
                if current_agent not in rules:
                    rules[current_agent] = True
            elif line.startswith('Disallow:'):
                path = line.split(':', 1)[1].strip()
                if path == '/':
                    rules[current_agent] = False
        
        return rules


class ContentExtractor:
    """Extract meaningful content from HTML"""
    
    @staticmethod
    def extract_title(soup) -> str:
        """Extract page title"""
        if soup.title:
            return soup.title.get_text(strip=True)
        return ""
    
    @staticmethod
    def extract_main_content(soup) -> str:
        """Extract main content from page"""
        # Try common content containers
        for selector in ['article', 'main', '.content', '#content', '.post', '.entry']:
            content = soup.select_one(selector)
            if content:
                return content.get_text(separator='\n', strip=True)
        
        # Fallback to body
        body = soup.find('body')
        if body:
            return body.get_text(separator='\n', strip=True)
        
        return soup.get_text(separator='\n', strip=True)
    
    @staticmethod
    def extract_links(soup, base_url: str) -> List[str]:
        """Extract all links from page"""
        links = []
        for a in soup.find_all('a', href=True):
            href = a['href']
            if href.startswith('http'):
                links.append(href)
            elif href.startswith('/'):
                from urllib.parse import urljoin
                links.append(urljoin(base_url, href))
        return links
    
    @staticmethod
    def extract_images(soup, base_url: str) -> List[Dict[str, str]]:
        """Extract image information"""
        images = []
        for img in soup.find_all('img', src=True):
            src = img['src']
            if not src.startswith('http'):
                from urllib.parse import urljoin
                src = urljoin(base_url, src)
            
            images.append({
                'src': src,
                'alt': img.get('alt', ''),
                'title': img.get('title', '')
            })
        return images
    
    @staticmethod
    def extract_metadata(soup) -> Dict[str, str]:
        """Extract metadata from HTML"""
        metadata = {}
        
        # Extract meta tags
        for meta in soup.find_all('meta'):
            if meta.get('name'):
                metadata[meta['name']] = meta.get('content', '')
            elif meta.get('property'):
                metadata[meta['property']] = meta.get('content', '')
        
        return metadata


class WebScraper:
    """Main web scraper class"""
    
    def __init__(self, config: ScraperConfig):
        self.config = config
        self.session = self._create_session()
        self.rate_limiter = RateLimiter(1.0 / config.delay)
        self.robots_checker = RobotsChecker() if config.respect_robots else None
        self.results = []
        self.errors = []
        self.lock = threading.Lock()
        self.progress_bar = None
        
        # Create output directory
        Path(config.output_dir).mkdir(parents=True, exist_ok=True)
    
    def _create_session(self) -> requests.Session:
        """Create requests session with retry logic"""
        session = requests.Session()
        
        # Set headers
        session.headers.update({
            'User-Agent': self.config.user_agent,
            'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8',
            'Accept-Language': 'en-US,en;q=0.5',
            'Accept-Encoding': 'gzip, deflate',
            'Connection': 'keep-alive',
        })
        
        # Configure retries
        retry_strategy = Retry(
            total=self.config.max_retries,
            backoff_factor=1,
            status_forcelist=[429, 500, 502, 503, 504],
        )
        adapter = HTTPAdapter(max_retries=retry_strategy)
        session.mount("http://", adapter)
        session.mount("https://", adapter)
        
        return session
    
    def scrape_url(self, url: str, depth: int = 0) -> Optional[ScrapedData]:
        """Scrape a single URL"""
        if depth > self.config.max_depth:
            return None
        
        # Check robots.txt
        if self.robots_checker and not self.robots_checker.is_allowed(url):
            logger.warning(f"URL blocked by robots.txt: {url}")
            return None
        
        # Rate limiting
        self.rate_limiter.wait()
        
        try:
            # Make request
            response = self.session.get(
                url,
                timeout=self.config.timeout,
                allow_redirects=True
            )
            response.raise_for_status()
            
            # Parse HTML
            if BEAUTIFULSOUP_AVAILABLE:
                soup = BeautifulSoup(response.text, 'html.parser')
            else:
                # Fallback to simple parsing
                soup = type('obj', (object,), {
                    'title': type('obj', (object,), {'get_text': lambda self: ''})(),
                    'get_text': lambda self: response.text
                })()
            
            # Extract content
            title = ContentExtractor.extract_title(soup)
            content = ContentExtractor.extract_main_content(soup)
            metadata = ContentExtractor.extract_metadata(soup)
            
            # Create scraped data object
            scraped = ScrapedData(
                url=url,
                title=title,
                content=content,
                metadata=metadata,
                status_code=response.status_code
            )
            
            # Add optional data
            if self.config.extract_links:
                scraped.metadata['links'] = ContentExtractor.extract_links(soup, url)
            
            if self.config.extract_images:
                scraped.metadata['images'] = ContentExtractor.extract_images(soup, url)
            
            if self.config.save_raw_html:
                scraped.metadata['raw_html'] = response.text
            
            # Follow links if configured
            if self.config.follow_links and depth < self.config.max_depth:
                links = ContentExtractor.extract_links(soup, url)
                for link in links[:10]:  # Limit to 10 links per page
                    self.scrape_url(link, depth + 1)
            
            return scraped
            
        except requests.exceptions.RequestException as e:
            error_msg = f"Request failed for {url}: {str(e)}"
            logger.error(error_msg)
            
            return ScrapedData(
                url=url,
                title="",
                content="",
                error=error_msg,
                status_code=getattr(e.response, 'status_code', 0)
            )
        
        except Exception as e:
            error_msg = f"Unexpected error for {url}: {str(e)}"
            logger.error(error_msg)
            
            return ScrapedData(
                url=url,
                title="",
                content="",
                error=error_msg,
                status_code=0
            )
    
    def scrape_concurrent(self, urls: List[str]) -> List[ScrapedData]:
        """Scrape multiple URLs concurrently"""
        results = []
        threads = []
        result_queue = queue.Queue()
        
        # Create progress bar
        self.progress_bar = tqdm(total=len(urls), desc="Scraping", unit="url")
        
        def worker(url):
            result = self.scrape_url(url)
            result_queue.put(result)
            self.progress_bar.update(1)
        
        # Start threads
        for url in urls:
            thread = threading.Thread(target=worker, args=(url,))
            thread.start()
            threads.append(thread)
            
            # Limit concurrent threads
            if len(threads) >= self.config.max_concurrent:
                for t in threads:
                    t.join()
                threads = []
        
        # Wait for remaining threads
        for thread in threads:
            thread.join()
        
        # Collect results
        while not result_queue.empty():
            result = result_queue.get()
            if result:
                results.append(result)
        
        if self.progress_bar:
            self.progress_bar.close()
        
        return results
    
    def scrape(self) -> List[ScrapedData]:
        """Main scrape method"""
        urls = self.config.urls
        
        if not urls:
            logger.warning("No URLs provided for scraping")
            return []
        
        logger.info(f"Starting scrape of {len(urls)} URLs")
        
        if self.config.max_concurrent > 1 and len(urls) > 1:
            results = self.scrape_concurrent(urls)
        else:
            results = []
            for url in tqdm(urls, desc="Scraping"):
                result = self.scrape_url(url)
                if result:
                    results.append(result)
        
        self.results = results
        logger.info(f"Scraping completed. {len(results)} pages scraped successfully")
        
        return results
    
    def save_results(self, results: List[ScrapedData], output_format: str = None):
        """Save results to file"""
        if not results:
            logger.warning("No results to save")
            return
        
        output_format = output_format or self.config.output_format
        timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
        
        # Convert results to dictionaries
        data = [asdict(result) for result in results]
        
        if output_format == "json":
            filepath = Path(self.config.output_dir) / f"scraped_data_{timestamp}.json"
            with open(filepath, 'w', encoding='utf-8') as f:
                json.dump(data, f, indent=2, ensure_ascii=False)
            logger.info(f"Results saved to {filepath}")
        
        elif output_format == "csv" and PANDAS_AVAILABLE:
            filepath = Path(self.config.output_dir) / f"scraped_data_{timestamp}.csv"
            df = pd.DataFrame(data)
            df.to_csv(filepath, index=False, encoding='utf-8')
            logger.info(f"Results saved to {filepath}")
        
        elif output_format == "yaml" and YAML_AVAILABLE:
            filepath = Path(self.config.output_dir) / f"scraped_data_{timestamp}.yaml"
            with open(filepath, 'w', encoding='utf-8') as f:
                yaml.dump(data, f, default_flow_style=False, allow_unicode=True)
            logger.info(f"Results saved to {filepath}")
        
        else:
            logger.warning(f"Unsupported output format: {output_format}")
    
    def generate_report(self, results: List[ScrapedData]):
        """Generate a summary report"""
        if not results:
            print("No results to report")
            return
        
        successful = [r for r in results if r.error is None]
        failed = [r for r in results if r.error is not None]
        
        print("\n" + "="*60)
        print("SCRAPING REPORT")
        print("="*60)
        print(f"Total URLs attempted: {len(results)}")
        print(f"Successfully scraped: {len(successful)}")
        print(f"Failed: {len(failed)}")
        print(f"Success rate: {(len(successful)/len(results))*100:.1f}%")
        
        if failed:
            print("\nFailed URLs:")
            for result in failed[:5]:  # Show first 5 failures
                print(f"  - {result.url}: {result.error}")
        
        if successful:
            print("\nSample successful results:")
            for result in successful[:3]:  # Show first 3 successful
                print(f"  - {result.url}")
                print(f"    Title: {result.title[:100]}...")
                print(f"    Content length: {len(result.content)} characters")
        
        print("="*60)


def load_config(config_file: str) -> ScraperConfig:
    """Load configuration from file"""
    config_path = Path(config_file)
    
    if not config_path.exists():
        logger.error(f"Config file not found: {config_file}")
        return ScraperConfig()
    
    try:
        if config_file.endswith('.json'):
            with open(config_path, 'r') as f:
                config_dict = json.load(f)
        elif config_file.endswith('.yaml') and YAML_AVAILABLE:
            with open(config_path, 'r') as f:
                config_dict = yaml.safe_load(f)
        else:
            logger.error(f"Unsupported config file format: {config_file}")
            return ScraperConfig()
        
        return ScraperConfig(**config_dict)
    
    except Exception as e:
        logger.error(f"Error loading config: {e}")
        return ScraperConfig()


def parse_arguments():
    """Parse command line arguments"""
    parser = argparse.ArgumentParser(
        description="Advanced Web Scraper - Extract content from websites",
        formatter_class=argparse.RawDescriptionHelpFormatter,
        epilog="""
Examples:
  python web_scraper.py -u https://example.com
  python web_scraper.py -u url1.txt -o csv -d 2
  python web_scraper.py -c config.json -v
  python web_scraper.py -u https://example.com --extract-links --extract-images
        """
    )
    
    # Input options
    input_group = parser.add_argument_group('Input Options')
    input_group.add_argument('-u', '--urls', nargs='+', help='URLs to scrape')
    input_group.add_argument('-f', '--url-file', help='File containing URLs (one per line)')
    input_group.add_argument('-c', '--config', help='Configuration file (JSON or YAML)')
    
    # Output options
    output_group = parser.add_argument_group('Output Options