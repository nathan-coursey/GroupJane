import { NgForm } from "@angular/forms";

export class Event {
    id: number;
    eventHost: string;
    contactEmail: string;
    eventTitle: string;   
    datetime: string;
    eventAddress: string;
    eventCategory: string;
    // eventCategory: Object [];
    // =  [
    //     {id: '1', value: 'connect'},
    //     {id: '2', value: 'volunteer'},
    //     {id: '3', value: 'learn'},
    //     {id: '4', value: 'donate'},
    //     {id: '5', value: 'celebrate'}
    // ];
    description: string;

    constructor(id: number, eventHost: string, contactEmail: string, eventTitle: string, datetime: string, eventAddress: string, eventCategory: string, description: string) {
        this.id = id;
        this.eventHost = eventHost;
        this.contactEmail = contactEmail;
        this.eventTitle = eventTitle;
        this.datetime = datetime;
        this.eventAddress = eventAddress;
        this.eventCategory = eventCategory;
        this.description = description;
    }

}