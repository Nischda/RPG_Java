package Main.Game.Entity.Entities.ProfessionLists.Professions;

import Main.Game.Entity.Entity;
import Main.Game.Entity.Entities.ProfessionLists.Profession;

public class Knight extends Profession {

    private static String description = "A knight";

    @Override
    public void printDescription() {
        System.out.println(description);
    }

    @Override
    public void initializePerks(Entity entity) {
        entity.addToHardeningMod(0.1);
    }

    @Override
    public String toString() {
        return "knight";
    }
}