package Main.Game.Entity.Entities.RaceLists.Races;


import Main.Game.Entity.Entities.RaceLists.Race;
import Main.Game.Entity.Entity;

public class Giant extends Race {

    private String description = "A giant";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializeAttributes(Entity entity) {
        entity.setBaseAttributes(15,2,2,2,2,6,1);
    }

    @Override
    public String toString() {
        return "giant";
    }
}
