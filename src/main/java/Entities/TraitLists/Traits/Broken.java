package Entities.TraitLists.Traits;

import Entities.TraitLists.Trait;

public class Broken extends Trait {


    @Override
    public void printDescription() {
        System.out.println("This is the trait BROKEN");
    }

    @Override
    public void inititializeTrait() {

    }

    public String toString() {
        return "BROKEN";
    }
}
