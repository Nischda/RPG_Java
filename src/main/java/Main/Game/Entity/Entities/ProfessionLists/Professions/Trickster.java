package Main.Game.Entity.Entities.ProfessionLists.Professions;

import Main.Game.Entity.Entity;
import Main.Game.Entity.Entities.ProfessionLists.Profession;

public class Trickster extends Profession {

    private static String description = "A trickster";

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
        return "trickster";
    }
}