package org.rally.backend.eventsarm.models;

public class Event extends AbstractEntity {

    private String eventHost;

    private String contactEmail;

    private String eventTitle;

//    private String datetime;

    private String eventAddress;

    private EventCategory eventCategory;

    public Event(String eventHost, String contactEmail, String eventTitle, String eventAddress, EventCategory eventCategory) {
        this.eventHost = eventHost;
        this.contactEmail = contactEmail;
        this.eventTitle = eventTitle;
        this.eventAddress = eventAddress;
        this.eventCategory = eventCategory;
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

    @Override
    public String toString() {
        return "Event{" +
                "eventHost='" + eventHost + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", eventTitle='" + eventTitle + '\'' +
                ", eventAddress='" + eventAddress + '\'' +
                ", eventCategory=" + eventCategory +
                '}';
    }
}
