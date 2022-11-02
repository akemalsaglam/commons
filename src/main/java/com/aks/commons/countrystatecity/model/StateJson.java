package com.aks.commons.countrystatecity.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StateJson {

    private int id;
    private String name;
    private String state_code;
    private float latitude;
    private float longitude;

}
