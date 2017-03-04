package Main.Game.Entity.Entities.TraitLists.Traits;

import Main.Game.Entity.Entities.TraitLists.Trait;
import Main.Game.Entity.Entity;

public class Corrupted extends Trait {


    @Override
    public void printDescription() {
        System.out.println("This is the trait corrupted");
    }

    @Override
    public void initializeTrait(Entity entity) {
        //ToDo add Corruption to perks
    }

    public String toString() {
        return "corrupted";
    }
}
