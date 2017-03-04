package Main.Game.Entity.Entities.TraitLists.Traits;

import Main.Game.Entity.Entities.TraitLists.Trait;
import Main.Game.Entity.Entity;

public class Wanderer extends Trait {


    @Override
    public void printDescription() {
        System.out.println("This is the trait wanderer");
    }

    @Override
    public void initializeTrait(Entity entity) {
        entity.addToArmorMod(0.2);
        entity.addToEffectChanceMod(-0.2);
    }

    public String toString() {
        return "wanderer";
    }
}
