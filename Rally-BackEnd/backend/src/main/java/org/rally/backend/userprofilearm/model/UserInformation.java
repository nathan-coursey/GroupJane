package org.rally.backend.userprofilearm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class UserInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity userEntity = new UserEntity();

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    public UserInformation() {
    }

    public UserInformation(UserEntity userEntity, String firstName, String lastName) {
        this.userEntity = userEntity;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }



}
