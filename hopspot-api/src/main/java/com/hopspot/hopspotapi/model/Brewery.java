package com.hopspot.hopspotapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Brewery {

    private String id;
    private String name;

    @JsonProperty("brewery_type")
    private String breweryType;

    @JsonProperty("address_1")
    private String address1;

    @JsonProperty("address_2")
    private String address2;

    @JsonProperty("address_3")
    private String address3;

    private String city;

    @JsonProperty("state_province")
    private String stateProvince;

    @JsonProperty("postal_code")
    private String postalCode;

    private String country;
    private String longitude;
    private String latitude;
    private String phone;

    @JsonProperty("website_url")
    private String websiteUrl;

    private Hours hours;
}
