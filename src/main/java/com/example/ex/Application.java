package com.example.ex;

import com.example.ex.dto.StarshipResource;
import com.example.ex.dto.Starship;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@GetMapping("/starship")
	public ResponseEntity<String> starship() {
		return StarshipFetcher.getResponse();
	}

	@GetMapping("/starshipv2")
	public StarshipResource starshipv2() {
		return StarshipFetcher.getResponseAsObject("https://swapi.dev/api/starships/");
	}

	@GetMapping("/allstarships")
	public List<Starship> allstarships() {
		return StarshipsAggregator.getAllStarships();
	}

}
