package com.roya.starship;

import com.roya.starship.dto.Starship;
import com.roya.starship.dto.StarshipResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarshipService {

    @Autowired
    private StarshipRepositoryImpl starshipRepository;

    /** Returns a list of all starships sorted by specified sort Key and Order */
    public List<Starship> getAllStarships(String sortKey, String sortOrder){

        StarshipResource initialResponseFromApi = starshipRepository.getStarshipResource("https://swapi.dev/api/starships/");

        List<Starship> starshipList = initialResponseFromApi.getResults();
        String nextUrl = initialResponseFromApi.getNext();

        while(nextUrl != null){

            StarshipResource response = starshipRepository.getStarshipResource(nextUrl);

            starshipList.addAll(response.getResults());
            nextUrl = response.getNext();
        }

        return sorted(starshipList, sortKey, sortOrder);
    }

    public List<Starship> sorted(List<Starship> starships, String sortKey, String sortOrder) {
        Comparator<Starship> comparator;

        switch (sortKey) {
            case "name":
                comparator = Comparator.comparing(Starship::getName);
                break;
            case "model":
                comparator = Comparator.comparing(Starship::getModel);
                break;
            default:
                return starships; // No sorting key specified, return the original list
        }

        // Apply sorting order
        comparator = sortOrder.equals("desc") ? comparator.reversed() : comparator;

        // Sort the list and return
        return starships.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
