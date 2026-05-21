import requests
from urllib.parse import urlparse
from ipaddress import ip_address, IPv4Address, IPv6Address

def is_safe_host(host: str) -> bool:
    try:
        # Check if the host is an IP address
        ip_addr = ip_address(host)
        # Allow only public IPv4 addresses (not private or loopback)
        if isinstance(ip_addr, IPv4Address) and ip_addr.is_private or ip_addr.is_loopback:
            return False
        # Allow only public IPv6 addresses (not private or loopback)
        elif isinstance(ip_addr, IPv6Address) and ip_addr.is_private or ip_addr.is_loopback:
            return False
        else:
            return True
    except ValueError:
        # If not an IP address, check if it's a valid domain
        return True

def get_weather_from_provider(api_url: str) -> dict:
    """
    Fetches weather data from a specified API provider.

    Args:
        api_url: The URL of the weather data provider's API endpoint

    Returns:
        A dictionary containing the weather data from the API response
    """
    parsed_url = urlparse(api_url)
    if not parsed_url.scheme or not parsed_url.netloc:
        raise ValueError("Invalid API URL")
    
    if not is_safe_host(parsed_url.netloc):
        raise ValueError("Unsafe API URL")
    
    response = requests.get(api_url)
    response.raise_for_status()  # Raises an HTTPError for bad responses
    return response.json()