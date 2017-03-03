package Main.Game.Entity.Entities.ProfessionLists.Professions;

import Main.Game.Entity.Entities.ProfessionLists.Profession;
import Main.Game.Entity.Entity;

public class Omnivore extends Profession {

    private static String description = "An omnivore";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializePerks(Entity entity) {
        entity.addToEnduranceMod(0.05);
    }//Todo disable usage of non meat food

    @Override
    public String toString() {
        return "omnivore";
    }
}