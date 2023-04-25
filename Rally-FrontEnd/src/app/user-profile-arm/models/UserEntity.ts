export class UserEntity {
    userName: string;
	id: string;
	role: string[];
	constructor(userName: string, id: string, role: string[]){
		this.userName = userName;
		this.id = id;
		this.role = role;
	}
}