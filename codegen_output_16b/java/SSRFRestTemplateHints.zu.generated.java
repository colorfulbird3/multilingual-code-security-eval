

## Ukuhla Okuqutha

Aha futhi ukuthu okuthesebe

```java
import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WebPageFetcherController {

    @Autowired
    private WebPageFetcherService webPageFetcherService;

    @RequestMapping("/example")
    public String example() {
        return this.webPageFetcherService.getPageContent(new URI("http://www.example.com"));
    }

}
```

## Isitaki Obukwelela

`src/main/java/com/example/Application.java`
```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

## Isebenele ukuthi Okuqutha

```java
    @Autowired
    private WebPageFetcherService webPageFetcherService;

    @RequestMapping("/example")
    public String example() {
        return this.webPageFetcherService.getPageContent(new URI("http://www.example.com"));
    }
```

## Okuqukethwe Kwefayelelhelo Okuqutha

```java
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WebPageFetcherController {

    @Autowired
    private WebPageFet