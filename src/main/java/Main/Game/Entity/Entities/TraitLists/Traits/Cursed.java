package Main.Game.Entity.Entities.TraitLists.Traits;

import Main.Game.Entity.Entities.TraitLists.Trait;
import Main.Game.Entity.Entity;

public class Cursed extends Trait {


    @Override
    public void printDescription() {
        System.out.println("This is the trait cursed");
    }

    @Override
    public void initializeTrait(Entity entity) {
        entity.addToSpellDamageMod(0.1);
        entity.addToMaxHpMod(-0.1);
    }

    public String toString() {
        return "cursed";
    }
}
