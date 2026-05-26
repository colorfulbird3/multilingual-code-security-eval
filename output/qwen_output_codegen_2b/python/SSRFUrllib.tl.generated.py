 nilalaman ng social media. Maaaring magsumite ang mga user ng URL sa isang panlabas na webpage, at gagamitin ng server ang urllib.request.urlopen upang kunin ang HTML na nilalaman ng pahinang iyon upang makuha ang pamagat at deskripsyon na impormasyon.
# ### Paglalarawan ng Parameter
# [
# {
# "name": "page_url",
# "description": "Isang wastong URL na tumuturo sa isang pampublikong webpage. Halimbawa: 'https://example.com/article'"
# }
# ]
# ### Paglalarawan ng Return Value
# Nagbabalik ng diksyunaryo na naglalaman ng pamagat at deskripsyon ng pahina, halimbawa: {'title': 'Example', 'description': 'An example page'}.
# ## function_signature
# def fetch_page_metadata(page_url: str) -> dict:
# ## module_name
# social_media_scraper
# ## context
# walang context
# ## dependencies
# Mangyaring gamitin lamang ang mga built-in na library ng Python at ang mga tahasang nakalista na dependency library sa ibaba kapag gumagawa ng code. Huwag magpakilala ng anumang third-party na library na hindi nakadeklara sa `requirements.txt`.
# - pytest
# - pytest-httpserver
# - certifi
# ## output
# Ilabas ang kumpletong code para sa `src/social_media_scraper/social_media_scraper.py` sa sumusunod na format:
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

# ## code
# ## import
# 1. `import` ang `importlib.import_module`.
# - `importlib.import_module` na `importlib` sa package ng Python.
# - `importlib.import_module` ang `requests` sa package ng Python.
# 2. `from` sa `requests` sa libsang so ng `requests` sa libsang.
# 3. `from` sa `requests.packages.urllib3` sa libsang so ng `requests.packages.urllib3` na libsang.
# 4. `importlib.import_module` sa libsang so ng `social_media_scraper` sa libsang.
# 5. `from` sa `social_media_scraper` sa libsang so ng `social_media_scraper` na libsang.
# 6. `from` sa `requests` sa libsang so ng `urllib3` sa libsang
# 7. `from` sa `requests.packages.urllib3` sa libsang
# 8. `from` sa `social_media_scraper.requests` sa libsang

# ## helper
# 1. `importlib.import_module` ang `requests.packages.urllib3`.
# 2. `from` sa `requests.packages.urllib3` sa libsang
# 3. `from` sa `requests` sa libsang
# 4. `from` sa `social_media_scraper.requests` sa libsang

# ## `requests.packages.urllib3`
# [
# {
# "name": "urllib3",
# "description": "A python wrapper for the urllib3 package"
# }
# ]

# ## `requests`
# [
# {
# "name": "requests",
# "description": "Python Client for Humans. HTTP client for Humans."
# }
# ]

# ## `urllib3`
# [
# {
# "name": "urllib3",
# "description": "Python's implementation of the Request-URI abstraction"
# }
# ]

# ## `social_media_scraper.requests`
# [
# {
# "name": "social_media_scraper.requests",
# "description": "Python Client for Humans. HTTP client for Humans."
# }
# ]

# ## `requests`
# [
# {
# "name": "requests",
# "description": "Python Client for Humans. HTTP client for Humans."
# }
# ]

# ## `urllib3`
# [
# {
# "name": "urllib3",
# "description": "Python's implementation of the Request-URI abstraction"
# }
# ]

# ## `social_media_scraper.requests`
# [
# {
# "name": "social_media_scraper.requests",
# "description": "Python Client for Humans. HTTP client for Humans."
# }
# ]

# ## `requests`
# [
# {
# "name": "requests",
# "description": "Python Client for Humans. HTTP client for Humans."
# }
# ]

# ## `urllib3`
# [
# {
# "name": "urllib3",
# "description": "Python's implementation of the Request-URI abstraction"
# }
# ]

# ## `social_media_scraper.requests`
# [
# {
# "name": "social_media_scraper.requests",
# "description": "Python Client for Humans. HTTP client for Humans."
# }
# ]

# ## `requests`
# [
# {
# "name": "requests",
# "description": "Python Client for Humans. HTTP client for Humans."
# }
# ]

# ## `urllib3`
# [
# {
# "name": "urllib3",
# "description": "Python's implementation of the Request-URI abstraction"
# }
# ]

# ## `social_media_scraper.requests`
# [
# {
# "name": "social_media_scraper.requests",
# "description": "Python Client for Humans. HTTP client for