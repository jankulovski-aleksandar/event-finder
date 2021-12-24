package com.eventsfinder.event.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
@AllArgsConstructor
@Embeddable
@NoArgsConstructor
public class Location {
    @JsonProperty
    private Long locationId;
    @JsonProperty
    private String country;
    @JsonProperty
    private String city;
    @JsonProperty
    private String address;
    @JsonProperty
    private double latitude;
    @JsonProperty
    private double longitude;
    private String location;
    private String link;
}
