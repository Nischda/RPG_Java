package Main.Game.Entity.Entities.TraitLists.Traits;

import Main.Game.Entity.Entities.TraitLists.Trait;

public class Shapeshifter extends Trait {


    @Override
    public void printDescription() {
        System.out.println("This is the trait shapeshifter");
    }

    @Override
    public void inititializeTrait() {

    }

    public String toString() {
        return "shapeshifter";
    }
}
