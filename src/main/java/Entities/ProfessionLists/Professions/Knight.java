package Entities.ProfessionLists.Professions;

import Entities.Player;
import Entities.ProfessionLists.Profession;

public class Knight extends Profession {

    private static String description = "A Knight";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializePerks(Player player) {
        double hardeningMod = player.getHardeningMod();
        player.setHardeningMod(hardeningMod + 0.1);
    }

    @Override
    public String toString() {
        return "KNIGHT";
    }
}