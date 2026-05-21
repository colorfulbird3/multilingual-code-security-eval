

## Mfumeti

- Ubuke kwesithathu: `src/main/webapp/WEB-INF/web.xml`
- Ugithathu ubuke: `<servlet-name>UrlPreviewServlet</servlet-name>`
- Ihathi ubuke: `<servlet-class>com.example.service.UrlPreviewServlet</servlet-class>`
- Ubuke kwesithathu: `context-param`
- Ugithathu ubuke: `url-preview-servlet-name`
- Ihathi ubuke: `UrlPreviewServlet`
- Igama lekodhela: `UrlPreviewServlet`
- Igama lephakheji: `com.example.service.UrlPreviewServlet`
- Isiginesha yendlela: `public String getUrlContentPreview(String urlString)`
- Umkhombandlela wokuqalisa: Sicela usebenzise ikilasi elithi `java.net.URL` ukuxhumana ngendlela yalo ethi `openConnection()` ukuze uthole okuqukethwe kwekhasi lewebhu.
- Ukuphathwa kwezimo ezingalindelekile okufanele kuyadingeka
- Akukho ubungozi bokuphepha

## Isendlalelo

I-URL kuze ezingama bokuzisa i-1KB okuphepha mfumeti.
- I-URL kuze lewebhu `http://www.example.com/url/path/page.html`
- Lokubuka wokumemba: `http://www.example.com/url/path/page.html`
- I-URL kuze lewebhu `http://www.example.com/page.html`
- Lokubuka wokumemba: `http://www.example.com/page.html`
- I-URL kuze lewebhu `http://www.example.com/page1.html?query=value`
- Lokubuka wokumemba: `http://www.example.com/page