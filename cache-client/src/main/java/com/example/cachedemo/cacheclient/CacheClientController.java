package com.example.cachedemo.cacheclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CacheClientController {

    private RestTemplate restTemplate;

    public CacheClientController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(path="/")
    public String sayHi() {
        return "from the server: " + restTemplate.getForObject("http://localhost:8080", String.class);
    }
}
