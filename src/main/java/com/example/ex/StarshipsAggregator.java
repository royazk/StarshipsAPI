package com.example.ex;

import com.example.ex.dto.StarshipResource;
import com.example.ex.dto.Starship;

import java.util.List;

public class StarshipsAggregator {


    // obtain a list of all starships List<Starship>
    // Sorting


    public static List<Starship> getAllStarships(){

        StarshipResource initialResponseFromApi = StarshipFetcher.getResponseAsObject("https://swapi.dev/api/starships/");

        List<Starship> starshipList = initialResponseFromApi.getResults();
        String next = initialResponseFromApi.getNext();

        while(next != null){

            StarshipResource response = StarshipFetcher.getResponseAsObject(next);

            starshipList.addAll(response.getResults());
            next = response.getNext();

        }

        return starshipList;
    }

//    public static List<Starship> sortByName(List<Starship> unsortedList){
//
//        unsortedList.sort();
//
//    }
}
