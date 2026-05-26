```python
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
```

### Explanation:
- **Function Signature**: The function `get_weather_from_provider` takes a single argument `api_url` which is a string representing the URL of the weather API. It returns a dictionary containing the weather data.
- **Module Name**: The module name is `weather_service`.
- **Dependencies**: The `requests` library is used to make HTTP requests. This is specified in the `requirements.txt` file as `requests>=2.25.0`.

### Additional Notes:
- The function includes error handling to manage any exceptions that may occur during the HTTP request.
- The example usage at the bottom demonstrates how to call the function with a sample API URL. Replace `"your_api_key"` with your actual API key and `"London"` with the desired location.
- Ensure that the `requirements.txt` file is included in the project directory and contains the necessary dependencies.