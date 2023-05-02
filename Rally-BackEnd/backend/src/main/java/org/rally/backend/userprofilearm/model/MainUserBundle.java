package org.rally.backend.userprofilearm.model;

import java.util.Optional;

public class MainUserBundle {

    UserEntity mainUser;
    Optional<UserInformation> viewUserInformation;

    MainUserDmHistory mainUserDmHistory;

    public MainUserBundle(UserEntity mainUser, Optional<UserInformation> viewUserInformation, MainUserDmHistory mainUserDmHistory) {
        this.mainUser = mainUser;
        this.viewUserInformation = viewUserInformation;
        this.mainUserDmHistory = mainUserDmHistory;
    }

    public UserEntity getMainUser() {
        return mainUser;
    }

    public void setMainUser(UserEntity mainUser) {
        this.mainUser = mainUser;
    }

    public Optional<UserInformation> getViewUserInformation() {
        return viewUserInformation;
    }

    public void setViewUserInformation(Optional<UserInformation> viewUserInformation) {
        this.viewUserInformation = viewUserInformation;
    }

    public MainUserDmHistory getMainUserDmHistory() {
        return mainUserDmHistory;
    }

    public void setMainUserDmHistory(MainUserDmHistory mainUserDmHistory) {
        this.mainUserDmHistory = mainUserDmHistory;
    }
}
