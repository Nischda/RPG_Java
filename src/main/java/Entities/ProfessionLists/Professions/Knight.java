package Entities.ProfessionLists.Professions;

import Entities.Entity;
import Entities.Player;
import Entities.ProfessionLists.Profession;

public class Knight extends Profession {

    private static String description = "A Knight";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializePerks(Entity entity) {
        double hardeningMod = entity.getHardeningMod();
        entity.setHardeningMod(hardeningMod + 0.1);
    }

    @Override
    public String toString() {
        return "KNIGHT";
    }
}