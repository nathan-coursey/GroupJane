export class LoginDTO {
    userName: String;
	password: String;

	constructor(userName: String, password: String){
		this.userName = userName;
		this.password = password;
	}
}