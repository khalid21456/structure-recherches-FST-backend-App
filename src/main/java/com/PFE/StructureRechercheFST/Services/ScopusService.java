package com.PFE.StructureRechercheFST.Services;

import com.PFE.StructureRechercheFST.models.DTO.ScopusResponse;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.stream.Stream;

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


    public Stream<ScopusResponse.Publication> getPublicationsByAuthor(String authorName) {
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("query", "AUTHOR-NAME(" + authorName + ")")
                .queryParam("apiKey", apiKey)
                .toUriString();
        List<ScopusResponse.Publication> publications = new ArrayList<>();
        publications = restTemplate.getForObject(url, ScopusResponse.class).getSearchResults().getPublications();
        return publications.stream().limit(10);
    }

    public Stream<ScopusResponse.Publication> getPublicationsByAuthorAndAffiliation(String authorName, String affiliationName) {
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("query", "AUTHOR-NAME(" + authorName + ") AND AFFIL(" + affiliationName + ")")
                .queryParam("apiKey", apiKey)
                .toUriString();
        String rawResponse = restTemplate.getForObject(url, String.class);
        logger.info("Raw Scopus API Response: " + rawResponse);
        List<ScopusResponse.Publication> publications = new ArrayList<>();
        publications = restTemplate.getForObject(url, ScopusResponse.class).getSearchResults().getPublications();
        return publications.stream().limit(10);
    }

    public ScopusResponse getPublicationsByAuthorAndAffiliation2(String authorName, String affiliationName) {
        String encodedAuthorName = URLEncoder.encode("AUTHOR-NAME(" + authorName + ")", StandardCharsets.UTF_8);
        String encodedAffiliationName = URLEncoder.encode("AFFIL(" + affiliationName + ")", StandardCharsets.UTF_8);

        String query = encodedAuthorName + " AND " + encodedAffiliationName;

        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("query", query)
                .queryParam("apiKey", apiKey)
                .toUriString();
        logger.info("Request URL: " + url);

        String jsonResponse = restTemplate.getForObject(url, String.class);
        logger.info("Response: " + jsonResponse);

        // Convert JSON response to ScopusResponse object
        return restTemplate.getForObject(url, ScopusResponse.class);
    }


    public ScopusResponse getPublicationsByAuthorError(String author) {
        String encodedIssn = URLEncoder.encode("AUTHOR-NAME(" + author + ")", StandardCharsets.UTF_8);

        String query = encodedIssn;

        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("query", query)
                .queryParam("apiKey", apiKey)
                .toUriString();

        logger.info("Request URL: " + url);

        for (int i = 0; i < 3; i++) { // Retry up to 3 times
            try {
                ResponseEntity<ScopusResponse> response = restTemplate.getForEntity(url, ScopusResponse.class);
                if (response.getStatusCode().is2xxSuccessful()) {
                    return response.getBody();
                } else {
                    logger.info("Received non-2xx response: " + response.getStatusCode());
                }
            } catch (Exception e) {
                if (i < 2) {
                    try {
                        TimeUnit.SECONDS.sleep(2); // Wait 2 seconds before retrying
                    } catch (InterruptedException interruptedException) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        return null; // Return null or throw an exception if all retries fail
    }
}

