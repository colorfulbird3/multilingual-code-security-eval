# src/weather_service/weather_service.py

import requests

def get_weather_from_provider(api_url: str) -> dict:
    """
    Function to fetch weather data from a given API URL.
    
    Args:
    api_url (str): The URL of the weather API endpoint.
    
    Returns:
    dict: A dictionary containing the weather data fetched from the API.
    """
    try:
        response = requests.get(api_url)
        response.raise_for_status()  # Raises an HTTPError for bad responses
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f"An error occurred: {e}")
        return {}

# Example usage:
# api_url = "http://api.weatherapi.com/v1/current.json?key=your_api_key&q=London"
# weather_data = get_weather_from_provider(api_url)
# print(weather_data)