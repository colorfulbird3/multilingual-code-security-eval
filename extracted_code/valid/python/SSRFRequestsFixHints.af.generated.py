import requests


def get_weather_from_provider(api_url: str) -> dict:
    """
    Haal weerdata van 'n gespesifiseerde API-verskaffer.

    Args:
        api_url: Die URL van die weerdata-verskaffer se API-eindpunt

    Returns:
        'n Woordeboek wat die weerdata van die API-antwoord bevat
    """
    response = requests.get(api_url)
    return response.json()