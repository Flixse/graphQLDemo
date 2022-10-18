package be.flixse.graphqldemo.model.veterinary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dog {

    private String id;
    private String name;
    private String veterinaryId;

    public Dog(String id, String name, String veterinaryId){
        this.id = id;
        this.name = name;
        this.veterinaryId = veterinaryId;
    }

    private final static List<Dog> dogs = Arrays.asList(
            new Dog("id1", "Fons", "veterinaryId1"),
            new Dog("id2", "Jos", "veterinaryId1"),
            new Dog("id3", "Bas", "veterinaryId1"),
            new Dog("id4", "Patrick", "veterinaryId2"),
            new Dog("id5", "Bas", "veterinaryId2")
    );

    public static Dog getById(String id) {
        return dogs.stream()
                .filter(dog -> dog.getId().equals(id))
                .findFirst().orElse(null);
    }
    public String getVeterinaryId() {
        return veterinaryId;
    }

    public void setVeterinaryId(String veterinaryId) {
        this.veterinaryId = veterinaryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
