export class RegisterDTO {
    userName: string;
	password: String;
    verifyPassword: String;

	constructor(userName: string, password: String, verifyPassword: String){
		this.userName = userName;
		this.password = password;
        this.verifyPassword = verifyPassword;
	}
}