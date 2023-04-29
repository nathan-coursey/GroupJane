package org.rally.backend.eventsarm.models;


import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Event extends AbstractEntity {

    @NotBlank(message = "Let your community know who is hosting this event")
    private String eventHost;

    @NotBlank(message = "But how will people know who to contact?")
    @Email(message = "Whoops! Invalid email. Try again!")
    private String contactEmail;

    private String eventTitle;

//    private String datetime;
//@Basic
//private java.time.LocalDateTime localDateTime;

    @NotBlank(message = "But how will people know where to go?")
    private String eventAddress;

    private EventCategory eventCategory;

    @NotBlank(message = "Tell your community what this event is all about!")
    private String description;

    public Event(String eventHost, String contactEmail, String eventTitle, String eventAddress, EventCategory eventCategory, String description) {
        this.eventHost = eventHost;
        this.contactEmail = contactEmail;
        this.eventTitle = eventTitle;
        this.eventAddress = eventAddress;
        this.eventCategory = eventCategory;
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

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventHost='" + eventHost + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", eventTitle='" + eventTitle + '\'' +
                ", eventAddress='" + eventAddress + '\'' +
                ", eventCategory=" + eventCategory +
                ", description='" + description + '\'' +
                '}';
    }
}
