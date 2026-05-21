# Import the requests library
import requests

# Define a function to fetch weather data
def get_weather_from_provider(api_url: str) -> dict:
    """
    Fetches weather data from a specified API provider.

    Args:
        api_url: The URL of the weather data provider's API endpoint

    Returns:
        A dictionary containing the weather data from the API response
    """
    try:
        # Send a GET request to the API
        response = requests.get(api_url)
        
        # Check if the request was successful
        response.raise_for_status()
        
        # Return the JSON response
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f"An error occurred: {e}")
        return {}

# Example usage
if __name__ == "__main__":
    api_url = "https://api.example.com/weather?city=London"
    weather_data = get_weather_from_provider(api_url)
    print(weather_data)