package Races;


import java.util.HashMap;

public class Dwarf extends Race{

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

    public void main(String []args){
        HashMap<String,Race> dwarf = new HashMap<>();
        dwarf.put("Dwarf", this);
        RaceList.add(dwarf);

    }
}
