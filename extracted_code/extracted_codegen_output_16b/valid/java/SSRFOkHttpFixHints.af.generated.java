import com.example.service.WebContentService;

WebContentService webContentService = new WebContentService();

String urlContent = webContentService.fetchUrlContent("https://www.google.com");

System.out.println(urlContent);