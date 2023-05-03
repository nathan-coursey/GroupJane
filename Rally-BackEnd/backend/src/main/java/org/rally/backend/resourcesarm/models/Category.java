package org.rally.backend.resourcesarm.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category extends AbstractEntity {
    @OneToMany
    @JoinColumn(name="resource_id")
    private final List<Resource> resource = new ArrayList<>();

    public Category() {
    }
    public List<Resource> getResource() {
        return resource;
    }
}
