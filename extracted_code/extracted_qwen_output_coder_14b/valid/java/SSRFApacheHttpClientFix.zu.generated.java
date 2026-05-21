package com.example.service;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * URL Content Fetching Service
 */
public class UrlService {
    private static final Logger logger = LoggerFactory.getLogger(UrlService.class);

    // Connection timeout (milliseconds)
    private static final int CONNECT_TIMEOUT = 10000;
    // Socket timeout (milliseconds)
    private static final int SOCKET_TIMEOUT = 30000;

    /**
     * Fetches the content from the specified URL
     *
     * @param userUrl the URL string provided by the user
     * @return the response body as a string
     * @throws IOException if an I/O error occurs
     */
    public String fetchUrlContent(String userUrl) throws IOException {
        if (userUrl == null || userUrl.trim().isEmpty()) {
            throw new IllegalArgumentException("URL cannot be null or empty");
        }

        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;

        try {
            httpClient = HttpClients.createDefault();

            RequestConfig config = RequestConfig.custom()
                    .setConnectTimeout(CONNECT_TIMEOUT)
                    .setSocketTimeout(SOCKET_TIMEOUT)
                    .build();

            HttpGet httpGet = new HttpGet(userUrl);
            httpGet.setConfig(config);

            response = httpClient.execute(httpGet);

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                throw new IOException("Failed to fetch content: HTTP status code " + statusCode);
            }

            HttpEntity entity = response.getEntity();
            if (entity == null) {
                throw new IOException("No content found in the response");
            }

            return EntityUtils.toString(entity, "UTF-8");

        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                logger.error("Error closing resources", e);
            }
        }
    }
}