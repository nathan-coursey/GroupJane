package org.rally.backend.userprofilearm.model.dto;

import jakarta.validation.constraints.NotNull;

public class UserInfoDTO {

    @NotNull
    private String userName;

    @NotNull
    private String FirstName;

    @NotNull
    private String LastName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
