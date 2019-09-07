package com.solstice.cachedemo;

import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class CacheServerController {

    @GetMapping
    public ResponseEntity<String> sayHello() throws InterruptedException {
        Thread.sleep(5000);
        return ResponseEntity.ok()
                .header(HttpHeaders.CACHE_CONTROL,
                        CacheControl.maxAge(10, TimeUnit.SECONDS).cachePublic().getHeaderValue())
                .body("Hi from the Server");
    }
}
