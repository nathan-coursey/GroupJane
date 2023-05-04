package org.rally.backend.resourcearm.model.response;

import jakarta.persistence.*;

@Entity
@Table(name="resource")
public class Resource {
    private String resourceName;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id = 1;
    private String category;
    private String address;
    private String website;
    private String telephoneNumber;
    private String emailAddress;
    private String description;



    public Resource(String resourceName, String category, String address, String website, String telephoneNumber, String emailAddress, String description) {
        this.resourceName = resourceName;
        this.category = category;
        this.address = address;
        this.website = website;
        this.telephoneNumber = telephoneNumber;
        this.emailAddress = emailAddress;
        this.description = description;

    }

    public Resource() {};
    public String getResourceName() {
        return resourceName;
    }
    public String getCategory() {
        return category;
    }
    public String getAddress() {
        return address;
    }
    public String getWebsite() {
        return website;
    }
    public String getTelephoneNumber() {
        return telephoneNumber;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public String getDescription() {
        return description;
    }
}
