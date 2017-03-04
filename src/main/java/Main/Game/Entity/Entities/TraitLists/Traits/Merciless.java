package Main.Game.Entity.Entities.TraitLists.Traits;

import Main.Game.Entity.Entities.TraitLists.Trait;
import Main.Game.Entity.Entity;

public class Merciless extends Trait {


    @Override
    public void printDescription() {
        System.out.println("This is the trait merciless");
    }

    @Override
    public void initializeTrait(Entity entity) {
        entity.addToDamageMod(0.2);
        entity.addToCharismaMod(-0.3);
    }

    public String toString() {
        return "merciless";
    }
}
