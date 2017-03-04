package Main.Game.Entity.Entities.TraitLists.Traits;

import Main.Game.Entity.Entities.TraitLists.Trait;
import Main.Game.Entity.Entity;

public class Shapeshifter extends Trait {


    @Override
    public void printDescription() {
        System.out.println("This is the trait shapeshifter");
    }

    @Override
    public void initializeTrait(Entity entity) { //ToDo add evasion
        entity.addToCharismaMod(0.2);
        entity.addToArmorMod(-0.2);
    }

    public String toString() {
        return "shapeshifter";
    }
}
