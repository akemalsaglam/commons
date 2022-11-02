package com.aks.commons.countrystatecity.service;

import com.aks.commons.countrystatecity.model.CountryStateCityJson;
import com.aks.commons.countrystatecity.model.StateCityJson;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class CountryStateCityService {

    public static final String COUNTRY_STATE_CITY_DB_JSON_FILE = "country-state-city-db.json";
    private List<CountryStateCityJson> countryStateCity;
    private static final String DEFAULT_LANGUAGE = "en";
    private static final String CURRENT_LANGUAGE = "tr";

    @PostConstruct
    private void init() throws IOException {
        ObjectMapper mapper =
                new ObjectMapper()
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        InputStream inputStream =
                new ClassPathResource(COUNTRY_STATE_CITY_DB_JSON_FILE).getInputStream();
        countryStateCity = mapper.readValue(inputStream, new TypeReference<>() {
        });
    }

    public List<CountryStateCityJson> getCountryStateCity() {
        return countryStateCity;
    }

    public String getCountryNameByCode(String iso3CountryCode) {
        if (StringUtils.isEmpty(iso3CountryCode)) return "";
        final Optional<CountryStateCityJson> countryStateCityJson =
                countryStateCity.stream()
                        .filter(item -> item.getIso3().equals(iso3CountryCode))
                        .findFirst();
        if (countryStateCityJson.isPresent()) {
            return getCountryName(countryStateCityJson.get());
        } else {
            return "";
        }
    }

    public String getStateNameByCode(String iso3CountryCode, String stateCode) {
        if (StringUtils.isEmpty(iso3CountryCode) || StringUtils.isEmpty(stateCode)) return "";
        final Optional<CountryStateCityJson> countryStateCityJson =
                countryStateCity.stream()
                        .filter(item -> item.getIso3().equals(iso3CountryCode))
                        .findFirst();
        if (countryStateCityJson.isPresent()) {
            final Optional<StateCityJson> stateCityJson =
                    countryStateCityJson.get().getStates().stream()
                            .filter(item -> item.getState_code().equals(stateCode))
                            .findFirst();
            if (stateCityJson.isPresent()) {
                return stateCityJson.get().getName();
            }
        }
        return "";
    }

    public String getCountryName(CountryStateCityJson item) {
        final HashMap<String, String> translations = item.getTranslations();
        if (translations.size() > 0) {
            if (translations.get(CURRENT_LANGUAGE) != null) {
                return translations.get(CURRENT_LANGUAGE);
            } else {
                return translations.get(DEFAULT_LANGUAGE);
            }
        }
        return item.getName();
    }
}
