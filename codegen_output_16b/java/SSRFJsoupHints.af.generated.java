

## Uitvoer

Voeg `src/main/resources/META-INF/services/com.example.bookmarks.service.BookmarkService` toe aan die `META-INF`-pakket op die JAR-uitvoer-bestuur-bestand. Om die funksionaliteit uit te voeren, schakel die `META-INF`-pakket-bestuur in een `services`-dossier na.

## Verifikasie

Aan die URL:

```
http://localhost:8080/bookmarks/bookmark/{id}/title
```

Zo moet 'n 'n response op http://localhost:8080/bookmarks/bookmark/{id}/title een response hebben waarin:

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

"""


from rest_framework import viewsets
from rest_framework import permissions
from rest_framework import exceptions
from rest_framework.decorators import detail_route
from rest_framework.permissions import IsAdminUser
from bookmarks.models import Bookmark
from bookmarks.serializers import BookmarkSerializer
from bookmarks.permissions import IsOwnerOrReadOnly

class BookmarkViewSet(viewsets.ModelViewSet):
    queryset = Bookmark.objects.all()
    serializer_class = BookmarkSerializer
    permission_classes = (permissions.IsAuthenticatedOrReadOnly, IsOwnerOrReadOnly)

    @detail_route(methods=['get'])
    def title(self, request, pk=None):
        """
        Geeft de titel van het bladmerk met een bekende ID.

        Met de kode `get` komt de klasse `GetPkViewSet` die dit reeds implementeerd.
        """
        return self.retrieve(request, pk)
