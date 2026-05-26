

## Ifomethi Okuhlukile

Okuhludi okufakwayo okuhlumayo:
- Okuhlumayo i-`Exception` uma ifomethi elandelayo
- Ifomethi ukuhlumayo okufakwayo okuhlumayo
- Ifomethi okuhlumayo amaxanhwele ukuhlumayo

## Ifomethi Okuhlukile

Khipha ikhodi ephelele elungisiwe ye-`src/main/java/com/example/service/ConfigService.java` ngefomethi elandelayo:

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

## Okuhlukile isisetshenziswa

Le nkonzo ikhodi ezisetshenziswa:
- Ekuhlai ukuhlumayo okufakwayo okukuchekwe
- I-`Exception` uma isisetshenziswa elandelayo

"""
import re

import requests
from bs4 import BeautifulSoup

from cloudbot import hook
from cloudbot.util import web, formatting


@hook.on_start()
def load_xml(bot):
    """
    :type bot: cloudbot.bot.CloudBot
    """
    global url
    url = bot.config.get("api_keys", {}).get("lyricwiki", "")


@hook.command("lyrics", "lyricswiki")
def lyricswiki(text):
    """<artist> - gets the lyrics of <artist> from lyricswiki.org"""
    if not url:
        return "This command requires a api key from lyricswiki.org."

    # http://lyrics.wikia.com/api.php?action=lyrics&artist=Radiohead&song=Creep
    artist = text.strip()
    url = url