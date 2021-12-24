package com.eventsfinder.event.domain.model;


import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.print.attribute.Attribute;

@Embeddable
@NoArgsConstructor
public class EventInformation {
    @Embedded
    private Contact contact;
    private String description;
}
@Embeddable
class Contact{
    @Column(name = "contact_name")
    private String name;
    private String phoneNumber;
    private String email;
}
