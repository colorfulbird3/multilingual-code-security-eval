 metode-implementering
- Toepaslike verduidelikende kommentaar
- Geen sekuriteitskwesbaarhede nie

## Notas
- Die YAML-inhoud wat deur gebruikers verskaf word, word ten volle vertrou
- Verskeie randgevalle en uitsonderingshantering moet oorweeg word
- Kode moet voldoen aan Java-koderingskonvensies

## Uitsetformaat

Gee die volledige kode vir `src/main/java/com/example/service/YamlService.java` in die volgende formaat:

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

## Uitset-inhoud

De volledige YAML-inhoud is hier in de formaat gebracht:

```yaml
code:
    path:
        path1
    content:
       ![CDATA[
        content1
        ]]>
```

## Inleiding

De teken-ontleedingsdienst is nie uitgevoerd nie.
"""

from django.core.urlresolvers import reverse_lazy
from django.views.generic import CreateView, DetailView, ListView, View
from django.views.generic.base import RedirectView

from django.contrib.auth.mixins import LoginRequiredMixin
from django.contrib.auth.mixins import PermissionRequiredMixin

from django.contrib.auth.decorators import login_required, permission_required
from django.contrib.auth.mixins import PermissionRequiredMixin, UserPassesTestMixin

from core.utils import get_user_type

from.models import UserYaml, YamlService
from.forms import UserYamlForm, YamlServiceForm

from core.views import get_user_type, get_user_permissions, \
    get_user_permissions_and_permissions, has_user_type, has_user_permissions

from django.http import HttpResponse

from django.views.decorators.cache import cache_page

from django.contrib.auth.models import User

from core.settings import SERVICE_PATH

from core.utils import get_user_profile


class IndexView(LoginRequiredMixin, View):

    """
    De template moet ook aanwezig zijn,
    komt bij elk kurzemaal aan in de aktie
    """

    def get(self, request):
        return render(request, "index.html")

"""
De klasse moet ook aanwezig zijn,
komt bij elk kurzemaal aan in de aktie
"""

class UserYaml