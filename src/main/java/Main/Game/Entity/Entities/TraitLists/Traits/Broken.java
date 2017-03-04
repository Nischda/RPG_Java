package Main.Game.Entity.Entities.TraitLists.Traits;

import Main.Game.Entity.Entities.TraitLists.Trait;
import Main.Game.Entity.Entity;

public class Broken extends Trait {


    @Override
    public void printDescription() {
        System.out.println("This is the trait broken");
    }

    @Override
    public void initializeTrait(Entity entity) {
        entity.addToDamageMod(0.2);
        entity.addToMaxHpMod(-0.2);
    }

    public String toString() {
        return "broken";
    }
}
