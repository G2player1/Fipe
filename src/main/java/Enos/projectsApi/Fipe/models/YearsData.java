package Enos.projectsApi.Fipe.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record YearsData(@JsonAlias("name") String name,
                        @JsonAlias("code") String code) {

}
