package Entities.ProfessionLists.Professions;

import Entities.Entity;
import Entities.Player;
import Entities.ProfessionLists.Profession;

public class Trickster extends Profession {

    private static String description = "A Trickster";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializePerks(Entity entity) {
        double perceptionMod = entity.getPerceptionMod();
        entity.setPerceptionMod(perceptionMod + 0.1);
    }

    @Override
    public String toString() {
        return "TRICKSTER";
    }
}