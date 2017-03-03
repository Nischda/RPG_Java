package Main.Game.Entity.Entities.RaceLists.Races;


import Main.Game.Entity.Entities.RaceLists.Race;
import Main.Game.Entity.Entity;

public class Dragon extends Race {

    private String description = "A dragon";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializeAttributes(Entity entity) {
        entity.setBaseAttributes(8,9,6,10,6,7,5);
    }

    @Override
    public String toString() {
        return "dragon";
    }
}
