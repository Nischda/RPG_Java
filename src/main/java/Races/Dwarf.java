package Races;


import java.util.HashMap;

public class Dwarf extends Race {

    private String description = "A Dwarf";

    public void printDescription() {
        System.out.println(this.description);
    }

    public void initializeTraits() {

    }

    @Override
    public String toString() {
        return "Dwarf";
    }

    public Dwarf() {
        RaceList.add("Dwarf", this);

    }
}
