import { EventCategory } from "../eventCategory";

export class EventDTO {
    eventHost: string;
    contactEmail: string;
    eventTitle: string;   
    datetime: string;
    eventAddress: string;
    eventCategory: EventCategory[];
    description: string;

    constructor(eventHost: string, contactEmail: string, eventTitle: string, datetime: string, eventAddress: string, eventCategory: EventCategory[], description: string) {
        this.eventHost = eventHost;
        this.contactEmail = contactEmail;
        this.eventTitle = eventTitle;
        this.datetime = datetime;
        this.eventAddress = eventAddress;
        this.eventCategory = eventCategory;
        this.description = description;
    }
}