package Main.Game.Entity.Entities.TraitLists.Traits;

import Main.Game.Entity.Entities.TraitLists.Trait;
import Main.Game.Entity.Entity;

public class Old extends Trait {


    @Override
    public void printDescription() {
        System.out.println("This is the trait old");
    }

    @Override
    public void initializeTrait(Entity entity) {
        entity.addToSpellDamageMod(0.2);
        entity.addToMaxHpMod(-0.2);
    }

    public String toString() {
        return "old";
    }
}
