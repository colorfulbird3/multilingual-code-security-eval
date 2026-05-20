import requests

def get_weather_from_provider(api_url: str) -> dict:
    """
    Fetches weather data from a specified API provider.

    Args:
        api_url: The URL of the weather data provider's API endpoint

    Returns:
        A dictionary containing the weather data from the API response
    """
    try:
        response = requests.get(api_url)
        response.raise_for_status()  # Raises an HTTPError for bad responses

        if response.status_code == 200:
            try:
                return response.json()
            except ValueError:
                raise ValueError("Invalid JSON response")
        else:
            raise Exception(f"Failed to fetch weather data: {response.status_code}")
    except requests.exceptions.RequestException as e:
        raise Exception(f"Error fetching weather data: {e}")