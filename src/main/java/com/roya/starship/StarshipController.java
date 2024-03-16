package com.roya.starship;

import com.roya.starship.dto.Starship;
import com.roya.starship.dto.StarshipResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StarshipController {

    @Autowired
    private StarshipService starshipService;

    @GetMapping("/allStarships/{sortKey}/{sortOrder}")
    public ResponseEntity<List<Starship>> allStarships(@PathVariable String sortKey, @PathVariable String sortOrder) {
        return new  ResponseEntity<>(starshipService.getAllStarships(sortKey, sortOrder), HttpStatus.OK);
    }
}
