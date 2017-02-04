package Entities.RaceLists.Races;


import Entities.Entity;
import Entities.Player;
import Entities.RaceLists.Race;

public class Ent extends Race{

    private String description = "An Ent";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializeAttributes(Entity entity) {
        entity.setBaseStrength(17);
        entity.setBaseEndurance(7);
        entity.setBaseKnowledge(5);
        entity.setBasePerception(2);
        entity.setBaseMentality(3);
        entity.setBaseHardening(18);
    }

    @Override
    public String toString() {
        return "ENT";
    }

}
