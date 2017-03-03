package Main.Game.Entity.Entities.RaceLists.Races;


import Main.Game.Entity.Entities.RaceLists.Race;
import Main.Game.Entity.Entity;

public class Orc extends Race {

    private String description = "An orc";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializeAttributes(Entity entity) {
        entity.setBaseAttributes(18,12,6,5,6,16,7);
    }

    @Override
    public String toString() {
        return "orc";
    }

}
