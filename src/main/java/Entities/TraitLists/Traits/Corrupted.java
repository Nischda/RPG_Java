package Entities.TraitLists.Traits;

import Entities.TraitLists.Trait;

public class Corrupted extends Trait {


    @Override
    public void printDescription() {
        System.out.println("This is the trait CORRUPTED");
    }

    @Override
    public void inititializeTrait() {

    }

    public String toString() {
        return "CORRUPTED";
    }
}
