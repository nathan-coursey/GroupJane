import { UserEntity } from "./UserEntity";

export class UserInformation {

    id: number;
    user: UserEntity;
    firstName: string;
    lastName: string;
    
	constructor(id: number, user: UserEntity, firstName: string, lastName: string){
		this.id = id;
        this.user = user;
		this.firstName = firstName;
        this.lastName = lastName;
	}
}