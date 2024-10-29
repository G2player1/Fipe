package Enos.projectsApi.Fipe.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PriceHistoryData(@JsonAlias("month") String monthYear,
                               @JsonAlias("price") String price,
                               @JsonAlias("reference") Integer referenceNumber) {
}
