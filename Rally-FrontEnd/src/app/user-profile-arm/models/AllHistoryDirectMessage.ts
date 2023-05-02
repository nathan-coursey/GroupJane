import { DirectMessage } from "./Directmessage";
import { UserEntity } from "./UserEntity";

export class AllHistoryDirectMessage {

    uniqueUserConversations: UserEntity[];
    directMessageList: DirectMessage[];

	constructor(uniqueUserIds: UserEntity[], directMessageList: DirectMessage[]){
        this.uniqueUserConversations = uniqueUserIds;
        this.directMessageList = directMessageList;
	}
}