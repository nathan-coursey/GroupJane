import { UserEntity } from "src/app/user-profile-arm/models/UserEntity";


export class ForumPostDTO {
    title: string;
	description: string;
	username: string;

	constructor(title: string, description: string, username: string){
		this.title = title;
		this.description = description;
		this.username = username;
	}
}