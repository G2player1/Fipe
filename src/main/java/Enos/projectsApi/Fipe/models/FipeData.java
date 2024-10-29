package Enos.projectsApi.Fipe.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FipeData(@JsonAlias("brand") String brandName,
                       @JsonAlias("codeFipe") String codeFipe,
                       @JsonAlias("fuel") String fuelType,
                       @JsonAlias("fuelAcronym") String fuelAcronym,
                       @JsonAlias("model") String modelName,
                       @JsonAlias("modelYear") Integer modelYear,
                       @JsonAlias("price") String price,
                       @JsonAlias("priceHistory") List<PriceHistoryData> priceHistory,
                       @JsonAlias("referenceMonth") String referenceMonth,
                       @JsonAlias("vehicleType") Integer vehicleType){

}
