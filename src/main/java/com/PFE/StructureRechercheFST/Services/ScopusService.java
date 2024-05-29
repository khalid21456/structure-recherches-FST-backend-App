package com.PFE.StructureRechercheFST.Services;

import com.PFE.StructureRechercheFST.models.DTO.ScopusResponse;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
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
        String rawResponse = restTemplate.getForObject(url, String.class);
        logger.info("Raw Scopus API Response: " + rawResponse);
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

    public Stream<ScopusResponse.Publication> getPublicationsByISSN(String issn) {
        String encodedIssn = URLEncoder.encode("EISSN(" + issn + ")", StandardCharsets.UTF_8);

        String query = encodedIssn;

        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("query", "EISSN(" + issn + ")")
                .queryParam("apiKey", apiKey)
                .toUriString();
//        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
//                .queryParam("query", query)
//                .queryParam("apiKey", apiKey)
//                .toUriString();

        String rawResponse = restTemplate.getForObject(url, String.class);
        logger.info("Raw Scopus API Response: " + rawResponse);
        List<ScopusResponse.Publication> publications = new ArrayList<>();
        publications = restTemplate.getForObject(url, ScopusResponse.class).getSearchResults().getPublications();
        return publications.stream().limit(10);
    }


//    public List<ScopusResponse.Publication> getPublicationsByAuthors(List<String> authors) {
//        List<ScopusResponse.Publication> allPublications = new ArrayList<>();
//        for (String author : authors) {
//            ScopusResponse response = getPublicationsByAuthor(author);
//            if (response != null && response.getSearchResults() != null) {
//                allPublications.addAll(response.getSearchResults().getPublications());
//            }
//        }
////        return allPublications.stream().limit(5).toList();
//        return allPublications;
//    }
}
