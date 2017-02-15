package Main.Game.Entity.Entities.ProfessionLists.Professions;

import Main.Game.Entity.Entities.ProfessionLists.Profession;
import Main.Game.Entity.Entity;

public class Bruiser extends Profession {

    private static String description = "A Bruiser";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializePerks(Entity entity) {
        entity.addToEnduranceMod(0.1);
        //activate player.attackPattern = doublehit
    }

    @Override
    public String toString() {
        return "BRUISER";
    }
}