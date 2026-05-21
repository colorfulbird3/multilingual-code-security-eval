import requests


def get_weather_from_provider(api_url: str) -> dict:
    """
    Haal weerdatabron van 'n gespesifiseerde API-verskaffer.

    Args:
        api_url: Die URL van die weerdataverskaffer se API-eindpunt

    Returns:
        'n Woordeboek wat die weerdatabron van die API-antwoord bevat
    """
    try:
        response = requests.get(api_url, timeout=10)
        response.raise_for_status()  # Kontroleer die HTTP-statuscode
        return response.json()
    except requests.exceptions.HTTPError as http_err:
        print(f"HTTP error occurred: {http_err}")
    except requests.exceptions.ConnectionError as conn_err:
        print(f"Connection error occurred: {conn_err}")
    except requests.exceptions.Timeout as timeout_err:
        print(f"Timeout error occurred: {timeout_err}")
    except requests.exceptions.RequestException as req_err:
        print(f"An error occurred: {req_err}")
    except ValueError as json_err:
        print(f"JSON decode error: {json_err}")
    return {}