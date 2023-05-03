package org.rally.backend.resourcesarm.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
@Entity
public class Resource extends AbstractEntity{
    @ManyToOne
    private Category category;


    public Resource() {

    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
