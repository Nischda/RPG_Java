package Main.Game.Entity.Entities.ProfessionLists.Professions;

import Main.Game.Entity.Entities.ProfessionLists.Profession;
import Main.Game.Entity.Entity;

public class Kabbalist extends Profession {

    private static String description = "A Kabbalist";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializePerks(Entity entity) {
        entity.addToEnduranceMod(0.1);
    }

    @Override
    public String toString() {
        return "KABBALIST";
    }
}