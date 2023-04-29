export class Event {
    id: number;
    eventHost: string;
    contactEmail: string;
    eventTitle: string;   
    // datetime: number;
    eventAddress: string;
    // eventCategory: EventCategory;
    description: string;

    constructor(id: number, eventHost: string, contactEmail: string, eventTitle: string, eventAddress: string, description: string) {
        this.id = id;
        this.eventHost = eventHost;
        this.contactEmail = contactEmail;
        this.eventTitle = eventTitle;
        this.eventAddress = eventAddress;
        this.description = description;
    }

}