package Entities.ProfessionLists.Professions;

import Entities.Entity;
import Entities.Player;
import Entities.ProfessionLists.Profession;

public class Bruiser extends Profession {

    private static String description = "A Bruiser";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializePerks(Entity entity) {
        double strengthMod = entity.getStrengthMod();
        entity.setStrengthMod(strengthMod + 0.1);
        //activate player.attackPattern = doublehit
    }

    @Override
    public String toString() {
        return "BRUISER";
    }
}