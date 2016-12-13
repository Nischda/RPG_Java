package Entities.TraitLists.Traits;

import Entities.TraitLists.Trait;

public class Steed extends Trait {


    @Override
    public void printDescription() {
        System.out.println("This is the trait STEED");
    }

    @Override
    public void inititializeTrait() {

    }

    public String toString() {
        return "STEED";
    }
}
