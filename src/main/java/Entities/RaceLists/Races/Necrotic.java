package Entities.RaceLists.Races;


import Entities.Entity;
import Entities.RaceLists.Race;

public class Necrotic extends Race{

    private String description = "A Necrotic";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializeAttributes(Entity entity) {
        entity.setBaseStrength(2);
        entity.setBaseEndurance(12);
        entity.setBaseKnowledge(18);
        entity.setBasePerception(4);
        entity.setBaseMentality(16);
        entity.setBaseHardening(7);
    }

    @Override
    public String toString() {
        return "NECROTIC";
    }

}
