package Main.Game.Entity.Entities.TraitLists.Traits;

import Main.Game.Entity.Entities.TraitLists.Trait;
import Main.Game.Entity.Entity;

public class Energetic extends Trait {


    @Override
    public void printDescription() {
        System.out.println("This is the trait energetic");
    }

    @Override
    public void initializeTrait(Entity entity) {
        entity.addToMaxHpMod(-0.2);
        entity.addToMaxMpMod(0.2);
    }

    public String toString() {
        return "energetic";
    }
}
