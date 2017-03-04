package Main.Game.Entity.Entities.TraitLists.Traits;

import Main.Game.Entity.Entities.TraitLists.Trait;
import Main.Game.Entity.Entity;

public class Enthusiastic extends Trait {


    @Override
    public void printDescription() {
        System.out.println("This is the trait enthusiastic");
    }

    @Override
    public void initializeTrait(Entity entity) {
        entity.addToCharismaMod(0.2); //ToDo add evasion and crit
        entity.addToArmorMod(-0.2);
    }

    public String toString() {
        return "enthusiastic";
    }
}
