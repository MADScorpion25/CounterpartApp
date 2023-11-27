package ru.counterpart.service;

import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Setter
public abstract class AbstractFeignAdapter {
    private String url;

    public <T> T sendRequest(Class<T> classType) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<T> response
                = restTemplate.getForEntity(url, classType);
        return response.getBody();
    }
}
