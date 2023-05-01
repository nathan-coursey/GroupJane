package org.rally.backend.eventsarm.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import org.rally.backend.eventsarm.models.DTO.EventDTO;

import java.util.ArrayList;
import java.util.List;

@Entity
public class EventCategory extends AbstractEntity {

//    CONNECT("connect"),
//    VOLUNTEER("volunteer"),
//    LEARN("learn"),
//    DONATE("donate"),
//    CELEBRATE("celebrate");

    @NotBlank(message = "What type of event should your community expect?")
    private String eventCategory;

    @ManyToMany(mappedBy = "eventCategories")
    @JsonBackReference
    private final List<EventDTO> events = new ArrayList<>();

    public EventCategory() {}

    public EventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
    }

    public String getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
    }

    public List<EventDTO> getEvents() {
        return events;
    }
}
