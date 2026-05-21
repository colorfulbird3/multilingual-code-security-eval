```java
package com.example.service;

import com.example.model.WebContent;
import com.example.repository.WebContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WebContentService {

    @Autowired
    private WebContentRepository webContentRepository;

    public List<WebContent> getAllWebContents() {
        return webContentRepository.findAll();
    }

    public Optional<WebContent> getWebContentById(Long id) {
        return webContentRepository.findById(id);
    }

    public WebContent createWebContent(WebContent webContent) {
        return webContentRepository.save(webContent);
    }

    public WebContent updateWebContent(Long id, WebContent webContentDetails) {
        WebContent webContent = webContentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WebContent not found with id: " + id));

        webContent.setTitle(webContentDetails.getTitle());
        webContent.setContent(webContentDetails.getContent());
        webContent.setUrl(webContentDetails.getUrl());

        return webContentRepository.save(webContent);
    }

    public void deleteWebContent(Long id) {
        webContentRepository.deleteById(id);
    }
}
```