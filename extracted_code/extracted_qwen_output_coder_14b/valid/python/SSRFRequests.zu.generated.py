def get_weather_from_provider(api_url: str) -> dict:
    try:
        response = requests.get(api_url)
        response.raise_for_status()  # Isebenzisa ukucaciswa kwesicelo esingathunywa
        return response.json()
    except requests.exceptions.RequestException as e:
        print(f"Ukuqonda kukhombisa isicelo: {e}")
        return {}