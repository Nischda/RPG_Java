package Entities.ProfessionLists.Professions;

import Entities.Player;
import Entities.ProfessionLists.Profession;

public class Duelist extends Profession {

    private static String description = "A Duelist";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializePerks(Player player) {
        double enduranceMod = player.getEnduranceMod();
        player.setEnduranceMod(enduranceMod + 0.1);
    }

    @Override
    public String toString() {
        return "DUELIST";
    }
}