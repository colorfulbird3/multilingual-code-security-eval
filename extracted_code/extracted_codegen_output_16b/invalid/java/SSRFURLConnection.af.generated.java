```python
from typing import Optional, Dict, Any
from dataclasses import dataclass, field
from enum import Enum
import requests
from bs4 import BeautifulSoup
import re
from urllib.parse import urlparse
import logging

logger = logging.getLogger(__name__)

class UrlPreviewServiceError(Exception):
    """Base exception for UrlPreviewService"""
    pass

class PreviewType(Enum):
    """Types of preview content"""
    WEBSITE = "website"
    IMAGE = "image"
    VIDEO = "video"
    AUDIO = "audio"
    PDF = "pdf"
    UNKNOWN = "unknown"

@dataclass
class UrlPreviewServiceResult:
    """Result object for URL preview service"""
    url: str
    title: Optional[str] = None
    description: Optional[str] = None
    image_url: Optional[str] = None
    favicon_url: Optional[str] = None
    site_name: Optional[str] = None
    preview_type: PreviewType = PreviewType.UNKNOWN
    content_type: Optional[str] = None
    content_length: Optional[int] = None
    status_code: int = 200
    error: Optional[str] = None
    metadata: Dict[str, Any] = field(default_factory=dict)

    def is_valid(self) -> bool:
        """Check if the result contains valid preview data"""
        return self.status_code == 200 and self.error is None

class UrlPreviewService:
    """Service for generating URL previews"""
    
    def __init__(self, timeout: int = 10, max_content_length: int = 10 * 1024 * 1024):
        self.timeout = timeout
        self.max_content_length = max_content_length
        self.session = requests.Session()
        self.session.headers.update({
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36'
        })

    def fetch_preview(self, url: str) -> UrlPreviewServiceResult:
        """Fetch preview data for a given URL"""
        try:
            # Validate URL
            parsed = urlparse(url)
            if not parsed.scheme:
                url = f"https://{url}"
                parsed = urlparse(url)
            
            if not parsed.netloc:
                return UrlPreviewServiceResult(url=url, error="Invalid URL", status_code=400)

            # Fetch the URL
            response = self.session.get(url, timeout=self.timeout, stream=True)
            response.raise_for_status()
            
            # Check content length
            content_length = int(response.headers.get('content-length', 0))
            if content_length > self.max_content_length:
                return UrlPreviewServiceResult(
                    url=url,
                    error="Content too large",
                    status_code=413,
                    content_length=content_length
                )

            content_type = response.headers.get('content-type', '').lower()
            
            # Handle different content types
            if 'image/' in content_type:
                return self._handle_image_preview(url, response, content_type)
            elif 'video/' in content_type:
                return self._handle_video_preview(url, response, content_type)
            elif 'audio/' in content_type:
                return self._handle_audio_preview(url, response, content_type)
            elif 'application/pdf' in content_type:
                return self._handle_pdf_preview(url, response, content_type)
            else:
                return self._handle_website_preview(url, response, content_type)

        except requests.exceptions.Timeout:
            return UrlPreviewServiceResult(url=url, error="Request timed out", status_code=408)
        except requests.exceptions.ConnectionError:
            return UrlPreviewServiceResult(url=url, error="Connection failed", status_code=502)
        except requests.exceptions.HTTPError as e:
            return UrlPreviewServiceResult(url=url, error=str(e), status_code=e.response.status_code if e.response else 500)
        except Exception as e:
            logger.error(f"Unexpected error fetching preview for {url}: {str(e)}")
            return UrlPreviewServiceResult(url=url, error=f"Unexpected error: {str(e)}", status_code=500)

    def _handle_website_preview(self, url: str, response: requests.Response, content_type: str) -> UrlPreviewServiceResult:
        """Extract preview data from HTML content"""
        try:
            soup = BeautifulSoup(response.content, 'html.parser')
            
            # Extract metadata
            title = self._extract_title(soup)
            description = self._extract_description(soup)
            image_url = self._extract_image(soup, url)
            favicon_url = self._extract_favicon(soup, url)
            site_name = self._extract_site_name(soup)
            
            return UrlPreviewServiceResult(
                url=url,
                title=title,
                description=description,
                image_url=image_url,
                favicon_url=favicon_url,
                site_name=site_name,
                preview_type=PreviewType.WEBSITE,
                content_type=content_type,
                content_length=len(response.content),
                status_code=response.status_code
            )
        except Exception as e:
            logger.error(f"Error parsing HTML for {url}: {str(e)}")
            return UrlPreviewServiceResult(url=url, error=f"Failed to parse HTML: {str(e)}", status_code=422)

    def _handle_image_preview(self, url: str, response: requests.Response, content_type: str) -> UrlPreviewServiceResult:
        """Handle image content type"""
        return UrlPreviewServiceResult(
            url=url,
            title=url.split('/')[-1],
            image_url=url,
            preview_type=PreviewType.IMAGE,
            content_type=content_type,
            content_length=len(response.content),
            status_code=response.status_code
        )

    def _handle_video_preview(self, url: str, response: requests.Response, content_type: str) -> UrlPreviewServiceResult:
        """Handle video content type"""
        return UrlPreviewServiceResult(
            url=url,
            title=url.split('/')[-1],
            preview_type=PreviewType.VIDEO,
            content_type=content_type,
            content_length=len(response.content),
            status_code=response.status_code
        )

    def _handle_audio_preview(self, url: str, response: requests.Response, content_type: str) -> UrlPreviewServiceResult:
        """Handle audio content type"""
        return UrlPreviewServiceResult(
            url=url,
            title=url.split('/')[-1],
            preview_type=PreviewType.AUDIO,
            content_type=content_type,
            content_length=len(response.content),
            status_code=response.status_code
        )

    def _handle_pdf_preview(self, url: str, response: requests.Response, content_type: str) -> UrlPreviewServiceResult:
        """Handle PDF content type"""
        return UrlPreviewServiceResult(
            url=url,
            title=url.split('/')[-1],
            preview_type=PreviewType.PDF,
            content_type=content_type,
            content_length=len(response.content),
            status_code=response.status_code
        )

    def _extract_title(self, soup: BeautifulSoup) -> Optional[str]:
        """Extract title from HTML"""
        # Try Open Graph title first
        og_title = soup.find('meta', property='og:title')
        if og_title and og_title.get('content'):
            return og_title['content']
        
        # Try Twitter card title
        twitter_title = soup.find('meta', attrs={'name': 'twitter:title'})
        if twitter_title and twitter_title.get('content'):
            return twitter_title['content']
        
        # Fall back to HTML title tag
        title_tag = soup.find('title')
        if title_tag:
            return title_tag.get_text(strip=True)
        
        return None

    def _extract_description(self, soup: BeautifulSoup) -> Optional[str]:
        """Extract description from HTML"""
        # Try Open Graph description first
        og_desc = soup.find('meta', property='og:description')
        if og_desc and og_desc.get('content'):
            return og_desc['content']
        
        # Try Twitter card description
        twitter_desc = soup.find('meta', attrs={'name': 'twitter:description'})
        if twitter_desc and twitter_desc.get('content'):
            return twitter_desc['content']
        
        # Try meta description
        meta_desc = soup.find('meta', attrs={'name': 'description'})
        if meta_desc and meta_desc.get('content'):
            return meta_desc['content']
        
        return None

    def _extract_image(self, soup: BeautifulSoup, base_url: str) -> Optional[str]:
        """Extract image URL from HTML"""
        # Try Open Graph image first
        og_image = soup.find('meta', property='og:image')
        if og_image and og_image.get('content'):
            return self._resolve_url(og_image['content'], base_url)
        
        # Try Twitter card image
        twitter_image = soup.find('meta', attrs={'name': 'twitter:image'})
        if twitter_image and twitter_image.get('content'):
            return self._resolve_url(twitter_image['content'], base_url)
        
        # Try to find the first large image
        images = soup.find_all('img')
        for img in images:
            src = img.get('src')
            if src and not src.startswith('data:'):
                return self._resolve_url(src, base_url)
        
        return None

    def _extract_favicon(self, soup: BeautifulSoup, base_url: str) -> Optional[str]:
        """Extract favicon URL from HTML"""
        # Try link tags first
        for link in soup.find_all('link'):
            rel = link.get('rel', [])
            if isinstance(rel, list) and 'icon' in rel:
                href = link.get('href')
                if href:
                    return self._resolve_url(href, base_url)
        
        # Fall back to default favicon location
        return self._resolve_url('/favicon.ico', base_url)

    def _extract_site_name(self, soup: BeautifulSoup) -> Optional[str]:
        """Extract site name from HTML"""
        # Try Open Graph site name
        og_site = soup.find('meta', property='og:site_name')
        if og_site and og_site.get('content'):
            return og_site['content']
        
        # Try to extract from URL
        return None

    def _resolve_url(self, url: str, base_url: str) -> str:
        """Resolve relative URLs to absolute URLs"""
        if url.startswith('http://') or url.startswith('https://'):
            return url
        
        # Handle protocol-relative URLs
        if url.startswith('//'):
            parsed_base = urlparse(base_url)
            return f"{parsed_base.scheme}:{url}"
        
        # Handle relative URLs
        from urllib.parse import urljoin
        return urljoin(base_url, url)

    def close(self):
        """Close the session"""
        self.session.close()

    def __enter__(self):
        return self

    def __exit__(self, exc_type, exc_val, exc_tb):
        self.close()
```