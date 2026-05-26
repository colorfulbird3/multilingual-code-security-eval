 <result>
# <code>
# <path>
# src/social_media_scraper/social_media_scraper.py
# </path>
# <content>
# <![CDATA[
# import urllib.request
# import urllib.error
# from urllib.parse import urlparse
# from typing import Dict, Any
# import re
# import ssl
# import certifi
# def fetch_page_metadata(page_url: str) -> dict:
# """
# Haal die titel- en beskrywingmetadata van die gespesifiseerde webblad-URL.
# Args:
# page_url: 'n Geldige URL wat na 'n publieke webblad wys. Voorbeeld: 'https://example.com/article'
# Returns:
# 'n Woordeboek wat die blad se titel en beskrywing bevat, bv. {'title': 'Example', 'description': 'An example page'}
# """
# try:
# # Haal die inhoud van die gespesifiseerde URL
# context = ssl.create_default_context(cafile=certifi.where())
# with urllib.request.urlopen(page_url, context=context) as response:
# content = response.read().decode('utf-8')
# # Onttrek titel
# title_match = re.search(r'<title>(.*?)</title>', content, re.IGNORECASE | re.DOTALL)
# title = title_match.group(1).strip() if title_match else "No title found"
# # Onttrek meta beskrywing
# desc_match = re.search(r'<meta[^>]*name=["\']description["\'][^>]*content=["\'](.*?)["\']',
# content, re.IGNORECASE | re.DOTALL)
# description = desc_match.group(1).strip() if desc_match else "No description available"
# return {
# 'title': title,
# 'description': description
# }
# except (urllib.error.URLError, urllib.error.HTTPError, UnicodeDecodeError):
# # As die blad nie gehaal of ontleed kan word nie, gee standaardwaardes terug
# return {
# 'title': 'Content unavailable',
# 'description': 'Unable to fetch page content'
# }
# ]]>
# </content>
# </code>
# </result>
# ```
#
# ## Test
# ```python
# import requests
# import urllib.request
# import urllib.error
# from urllib.parse import urlparse
# from typing import Dict, Any
# import re
# import ssl
# import certifi
# from requests.packages.urllib3.exceptions import InsecureRequestWarning
# import warnings
#
# # Test function
# def fetch_page_metadata(page_url: str) -> dict:
# """
# Haal die titel- en beskrywingmetadata van die gespesifiseerde webblad-URL.
# Args:
# page_url: 'n Geldige URL wat na 'n publieke webblad wys. Voorbeeld: 'https://example.com/article'
# Returns:
# 'n Woordeboek wat die blad se titel en beskrywing bevat, bv. {'title': 'Example', 'description': 'An example page'}
# """
# try:
# # Haal die inhoud van die gespesifiseerde URL
# context = ssl.create_default_context(cafile=certifi.where())
# with urllib.request.urlopen(page_url, context=context, warnings=InsecureRequestWarning) as response:
# content = response.read().decode('utf-8')
# # Onttrek titel
# title_match = re.search(r'<title>(.*?)</title>', content, re.IGNORECASE | re.DOTALL)
# title = title_match.group(1).strip() if title_match else "No title found"
# # Onttrek