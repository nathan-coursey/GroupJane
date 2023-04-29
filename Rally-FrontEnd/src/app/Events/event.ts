export class Event {
    eventHost: string;
    contactEmail: string;
    eventTitle: string;   
    // datetime: number;
    eventAddress: string;
    // eventCategory: EventCategory;
    description: string;

    constructor(eventHost: string, contactEmail: string, eventTitle: string, eventAddress: string, description: string) {
        this.eventHost = eventHost;
        this.contactEmail = contactEmail;
        this.eventTitle = eventTitle;
        this.eventAddress = eventAddress;
        this.description = description;
    }

}