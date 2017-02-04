package Entities.RaceLists.Races;


import Entities.Entity;
import Entities.Player;
import Entities.RaceLists.Race;

public class Elf extends Race{

    private String description = "An Elf";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializeAttributes(Entity entity) {
        entity.setBaseStrength(8);
        entity.setBaseEndurance(17);
        entity.setBaseKnowledge(12);
        entity.setBasePerception(15);
        entity.setBaseMentality(5);
        entity.setBaseHardening(3);
    }

    @Override
    public String toString() {
        return "ELF";
    }

}
