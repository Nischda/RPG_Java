package Main.Game.Entity.Entities.RaceLists.Races;


import Main.Game.Entity.Entities.RaceLists.Race;
import Main.Game.Entity.Entity;

public class Beast extends Race {

    private String description = "A beast";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializeAttributes(Entity entity) {
        entity.setBaseAttributes(6,5,3,9,4,4,3);
    }

    @Override
    public String toString() {
        return "beast";
    }
}
