package com.PFE.StructureRechercheFST.Services;

import com.PFE.StructureRechercheFST.models.DTO.ScopusResponse;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
@Log
@SuppressWarnings("unused")
public class ScopusService {

    @Value("${scopus.api.key}")
    private String apiKey;

    @Value("${scopus.api.url}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = Logger.getLogger(ScopusService.class.getName());
//    public ScopusService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

    public ScopusResponse getPublicationsByAuthor(String authorName) {
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("query", "AUTHOR-NAME(" + authorName + ")")
                .queryParam("apiKey", apiKey)
                .toUriString();
        String rawResponse = restTemplate.getForObject(url, String.class);
        logger.info("Raw Scopus API Response: " + rawResponse);
        return restTemplate.getForObject(url, ScopusResponse.class);
    }

    public List<ScopusResponse.Publication> getPublicationsByAuthors(List<String> authors) {
        List<ScopusResponse.Publication> allPublications = new ArrayList<>();
        for (String author : authors) {
            ScopusResponse response = getPublicationsByAuthor(author);
            if (response != null && response.getSearchResults() != null) {
                allPublications.addAll(response.getSearchResults().getPublications());
            }
        }
        return allPublications;
    }
}
