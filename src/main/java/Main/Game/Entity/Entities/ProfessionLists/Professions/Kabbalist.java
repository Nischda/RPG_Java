package Main.Game.Entity.Entities.ProfessionLists.Professions;

import Main.Game.Entity.Entities.ProfessionLists.Profession;
import Main.Game.Entity.Entity;

public class Kabbalist extends Profession {

    private static String description = "A kabbalist";

    @Override
    public void printDescription() {
        System.out.println(description);
    }

    @Override
    public void initializePerks(Entity entity) {
        entity.addToKnowledgeMod(0.2);
    }

    @Override
    public String toString() {
        return "kabbalist";
    }
}