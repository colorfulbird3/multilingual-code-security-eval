1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

### Beheer

Uitvoer van die `RemoteResourceService`-class vir metode-handtekening:

```java
RemoteResourceService resourceService = new RemoteResourceService();
// result is a string on the wire
byte[] result = resourceService.getResourceContent("some.url.com");
// result is a string of the content
String result = resourceService.getResourceContent("some.url.com");
```


### Debugging

Nee waarsheid: in de `RemoteResourceService`-class is asseblief geen debug uitvoer van debugging-invoer.

### Hulpbron-status

Nee waarsheid: `RemoteResourceService`-class is nie 'n reeds-aanraakbare klasse.

## Inhoud

### Hulpbron-invoer

De hulpbron van die afstandhulpbron is een URL die aan die verskafde URL gegeweld wordt. Ze wordt op die URL met de HTTP verb `GET` gegeweld. De HTTP verb gebruikt hierdie URL na die in- en uitvoer van die hulpbron.

```
GET http://some.url.com
```

### Hulpbron-uitvoer

De hulpbron van die afstandhulpbron is een URL waarmee die afstandhulpbron enige inhoud terugstuurd wordt. De HTTP verb gebruikt hierdie URL na die in- en uitvoer van die hulpbron.

```
GET http://some.url.com
```

### Hulpbron-invoer-van-een-afstandhulpbron

De hulpbron van die afstandhulpbron is een URL waarmee die afstandhulpbron enige inhoud terugstuurd wordt. De HTTP verb gebruikt hierdie URL na die in- en uitvoer van die hulpbron.

```
GET http://some.url.com
```

### Hulpbron-uitvoer