package com.roya.starship;

import com.roya.starship.dto.StarshipResource;

public interface StarshipRepository {

    StarshipResource getStarshipResource(String url);

}
