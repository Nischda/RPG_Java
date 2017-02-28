package Main.Game.Entity.Entities.TraitLists.Traits;

import Main.Game.Entity.Entities.TraitLists.Trait;

public class Forgotten extends Trait {


    @Override
    public void printDescription() {
        System.out.println("This is the trait forgotten");
    }

    @Override
    public void inititializeTrait() {

    }

    public String toString() {
        return "forgotten";
    }
}
