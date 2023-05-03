package org.rally.backend.resourcesarm.models;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;

import java.util.ArrayList;


public class ResourceData {
    public static ArrayList<Resource> findByColumnAndValue(String column, String value, Iterable<Resource>allResources) {
        ArrayList<Resource> results = new ArrayList<>();
        if (value.toLowerCase().equals("all")){
            return (ArrayList<Resource>) allResources;
        }
        if (column.equals("all")){
            results = findByValue(value, allResources);
            return results;
        }
        for (Resource resource: allResources) {
            String aValue = getFieldValue(resource, column);
            if (aValue !=null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(resource);
            }
        }
        return results;
    }

    public static String getFieldValue(Resource resource, String fieldName){
        String theValue;
        if (fieldName.equals("name")){
            theValue = resource.getName();
        } else {
            theValue = resource.getCategory().toString();
        }
        return theValue;
    }


//find by value method
    private static ArrayList<Resource> findByValue(String value, Iterable<Resource> allResources) {
        String lower_val = value.toLowerCase();
        ArrayList<Resource> results = new ArrayList<>();
        for (Resource resource : allResources){
            if (resource.getName().toLowerCase().contains(lower_val)){
                results.add(resource);
            } else if(resource.getCategory().toString().toLowerCase().contains(lower_val)){
                results.add(resource);
            } else if(resource.toString().toLowerCase().contains(lower_val)){
                results.add(resource);
            }
        }
        return results;
    }
}
