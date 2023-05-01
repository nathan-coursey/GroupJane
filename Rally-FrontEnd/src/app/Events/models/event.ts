import { EventCategory } from "./eventCategory";

export class Event {
    id: number;
    eventHost: string;
    contactEmail: string;
    eventTitle: string;   
    datetime: string;
    eventAddress: string;
    eventCategory: EventCategory[];
    description: string;

    constructor(id: number, eventHost: string, contactEmail: string, eventTitle: string, datetime: string, eventAddress: string, eventCategory: EventCategory[], description: string) {
        this.id = id;
        this.eventHost = eventHost;
        this.contactEmail = contactEmail;
        this.eventTitle = eventTitle;
        this.datetime = datetime;
        this.eventAddress = eventAddress;
        this.eventCategory = eventCategory;
        this.description = description;
    }

    getFormattedEventCategories(): string {
        let eventCategories = "";
        for(let i=0; i < this.eventCategory.length; i++) {
            eventCategories += this.eventCategory[i].eventCategory;
            if(i < this.eventCategory.length -1) {
                eventCategories +=", ";
            }
        }
        return eventCategories;
    }

}