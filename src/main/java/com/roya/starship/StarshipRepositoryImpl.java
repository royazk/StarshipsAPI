package com.roya.starship;

import com.roya.starship.dto.StarshipResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class StarshipRepositoryImpl implements StarshipRepository {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public StarshipResource getStarshipResource(String url) {
        return restTemplate.getForObject(url, StarshipResource.class);
    }
}
