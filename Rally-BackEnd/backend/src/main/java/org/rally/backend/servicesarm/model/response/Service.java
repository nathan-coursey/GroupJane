package org.rally.backend.servicesarm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.rally.backend.userprofilearm.model.UserEntity;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

@Entity
@Table(name="service")
public class Service {

    private String name;
    @Id
    @GeneratedValue
    private int id;
    private static int nextId = 1;
    private String service;
    private String description;
    private String category;
    private ArrayList<String> availability = new ArrayList<String> ();
//    private ArrayList<Image> photo = new ArrayList<Image> ();
    private String email;

    public Service(int nextId, String name, String service, String description, String category, ArrayList<String> availability, String email) {
        this.name = name;
        this.nextId = nextId;
        this.service = service;
        this.description = description;
        this.category = category;
        this.availability = availability;
//        this.photo = photo;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public static int getNextId() {
        return nextId;
    }

    public String getService() {
        return service;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public ArrayList<String> getAvailability() {
        return availability;
    }

//    public ArrayList<Image> getPhoto() {
//        return photo;
//    }

    public String getEmail() {
        return email;
    }
}
