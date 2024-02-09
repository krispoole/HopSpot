package com.hopspot.hopspotapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hopspot.hopspotapi.model.Brewery;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class BreweriesService {

        private final RestTemplate restTemplate;
        private final ObjectMapper objectMapper;

        @Value("${external.api.openBrewery}")
        private final String openBreweryApiUrl;

        public BreweriesService(RestTemplate restTemplate, ObjectMapper objectMapper, String openBreweryApiUrl) {
                this.restTemplate = restTemplate;
                this.objectMapper = objectMapper;
                this.openBreweryApiUrl =openBreweryApiUrl;
        }

        public List<Brewery> getAllBreweries(String location) throws JsonProcessingException {

                UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(openBreweryApiUrl)
                        .queryParam("by_dist", location);

                URI uri = builder.build().encode().toUri();

                ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

                List<Brewery> breweries = objectMapper.readValue(response.getBody(), new TypeReference<List<Brewery>>() {});

                return breweries;
        }
}
