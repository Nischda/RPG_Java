package Main.Game.Entity.Entities.TraitLists.Traits;

import Main.Game.Entity.Entities.TraitLists.Trait;
import Main.Game.Entity.Entity;

public class Forgotten extends Trait {


    @Override
    public void printDescription() {
        System.out.println("This is the trait forgotten");
    }

    @Override
    public void initializeTrait(Entity entity) {
        entity.addToCharismaMod(0.2);
        entity.addToArmorMod(-0.2);
    }

    public String toString() {
        return "forgotten";
    }
}
