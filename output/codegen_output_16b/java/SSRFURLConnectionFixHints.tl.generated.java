

### Caveat

I-output ay may be in a different format oro ng-format ng mga user na mga editor ng IDE na mayroon. I-output ay magkakay maaari para sa pagpapapapatapad ng user na mga editor ng IDE, mais magkakay para sa pagpapapapatapad ng user na mga editor ng IDE sa sumusunod na file.

## Sample App

```java
package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;
import rx.Subscriber;

public class UrlPreviewService {
  private static final String API_KEY = "";

  private static final String API_ENDPOINT = "http://localhost:3000";

  private final UrlPreviewServiceService service;

  public UrlPreviewService() {
    Retrofit retrofit = new Retrofit.Builder()
       .baseUrl(API_ENDPOINT)
       .addConverterFactory(GsonConverterFactory.create(