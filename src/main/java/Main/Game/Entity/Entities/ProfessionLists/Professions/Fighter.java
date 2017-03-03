package Main.Game.Entity.Entities.ProfessionLists.Professions;

import Main.Game.Entity.Entities.ProfessionLists.Profession;
import Main.Game.Entity.Entity;

public class Fighter extends Profession {

    private static String description = "A fighter";

    @Override
    public void printDescription() {
        System.out.println(description);
    }

    @Override
    public void initializePerks(Entity entity) {
        entity.addToImprovisationMod(0.1); //Todo change all mods of professions/make a lisz
        //activate player.attackPattern = doublehit
    }

    @Override
    public String toString() {
        return "fighter";
    }
}