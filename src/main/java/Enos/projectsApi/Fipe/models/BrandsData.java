package Enos.projectsApi.Fipe.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record BrandsData(@JsonAlias("code") Integer code,
                         @JsonAlias("name") String name) {
}
