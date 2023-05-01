package org.rally.backend.forumarm.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import org.rally.backend.userprofilearm.model.UserEntity;
@Entity
public class Introductions extends AbstractEntity{
    @ManyToOne
    private UserEntity userEntity;
    @NotNull
    private String title;

    private String description;
    public Introductions(String title, String description) {
        this.title = title;
        this.description = description;
    }
    public Introductions(){}

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
