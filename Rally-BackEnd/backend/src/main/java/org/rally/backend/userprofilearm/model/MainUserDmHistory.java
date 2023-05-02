package org.rally.backend.userprofilearm.model;

import java.util.List;

public class MainUserDmHistory {

    List<UserEntity> userEntities;
    List<DirectMessage> DirectMessageList;

    public MainUserDmHistory(List<UserEntity> userEntities, List<DirectMessage> directMessageList) {
        this.userEntities = userEntities;
        DirectMessageList = directMessageList;
    }

    public List<UserEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(List<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }

    public List<DirectMessage> getDirectMessageList() {
        return DirectMessageList;
    }

    public void setDirectMessageList(List<DirectMessage> directMessageList) {
        DirectMessageList = directMessageList;
    }
}
