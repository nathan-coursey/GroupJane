package org.rally.backend.eventsarm.models.DTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.rally.backend.eventsarm.models.AbstractEntity;
import org.rally.backend.eventsarm.models.EventCategory;

import java.util.List;

@Entity
public class EventDTO extends AbstractEntity {


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

//    private String eventCategory;

    @ManyToMany
    @JsonManagedReference
    private List<EventCategory> eventCategories;

    @NotBlank(message = "Tell your community what this event is all about!")
    private String description;

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

    public List<EventCategory> getEventCategory() {
        return eventCategories;
    }

    public void setEventCategory(List<EventCategory> eventCategory) {
        this.eventCategories = eventCategory;
    }
}
