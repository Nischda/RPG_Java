package Main.Game.Entity.Entities.TraitLists.Traits;

import Main.Game.Entity.Entities.TraitLists.Trait;

public class Enthusiastic extends Trait {


    @Override
    public void printDescription() {
        System.out.println("This is the trait enthusiastic");
    }

    @Override
    public void inititializeTrait() {

    }

    public String toString() {
        return "enthusiastic";
    }
}
