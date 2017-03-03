package Main.Game.Entity.Entities.RaceLists.Races;


import Main.Game.Entity.Entities.RaceLists.Race;
import Main.Game.Entity.Entity;

public class Naga extends Race{

    private String description = "An naga";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializeAttributes(Entity entity) {
        entity.setBaseAttributes(8,12,8,7,11,5,7);
    } //ToDo limit chooseable races

    @Override
    public String toString() {
        return "naga";
    }

}
