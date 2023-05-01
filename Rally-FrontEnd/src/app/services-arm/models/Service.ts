export class ServiceDTO {
    userName: string;
	description: string;
    category: string;
    days: string[];
    email: string;
    service: string;
    time: string;


	constructor(userName: string, description: string, category: string, days: string[], email: string, service: string, time: string){
        this.userName = userName;
		this.description = description;
        this.category = category;
        this.days = days;
        this.email = email;
        this.service = service;
        this.time = time;

	}
}