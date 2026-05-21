 client = new OkHttpClient();

    public String fetchUrlContent(String url) throws IOException {
        Request request = new Request.Builder()
               .url(url)
               .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            ResponseBody body = response.body();
            if (body!= null) {
                return body.string();
            } else {
                return "";
            }
        }
    }
}
```


## Uitset Formaat

Voer die volledige reggestelde kode vir `src/main/java/com/example/service/WebContentService.java` uit in die volgende formaat:

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

## Uitset

Voer die volgende uitset in `src/main/resources/application.properties`:

```
application.path=com.example.service.WebContentService
```

## Uitset gebruik

Voer die volgende uitset in `src/main/resources/application.properties`:

```
application.path=com.example.service.WebContentService
```

## Uitset kode

Voer de code uit in `src/main/java/com/example/service/WebContentService.java`:

```xml
public class WebContentService {

    public String fetchUrlContent(String url) {
        try {
            Request request = new Request.Builder()
                   .url(url)
                   .build();

            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            ResponseBody body = response.body();
            if (body!= null) {
                return body.string();
            } else {
                return "";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
```

## Uitset

Voer de code uit in `src/main/java/com/example/service/WebContentService.java`:

```xml
public class WebContentService {

    public String fetchUrlContent(String url) {
        try {
            Request request = new Request.Builder()
                   .url(url)
                   .build();

            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            ResponseBody body = response.body();
            if (body!= null) {
                return body.string();
            } else {
                return "";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
```
