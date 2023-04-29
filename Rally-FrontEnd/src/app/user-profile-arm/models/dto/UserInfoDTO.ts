export class UserInfoDTO {
	userName: string;
    firstName: string;
	lastName: string;

	constructor(userName: string, firstName: string, lastName: string){
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}