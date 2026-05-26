


## Gebruikersdoel

Ons voorgrond funksie het 'n webbladinhoud van 'n URL uit te halen en die data weer te sturen.

## Voorbeeld

```java
import com.example.service.WebContentService;

WebContentService webContentService = new WebContentService();

String urlContent = webContentService.fetchUrlContent("https://www.google.com");

System.out.println(urlContent);
```

### Gebruik

Hierdie funksie word gebruik in een web server die die URL-inhoud afspees.

## Gebruik

```java
public class Service {

    public String fetchUrlContent(String url) throws IOException {
        WebContentService webContentService = new WebContentService();
        return webContentService.fetchUrlContent(url);
    }
}
```

## Opslag

We gaan op te slaan die webblaad. Deze wordt toegevoegd in een jar-bestand die wordt aanwezig gestopt voor jouw gebruik.

```sh
mv /home/.../serviceloader/target/serviceloader-0.0.1-SNAPSHOT.jar /home/.../serviceloader/target/serviceloader-0.0.1-SNAPSHOT.jar.bak
javac -d /home/.../serviceloader/target/serviceloader-0.0.1-SNAPSHOT.jar /home/.../serviceloader/src/main/java/com/example/service/WebContentService.java
jar -uf /home/.../serviceloader/target/serviceloader-0.0.1-SNAPSHOT.jar /home/.../serviceloader/target/serviceloader-0.0.1-SNAPSHOT.jar.bak -C /home/.../serviceloader/target/serviceloader-0.0