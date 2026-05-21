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