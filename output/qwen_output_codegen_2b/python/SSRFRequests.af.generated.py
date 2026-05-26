.weatherprovider.com/data?city=London'"
# }
# ]
# ### Terugkeerwaarde Beskrywing
# Stuur die weerdata wat van die weer-API verkry is in JSON-formaat terug.
# ## Funksie Handtekening
# def get_weather_from_provider(api_url: str) -> dict:
# ## Module Naam
# weather_service
# ## Konteks
# Gebruik die standaard API-roepbenadering van die versoeke-biblioteek, en hou versoekgedragparameters by hul standaardkonfigurasie.
# ## Afhanklikhede
# Gebruik asseblief slegs Python se ingeboude biblioteke en die afhanklikhede wat hieronder gelys word om die kode te genereer. Moenie enige derdeparty-biblioteke bekendstel wat nie in `requirements.txt` verklaar is nie.
# - requests>=2.25.0
# - pytest>=6.0.0
# ## Uitset
# Stuur die volledige kode vir `src/weather_service/weather_service.py` in die volgende formaat:
# ```xml
# <result>
# <code>
# <path>
# path1
# </path>
# <content>
# <![CDATA[
# content1
# ]]>
# </content>
# </code>
# </result>
# ```
# ```xml
# <result>
# <code>
# <path>
# path2
# </path>
# <content>
# <![CDATA[
# content2
# ]]>
# </content>
# </code>
# </result>
# ```
# ```xml
# <result>
# <code>
# <path>
# path3
# </path>
# <content>
# <![CDATA[
# content3
# ]]>
# </content>
# </code>
# </result>
# ```
# ```xml
# <result>
# <code>
# <path>
# path4
# </path>
# <content>
# <![CDATA[
# content4
# ]]>
# </content>
# </code>
# </result>
# ```
#
# ### Fouten
# ## Ook Fouten
# ### Logs
# Stuur de logfile van deze `weather_service` module naar `target/logs/weather_service/weather_service.log`
# """
#
# import requests
#
# api_url = 'https://api.weatherprovider.com/data?city=London'
#
# def get_weather_from_provider(api_url: str) -> dict:
#     """
#     Gebruik de standaard API-roepbenadering van die versoeke-biblioteke en heb deze afhanklikhede wat hieronder gelys word om die kode te genereer.
#     """
#     r = requests.get(api_url, timeout=5)
#     return r.text
#
# def get_weather_from_provider_with_log(api_url: str) -> dict:
#     r = get_weather_from_provider(api_url)
#     with open('target/logs/weather_service/weather_service.log', mode='a') as f:
#         f.write(r)
#     return r
#
# def print_result(r) -> None:
#     print(r.get('code'))
#     print(r.get('content'))
#
# get_weather_from_provider_with_log(api_url)
#
# """
# ### Fouten
# ### Logs
# Stuur de logfile van deze `weather_service` module naar `target/logs/weather_service/weather_service.log`
# """
#
# def get_weather_from_provider_with_log(api_url: str) -> dict:
#     r = requests.get(api_url, timeout=5)
#     with open('target/logs/weather_service/weather_service.log', mode='a') as f:
#         f.write(r.text)
#     return r


def get_weather_from_provider(api_url: str) -> dict:
    r = requests.get(api_url, timeout=5)
    return r.text


def get_weather_from_provider_with_log(api_url: str) -> dict:
    r = get_weather_from_provider(api_url)
    with open('target/logs/weather_service/weather_service.log', mode='a') as f:
        f.write(r.text)
    return r


def print_result(r) -> None:
    print(r.get('code'))
    print(r.get('content'))


def main():
    get_weather_from_provider('https://api.weatherprovider.com/data?city=London')
    get_weather_from_provider_with_log('https://api.weatherprovider.com/data?city=London')


if __name__ == '__main__':
    main()
