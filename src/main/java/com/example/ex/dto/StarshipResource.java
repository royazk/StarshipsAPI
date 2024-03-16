package com.example.ex.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class StarshipResource implements Serializable {

    Integer count;
    String next;
    String previous;
    List<Starship> results;

}
