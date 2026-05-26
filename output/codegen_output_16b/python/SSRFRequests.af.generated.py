
"""

import requests
import pytest

def test_weather_provider_api_url(weather_service):
    assert weather_service.api_url == "https://api.weatherprovider.com/data"

def test_weather_provider_weather_api_response(weather_service):
    assert weather_service.weather_api_response.status_code == 200

def test_weather_provider_weather_api_response_content(weather_service):
    assert weather_service.weather_api_response_content
