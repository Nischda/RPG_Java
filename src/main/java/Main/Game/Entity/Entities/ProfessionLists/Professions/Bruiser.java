package Main.Game.Entity.Entities.ProfessionLists.Professions;

import Main.Game.Entity.Entities.ProfessionLists.Profession;
import Main.Game.Entity.Entity;

public class Bruiser extends Profession {

    private static String description = "A bruiser";

    @Override
    public void printDescription() {
        System.out.println(description);
    }

    @Override
    public void initializePerks(Entity entity) {
        entity.addToStrengthMod(0.2);
        //activate player.attackPattern = doublehit
    }

    @Override
    public String toString() {
        return "bruiser";
    }
}