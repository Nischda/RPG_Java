package Main.Game.Entity.Entities.ProfessionLists.Professions;

import Main.Game.Entity.Entities.ProfessionLists.Profession;
import Main.Game.Entity.Entity;

public class Spiritualist extends Profession {

    private static String description = "An spiritualist";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializePerks(Entity entity) {
        entity.addToMentalityMod(0.2);
    }

    @Override
    public String toString() {
        return "spiritualist";
    }
}