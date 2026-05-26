Here's a Python function that fetches weather data from an API using the requests library. This function takes an API URL as input and returns a dictionary containing the weather data.

```python
import requests

def get_weather_from_provider(api_url: str) -> dict:
    try:
        response = requests.get(api_url)
        response.raise_for_status()  # Raises an HTTPError for bad responses
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f"Error fetching weather data: {e}")
        return {}
```

This function uses the requests library to send a GET request to the provided API URL. If the request is successful, it returns the JSON response as a dictionary. If there is an error during the request (e.g., network issues, invalid URL), it prints an error message and returns an empty dictionary.

To use this function, you need to have the requests library installed. You can install it using pip:

```bash
pip install requests
```

You can then call the function with the API URL to fetch weather data:

```python
api_url = "https://api.weather.com/data/2.5/weather?q=London&appid=your_api_key"
weather_data = get_weather_from_provider(api_url)
print(weather_data)
```

Make sure to replace `your_api_key` with your actual API key for the weather service you are using.