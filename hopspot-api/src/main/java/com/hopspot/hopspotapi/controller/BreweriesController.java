package com.hopspot.hopspotapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hopspot.hopspotapi.model.Brewery;
import com.hopspot.hopspotapi.service.BreweriesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/breweries/")
public class BreweriesController {

    private final BreweriesService breweriesService;

    public BreweriesController(BreweriesService breweriesService) {
        this.breweriesService = breweriesService;
    }

    @GetMapping("{location}")
    public Mono<List<Brewery>> getAll(@PathVariable String location) throws JsonProcessingException {
        List<Brewery> results = breweriesService.getAllBreweries(location);
        return Mono.just(results);
    }

}
