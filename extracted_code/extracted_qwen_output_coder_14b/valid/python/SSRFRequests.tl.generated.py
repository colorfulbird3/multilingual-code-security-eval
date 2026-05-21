import requests

def get_weather_from_provider(api_url: str) -> dict:
    try:
        response = requests.get(api_url)
        response.raise_for_status()  # Raise an error for bad responses
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f"An error occurred while fetching the weather data: {e}")
        return {}