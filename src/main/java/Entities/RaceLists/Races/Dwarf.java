package Entities.RaceLists.Races;


import Entities.Entity;
import Entities.Player;
import Entities.RaceLists.Race;

public class Dwarf extends Race {

    private String description = "A Dwarf";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializeAttributes(Entity entity) {
        entity.setBaseStrength(14);
        entity.setBaseEndurance(10);
        entity.setBaseKnowledge(8);
        entity.setBasePerception(5);
        entity.setBaseMentality(11);
        entity.setBaseHardening(12);
        System.out.println("stuff");
    }

    @Override
    public String toString() {
        return "DWARF";
    }
}
