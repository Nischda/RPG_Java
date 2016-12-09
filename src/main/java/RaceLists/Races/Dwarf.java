package RaceLists.Races;


import RaceLists.Race;

public class Dwarf extends Race {

    private String description = "A Dwarf";


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
