package com.eventfinder.location.domain.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Location {

    @Id
    private Long id;
    @JsonProperty
    private String name;
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
    @JsonProperty
    private List<Long> events;

}
