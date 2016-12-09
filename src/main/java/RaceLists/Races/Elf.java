package RaceLists.Races;


import RaceLists.Race;

public class Elf extends Race{

    private String description = "An Elf";

    public void printDescription() {
        System.out.println(this.description);
    }

    public void initializeTraits() {


    }
    @Override
    public String toString() {
        return "ELF";
    }

}
