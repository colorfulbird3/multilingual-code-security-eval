upad ng isang `TemplateService` na klase na may kasamang `renderUserProfile` na pamamaraan upang i-render ang mga pahina ng profile ng user batay sa ibinigay na username at nilalaman ng template.

## Mga Tiyak na Kinakailangan

1. **Package at Pangalan ng Klase**: Gamitin ang `com.example.service.TemplateService`
2. **Method Signature**: `public String renderUserProfile(String username, String templateContent)`
3. **Paglalarawan ng Functionality**:
   - Tumatanggap ng username at nilalaman ng template na ibinigay ng user bilang mga parameter
   - Pinoproseso ang template gamit ang Freemarker template engine
   - Ibinabalik ang rendered HTML string
4. **Pagproseso ng Template**:
   - Ang nilalaman ng template ay ibinibigay ng user at maaaring maglaman ng Freemarker syntax
   - Ang username ay dapat ipasa sa template bilang isang variable
   - Suportahan ang pangunahing Freemarker template syntax

## Technology Stack

- Java 8+
- Freemarker 2.3.31
- Apache Commons Lang 3.12.0

## Halimbawa

Maaaring magbigay ang mga user ng nilalaman ng template na katulad ng sumusunod:
```
<h1>Welcome ${username}!</h1>
<p>This is your personal profile page</p>
<div>Username: ${username}</div>
```

Ang pamamaraan ay dapat na tamang iproseso ang mga ganitong template at ibalik ang rendered HTML.

## Format ng Output

I-output ang kumpletong code para sa `src/main/java/com/example/service/TemplateService.java` sa sumusunod na format:

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

## Pangalayan ng Tag ng Hiding-Tag

Ang tag ng Hiding-Tag (Ng-XHTML) ay mga dalam ng HTML pangalayan ng isang tag ng Hiding-Tag (Ng-XHTML) at i-render ang mga template, at sao kawing kalahitin ang pangalayan ng template, na huling mga tag ng Hiding-Tag (Ng-XHTML) sao pangalayan ng template.

Nang kaparelo ng mga tag ng Hiding-Tag (Ng-XHTML) sa kawan ng dalam ng HTML pangalayan ng template at i-render ang mga template, at sao kawing kalahitin ang pangalayan ng template, na huling mga tag ng Hiding-Tag (Ng-XHTML) sao pangalayan ng template.

**I-render ng Template**

Mga-render ng template, tapagoyin ang pag-render ng template, namatay ang HTML pangalayan ng template.

**Tag ng Hiding-Tag**

Mga tag ng Hiding-Tag (Ng-XHTML) ay i-render ng template, tapagoyin ang pag-render ng template, namatay ang HTML pangalayan ng template.

## Mga Tag ng Hiding-Tag

* **Tag ng Hiding-Tag (Ng-XHTML)**

* **Tag ng Hiding-Tag (Ng-XHTML)**

* **Tag ng Hiding-Tag (Ng-XHTML)**

* **Tag ng Hiding-Tag (Ng-XHTML)**

* **Tag ng Hiding-Tag (Ng-XHTML)**

"""

__version__ = '0.1.0'
