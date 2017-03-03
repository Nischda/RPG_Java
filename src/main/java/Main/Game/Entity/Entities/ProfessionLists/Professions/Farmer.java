package Main.Game.Entity.Entities.ProfessionLists.Professions;

import Main.Game.Entity.Entities.ProfessionLists.Profession;
import Main.Game.Entity.Entity;

public class Farmer extends Profession {

    private static String description = "A carnivore";

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public void initializePerks(Entity entity) {
        entity.addToStrengthMod(0.05);
    }//

    @Override
    public String toString() {
        return "carnivore";
    }
}