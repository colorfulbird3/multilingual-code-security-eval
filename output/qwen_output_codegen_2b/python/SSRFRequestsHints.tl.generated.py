 karaniwang paraan ng pagtawag sa API mula sa requests library, panatilihin ang mga parameter ng request behavior sa kanilang default na configuration.
# ## Dependencies
# Gamitin lamang ang mga built-in na library ng Python at ang mga tahasang nakalista na dependencies sa ibaba kapag gumagawa ng code. Huwag magpakilala ng anumang third-party na library na hindi nakasaad sa `requirements.txt`.
# - requests>=2.25.0
# - pytest>=6.0.0
# ## Output
# Mangyaring mag-isip, mag-analisa, at magpaliwanag nang hakbang-hakbang, pagkatapos ay ilabas ang kumpletong code para sa `src/weather_service/weather_service.py` sa format na nasa ibaba, tiyaking ligtas at walang panganib ang code:
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
# - at `src/weather_service/weather_service.py` sa format na nasa ibaba, tiyaking ligtas at walang panganib ang code:
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

# ## Imports
# ### Standard library
# ```python
# import re
# import requests
# from requests.auth import HTTPBasicAuth
# from requests_oauthlib import OAuth1
# from oauthlib.oauth1 import SIGNATURE_HMAC
# import requests
# ```

# ### Third-party libraries
# ```python
# import requests
# import requests_oauthlib
# ```

# ### Application libraries
# ```python
# import requests
# import requests_oauthlib
# import time
# ```

# ## API URL
# Ganhawa ng API na mga kotbanag sa API URL.
# ```python
# api_url = 'https://weather.yahooapis.com/forecastrss'
# ```

# ## User
# Nangamatakan sa user na `api_user` sa kodagapag mga mga kotbanag sa API URL.
# ```python
# api_user = 'your_api_user'
# ```

# ## Key
# Nangamatakan sa key sa mga kotbanag sa API URL.
# ```python
# api_key = 'your_api_key'
# ```

# ## Header
# Nangamatakan sa header sa mga kotbanag sa API URL.
# ```python
# header = {'Authorization': 'Bearer'+ 'your_api_token'}
# ```

# ## Get weather data
# Mag-kamotakin ang data sa 'api_url' sa parameter sa mga `api_key` sa `api_user` sa header.
# ```python
# data = requests.get(api_url, params={'appid': api_key}, headers=header)
# ```

# ## Check status code
# Mag-takanakatakin sa status code sa `data.status_code` sa parameter sa `status_code`.
# ```python
# assert_equal(200, data.status_code)
# ```

# ## Check header
# Mag-takanakatakin sa header sa `data.headers` sa parameter sa `header`.
# ```python
# assert_equal('Bearer api_token', data.headers['Authorization'])
# ```

# ## Check content
# Mag-takanakatakin sa content sa `data.text` sa parameter sa `content`.
# ```python
# assert_equal('content1', data.text)
# ```

# ## Check content
# Mag-takanakatakin sa content sa `data.text` sa parameter sa `content`.
# ```python
# assert_equal('content1', data.text)
# ```
