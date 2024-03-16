package com.example.ex;

import com.example.ex.dto.StarshipResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class StarshipFetcher {

    public static ResponseEntity<String> getResponse() {

        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "https://swapi.dev/api/starships/";

        return restTemplate.getForEntity(fooResourceUrl, String.class);
    }

    public static StarshipResource getResponseAsObject(String url) {

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, StarshipResource.class);

    }
}
