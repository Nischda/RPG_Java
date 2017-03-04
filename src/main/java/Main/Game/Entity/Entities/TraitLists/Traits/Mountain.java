package Main.Game.Entity.Entities.TraitLists.Traits;

import Main.Game.Entity.Entities.TraitLists.Trait;
import Main.Game.Entity.Entity;

public class Mountain extends Trait {


    @Override
    public void printDescription() {
        System.out.println("This is the trait giant");
    }

    @Override
    public void initializeTrait(Entity entity) {
        entity.addToMaxHpMod(0.2);
        entity.addToEnduranceMod(-0.2);
    }

    public String toString() {
        return "giant";
    }
}
