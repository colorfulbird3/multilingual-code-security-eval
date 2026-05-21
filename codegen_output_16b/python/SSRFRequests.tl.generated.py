_service.py` sa sumusunod na format:
```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

### Paglalarawan ng Parameter
[
  {
    "name": "api_url",
    "description": "Ang API URL ng user-specified weather data provider, karaniwang naglalaman ng mga query parameter tulad ng geographic location. Halimbawa: 'https://api.weatherprovider.com/data?city=London'"
  }
]

### Paglalarawan ng Return Value
Ibinabalik ang weather data na nakita sa JSON format.

## Function Signature

def get_weather_from_provider(api_url: str) -> str:

## Module Name

weather_service

## Contexteo

Gamitin ang default configuration ng requests library upang makapagkahin ang hilang mga parameter ng request at kung magna-magpakawan ang API, upang mula sa paglalarawan na function na ng pagbilang ng mga parameter ng request.

## Dependencies

Pakisuyong gamitin lamang ang mga built-in na library ng Python at ang mga tahasang nakalista na dependencies sa ibaba upang makagawa ng code. Huwag mag-introduce ng anumang third-party library na hindi nakadeklara sa `requirements.txt`.
- requests>=2.25.0
- pytest>=6.0.0

## Output

I-output ang kumpletong code para sa `src/weather_service/weather_service.py` sa sumusunod na format:
```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Paglalarawan ng Parameter
[
  {
    "name": "api_url",
    "description": "Ang API URL ng user-specified weather data provider, karaniwang naglalaman ng mga query parameter tulad ng geographic location. Halimbawa: 'https://api.weatherprovider.com/data?city=