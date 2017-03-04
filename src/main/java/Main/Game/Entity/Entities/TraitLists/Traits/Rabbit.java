package Main.Game.Entity.Entities.TraitLists.Traits;

import Main.Game.Entity.Entities.TraitLists.Trait;
import Main.Game.Entity.Entity;

public class Rabbit extends Trait {


    @Override
    public void printDescription() {
        System.out.println("This is the trait rabbit");
    }

    @Override
    public void initializeTrait(Entity entity) {
        entity.addToEffectChanceMod(0.2);
        entity.addToResistanceMod(-0.2);
    }

    public String toString() {
        return "rabbit";
    }
}
