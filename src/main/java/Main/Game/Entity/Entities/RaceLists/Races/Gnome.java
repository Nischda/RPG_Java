package Main.Game.Entity.Entities.RaceLists.Races;


import Main.Game.Entity.Entities.RaceLists.Race;
import Main.Game.Entity.Entity;

public class Gnome extends Race{

    private String description = "A gnome";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializeAttributes(Entity entity) {
        entity.setBaseAttributes(7,7,17,6,13,6,14);
    }

    @Override
    public String toString() {
        return "gnome";
    }

}
