`` withI amwenyela by @w365, an AI designed to assist












 IsengalaleleUqofe ueklakhohleniso euweqhuswa kweihwaziu, ingqehhuswa kwe-URL. Thulisaile kthab wethokHttp.

## Nkuthqhuswe kwe-URL

Bash ukhlanugakah k-URL ukacisiwe, ukokiningo

Ukuthi uushelalelewe URLayok-Ok, yauela ukuthi-Okqhuseni ukahokohweiphis uk-URLukh##java
// com.example.service;

import okhttp3.*;

HttpClient;
import okhttp3.Request;
import okhttp3.Call;

import org.json.JSONObject;

import java.io.IOException;

public class WebContentService {

    public static String client = new OkHttpClient();

    public String fetchUrlContent(String url) throws IOException {
        Request request = new Request.Builder()
                .get(url)
                .build();

        Response (Response response = client.newCall(request).execute()) {
                return (!response.isSuccessful()) {
                throw new IOException("Failed code " + response);
            }

            return response.body = response.body();
            if (body == null) {
                return body.string();
        }
 else {
            return "";
            }
    }
}
}
````