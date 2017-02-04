package Entities.ProfessionLists.Professions;

import Entities.Entity;
import Entities.Player;
import Entities.ProfessionLists.Profession;

public class Duelist extends Profession {

    private static String description = "A Duelist";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializePerks(Entity entity) {
        double enduranceMod = entity.getEnduranceMod();
        entity.setEnduranceMod(enduranceMod + 0.1);
    }

    @Override
    public String toString() {
        return "DUELIST";
    }
}