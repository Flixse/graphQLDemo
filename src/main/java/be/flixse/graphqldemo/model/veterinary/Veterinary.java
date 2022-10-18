package be.flixse.graphqldemo.model.veterinary;

import java.util.Arrays;
import java.util.List;

public class Veterinary {
    private String id;

    private String name;

    private List<String> dogs;

    public Veterinary(String id, String name, List<String> dogs) {
        this.id = id;
        this.name = name;
        this.dogs = dogs;
    }

    private final static List<Veterinary> veterinaries = Arrays.asList(
            new Veterinary("veterinaryId1", "Anna", Arrays.asList("id1", "id2", "id3")),
            new Veterinary("veterinaryId2", "Patata", Arrays.asList("id4", "id5"))
    );

    public static Veterinary getById(String id){
        return veterinaries.stream().filter(v -> v.getId().equals(id)).findFirst().orElse(null);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDogs() {
        return dogs;
    }
}
