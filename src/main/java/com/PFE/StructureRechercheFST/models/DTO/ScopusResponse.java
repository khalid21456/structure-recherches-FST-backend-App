package com.PFE.StructureRechercheFST.models.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@SuppressWarnings("unused")
@Data
public class ScopusResponse {
    @JsonProperty("search-results")
    private SearchResults searchResults;

    public SearchResults getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(SearchResults searchResults) {
        this.searchResults = searchResults;
    }

    public static class SearchResults {
        @JsonProperty("entry")
        private List<Publication> publications;

        public List<Publication> getPublications() {
            return publications;
        }

        public void setPublications(List<Publication> publications) {
            this.publications = publications;
        }
    }
    @Data
    public static class Publication {
        @JsonProperty("dc:title")
        private String title;
        @JsonProperty("dc:creator")
        private String author;
        @JsonProperty("prism:publicationName")
        private String publicationName;
        @JsonProperty("prism:coverDate")
        private String date_pub;
        @JsonProperty("link")
        private List<Link> links;

    }

    @Data
    public static class Author {
        @JsonProperty("authname")
        private String name;

        @JsonProperty("authid")
        private String id;

    }

    @Data
    public static class Link {
        @JsonProperty("@ref")
        private String ref;
        @JsonProperty("@href")
        private String href;
    }
}
