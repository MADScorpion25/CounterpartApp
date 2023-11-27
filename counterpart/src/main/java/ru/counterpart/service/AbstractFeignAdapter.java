package ru.counterpart.service;

import lombok.Setter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Setter
public abstract class AbstractFeignAdapter {
    private String url;

    public <T> T sendGetRequest(Class<T> classType) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<T> response
                = restTemplate.getForEntity(url, classType);
        return response.getBody();
    }

    public <T, P> T sendPostRequest(Class<T> classType, P body) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<T> exchange = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(body), classType);
        return exchange.getBody();
    }
}
