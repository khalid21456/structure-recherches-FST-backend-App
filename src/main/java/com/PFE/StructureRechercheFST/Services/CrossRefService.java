package com.PFE.StructureRechercheFST.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@Service
@SuppressWarnings("unused")
public class CrossRefService {

    private final RestTemplate restTemplate;

    public CrossRefService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Map<String, Object>> getPublicationsByAuthor(String author) {
        String url = "https://api.crossref.org/works";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("query.author", author)
                .queryParam("rows", 10);

        Map<String, Object> response = restTemplate.getForObject(builder.toUriString(), Map.class);

        List<Map<String, Object>> items = (List<Map<String, Object>>) ((Map<String, Object>) response.get("message")).get("items");

        return items;
    }
}