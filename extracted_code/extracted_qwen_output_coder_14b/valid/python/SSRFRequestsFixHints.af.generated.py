import requests
from urllib.parse import urlparse

def get_weather_from_provider(api_url: str) -> dict:
    """
    Haal weerdata van 'n gespesifiseerde API-verskaffer.

    Args:
        api_url: Die URL van die weerdata-verskaffer se API-eindpunt

    Returns:
        'n Woordeboek wat die weerdata van die API-antwoord bevat
    """
    # Valider die URL om ervoor te sorg dat dit 'n geldige en veilige URL is
    parsed_url = urlparse(api_url)
    if not all([parsed_url.scheme, parsed_url.netloc]):
        raise ValueError("Ongeldige URL")

    # Beperk die URL tot toegestane domeine indien nodig
    allowed_domains = ['api.weatherprovider.com']
    if parsed_url.netloc not in allowed_domains:
        raise ValueError("Toegang tot hierdie domein word nie toegestaan nie.")

    response = requests.get(api_url)
    return response.json()