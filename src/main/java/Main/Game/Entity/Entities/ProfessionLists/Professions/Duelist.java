package Main.Game.Entity.Entities.ProfessionLists.Professions;

import Main.Game.Entity.Entity;
import Main.Game.Entity.Entities.ProfessionLists.Profession;

public class Duelist extends Profession {

    private static String description = "A duelist";

    @Override
    public void printDescription() {
        System.out.println(description);
    }

    @Override
    public void initializePerks(Entity entity) {
        entity.addToEnduranceMod(0.2);
    }

    @Override
    public String toString() {
        return "duelist";
    }
}