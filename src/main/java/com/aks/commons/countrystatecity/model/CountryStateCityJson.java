package com.aks.commons.countrystatecity.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryStateCityJson {

    private int id;
    private String name;
    private String iso3;
    private String phone_code;
    private HashMap<String, String> translations;
    private float latitude;
    private float longitude;
    private List<StateCityJson> states;

}
