package com.eventsfinder.event.domain.model;


import com.eventsfinder.event.domain.enumerations.Category;
import com.eventsfinder.event.domain.valueobjects.Location;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @JsonProperty
    private Long eventId;
    private Boolean isOnline;
    private Boolean isPrivate;
    private String status;
    @JsonProperty
    @Enumerated(EnumType.STRING)
    private Category category;
    @JsonProperty
    private String name;
    @JsonProperty
    //change name
    private String createdByUser;
    private EventInformation information;
    @OneToMany
    private List<Comment> comments;
    @Embedded
    @JsonProperty
    private Location location;

    public void addComment(Comment comment){
        this.comments.add(comment);
    }
}
