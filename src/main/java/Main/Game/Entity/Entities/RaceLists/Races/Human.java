package Main.Game.Entity.Entities.RaceLists.Races;


import Main.Game.Entity.Entities.RaceLists.Race;
import Main.Game.Entity.Entity;

public class Human extends Race{

    private String description = "A human";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializeAttributes(Entity entity) {
        entity.setBaseAttributes(14,14,8,8,8,10,8);
    }

    @Override
    public String toString() {
        return "human";
    }

}
