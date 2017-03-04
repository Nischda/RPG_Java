package Main.Game.Entity.Entities.TraitLists.Traits;

import Main.Game.Entity.Entities.TraitLists.Trait;
import Main.Game.Entity.Entity;

public class Rock extends Trait {


    @Override
    public void printDescription() {
        System.out.println("This is the trait rock");
    }

    @Override
    public void initializeTrait(Entity entity) {
        entity.addToResistanceMod(0.2);
        entity.addToDamageMod(-0.1);
    }

    public String toString() {
        return "rock";
    }
}
