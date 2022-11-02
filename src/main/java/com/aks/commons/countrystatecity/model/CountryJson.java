package com.aks.commons.countrystatecity.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryJson {

    private int id;
    private String name;
    private String iso3;
    private String phone_code;
    /*private Map<String, String> translations;*/
    private float latitude;
    private float longitude;

}
