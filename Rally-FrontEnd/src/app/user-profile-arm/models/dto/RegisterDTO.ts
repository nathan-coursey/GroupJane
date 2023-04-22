export class RegisterDTO {
    userName: String;
	password: String;
    verifyPassword: String;

	constructor(userName: String, password: String, verifyPassword: String){
		this.userName = userName;
		this.password = password;
        this.verifyPassword = verifyPassword;
	}
}