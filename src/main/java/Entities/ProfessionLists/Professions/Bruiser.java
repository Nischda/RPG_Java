package Entities.ProfessionLists.Professions;

import Entities.Player;
import Entities.ProfessionLists.Profession;

public class Bruiser extends Profession {

    private static String description = "A Bruiser";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializePerks(Player player) {
        double strengthMod = player.getStrengthMod();
        player.setStrengthMod(strengthMod + 0.1);
        //activate player.attackPattern = doublehit
    }

    @Override
    public String toString() {
        return "BRUISER";
    }
}