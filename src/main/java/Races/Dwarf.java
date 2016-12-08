package Races;


public class Dwarf extends Race {

    private String description = "A Dwarf";

    public Dwarf() {
        RaceList.add("DWARF", this);
    }

    public void printDescription() {
        System.out.println(this.description);
    }

    public void initializeTraits() {


    }
    @Override
    public String toString() {
        return "DWARF";
    }
}
