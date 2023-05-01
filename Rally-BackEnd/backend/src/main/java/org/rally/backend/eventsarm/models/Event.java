package org.rally.backend.eventsarm.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Event extends AbstractEntity {

    @NotBlank(message = "Who can your community thank for hosting this event?")
    private String eventHost;

    @NotBlank(message = "But how will your community know who to contact?")
    @Email(message = "Whoops! Try entering your email again.")
    private String contactEmail;

    private String eventTitle;

    private String datetime;

//    private String datetime;
//@Basic
//private java.time.LocalDateTime localDateTime;

    @NotBlank(message = "But how will your community know where to go?")
    private String eventAddress;

    @ManyToMany
    @JsonManagedReference
    private List<EventCategory> eventCategories;

//    private String eventCategory;

    @NotBlank(message = "Tell your community what this event is all about!")
    private String description;

    public Event(String eventHost, String contactEmail, String eventTitle, String datetime, String eventAddress, List<EventCategory> eventCategories, String description) {
        this.eventHost = eventHost;
        this.contactEmail = contactEmail;
        this.eventTitle = eventTitle;
        this.datetime = datetime;
        this.eventAddress = eventAddress;
        this.eventCategories = eventCategories;
        this.description = description;
    }

    public String getEventHost() {
        return eventHost;
    }

    public void setEventHost(String eventHost) {
        this.eventHost = eventHost;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public List<EventCategory> getEventCategories() {
        return eventCategories;
    }

    public void setEventCategories(List<EventCategory> eventCategories) {
        this.eventCategories = eventCategories;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

//    public String getEventCategory() {
//        return eventCategory;
//    }
//
//    public void setEventCategory(String eventCategory) {
//        this.eventCategory = eventCategory;
//    }


    @Override
    public String toString() {
        return "Event{" +
                "eventHost='" + eventHost + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", eventTitle='" + eventTitle + '\'' +
                ", datetime='" + datetime + '\'' +
                ", eventAddress='" + eventAddress + '\'' +
                ", eventCategories=" + eventCategories +
                ", description='" + description + '\'' +
                '}';
    }
}
