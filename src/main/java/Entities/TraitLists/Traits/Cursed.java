package Entities.TraitLists.Traits;

import Entities.TraitLists.Trait;

public class Cursed extends Trait {


    @Override
    public void printDescription() {
        System.out.println("This is the trait CURSED");
    }

    @Override
    public void inititializeTrait() {

    }

    public String toString() {
        return "CURSED";
    }
}
