import { AllHistoryDirectMessage } from "./AllHistoryDirectMessage";
import { UserEntity } from "./UserEntity";
import { UserInformation } from "./UserInformation";

export class MainUserBundle {
	mainUser: UserEntity;
	viewUserInformation: UserInformation;
	mainUserDmHistory: AllHistoryDirectMessage;


	constructor(mainUser: UserEntity, mainUserInformation: UserInformation, thisUserDirectMessages: AllHistoryDirectMessage){
		this.mainUser = mainUser,
		this.viewUserInformation = mainUserInformation,
		this.mainUserDmHistory = thisUserDirectMessages
	}
}