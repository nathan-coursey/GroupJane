package org.rally.backend.servicesarm.model;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class OfferService {

    private String name;
    private int id;
    private static int nextId = 1;
    private String service;
    private String description;
    private String category;
    private ArrayList<Array> availability = new ArrayList<Array> ();
    private ArrayList<Image> photo = new ArrayList<Image> ();
    private String email;

    public OfferService(String name, int id, String service, String description, String category, ArrayList<Array> availability, ArrayList<Image> photo, String email) {
        this.name = name;
        this.id = id;
        this.service = service;
        this.description = description;
        this.category = category;
        this.availability = availability;
        this.photo = photo;
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

    public ArrayList<Array> getAvailability() {
        return availability;
    }

    public ArrayList<Image> getPhoto() {
        return photo;
    }

    public String getEmail() {
        return email;
    }
}
