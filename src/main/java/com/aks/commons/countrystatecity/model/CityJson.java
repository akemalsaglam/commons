package com.aks.commons.countrystatecity.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityJson {

    private int id;
    private String name;
    private double latitude;
    private double longitude;

}
