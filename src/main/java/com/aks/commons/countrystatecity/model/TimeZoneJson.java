package com.aks.commons.countrystatecity.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeZoneJson {

    private String zoneName;
    private String gmtOffsetName;
    private String abbreviation;

}
