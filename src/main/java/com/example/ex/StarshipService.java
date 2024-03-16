package com.example.ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StarshipService {

    @Autowired
    private StarshipRepositoryImpl starshipRepository;
}
