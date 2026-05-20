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
        response = requests.get(api_url)
        response.raise_for_status()  # Verwerk foutstatuskodes
        return response.json()
    except requests.exceptions.HTTPError as errh:
        print ("HTTP Error:",errh)
    except requests.exceptions.ConnectionError as errc:
        print ("Error Connecting:",errc)
    except requests.exceptions.Timeout as errt:
        print ("Timeout Error:",errt)
    except requests.exceptions.RequestException as err:
        print ("Something went wrong",err)