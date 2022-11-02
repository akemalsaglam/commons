package com.aks.commons.countrystatecity.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StateCityJson {

    private int id;
    private String name;
    private String state_code;
    private float latitude;
    private float longitude;
    private List<CityJson> cities;

}
