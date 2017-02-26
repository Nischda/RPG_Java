package Main.Game.Entity.Entities.RaceLists.Races;


import Main.Game.Entity.Entity;
import Main.Game.Entity.Entities.RaceLists.Race;

public class Dwarf extends Race {

    private String description = "A Dwarf";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializeAttributes(Entity entity) {
        entity.setBaseAttributes(14,10,8,5,11,12,10);
    }

    @Override
    public String toString() {
        return "DWARF";
    }
}