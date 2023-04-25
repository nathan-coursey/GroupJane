import { Roles } from "./Roles";

export class UserEntity {
    userName: string;
	id: string;
	roles: Roles[];
	constructor(userName: string, id: string, roles: Roles[]){
		this.userName = userName;
		this.id = id;
		this.roles = roles;
	}
}