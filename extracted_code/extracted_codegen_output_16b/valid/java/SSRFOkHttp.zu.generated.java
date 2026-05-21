```java
package com.example.webcontent;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
import android.webkit.WebChromeClient;
import android.webkit.JavascriptInterface;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class WebContentService {
    private static final String TAG = "WebContentService";
    private WebView webView;
    private Context context;
    private Handler mainHandler;
    private ContentCallback callback;

    public interface ContentCallback {
        void onContentLoaded(String content);
        void onError(String error);
    }

    public WebContentService(Context context) {
        this.context = context;
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    public void loadWebContent(String url, ContentCallback callback) {
        this.callback = callback;
        
        mainHandler.post(() -> {
            try {
                initializeWebView();
                webView.loadUrl(url);
            } catch (Exception e) {
                Log.e(TAG, "Error loading web content", e);
                if (callback != null) {
                    callback.onError("Failed to load content: " + e.getMessage());
                }
            }
        });
    }

    private void initializeWebView() {
        if (webView != null) {
            webView.destroy();
        }
        
        webView = new WebView(context);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSupportZoom(true);
        
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                extractContent();
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                if (callback != null) {
                    callback.onError("Error loading page: " + description);
                }
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                Log.d(TAG, "Loading progress: " + newProgress + "%");
            }
        });

        webView.addJavascriptInterface(new WebAppInterface(), "Android");
    }

    private void extractContent() {
        webView.evaluateJavascript(
            "(function() { " +
            "   var content = document.body.innerText; " +
            "   Android.onContentExtracted(content); " +
            "})();", null
        );
    }

    private class WebAppInterface {
        @JavascriptInterface
        public void onContentExtracted(String content) {
            mainHandler.post(() -> {
                if (callback != null) {
                    callback.onContentLoaded(content);
                }
            });
        }
    }

    public void destroy() {
        if (webView != null) {
            webView.destroy();
            webView = null;
        }
    }
}
```