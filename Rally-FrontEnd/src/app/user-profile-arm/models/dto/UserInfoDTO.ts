export class UserInfoDTO {
	userId: string;
    firstName: string;
	lastName: string;
	neigborhood: string;
    city: string;
	state: string;

	constructor(userId: string, firstName: string, lastName: string, neigborhood: string, city: string, state: string){
		this.userId = this.userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.neigborhood = neigborhood;
		this.city = city;
		this.state = state;
	}
}