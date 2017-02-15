package Main.Game.Entity.ProfessionLists.Professions;

import Main.Game.Entity.Entity;
import Main.Game.Entity.ProfessionLists.Profession;

public class Trickster extends Profession {

    private static String description = "A Trickster";

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
        return "TRICKSTER";
    }
}