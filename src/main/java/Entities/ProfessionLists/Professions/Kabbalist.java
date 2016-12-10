package Entities.ProfessionLists.Professions;

import Entities.Player;
import Entities.ProfessionLists.Profession;

public class Kabbalist extends Profession {

    private static String description = "A Kabbalist";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializePerks(Player player) {
        double perceptionMod = player.getPerceptionMod();
        player.setPerceptionMod(perceptionMod + 0.1);
    }

    @Override
    public String toString() {
        return "KABBALIST";
    }
}