package Entities.TraitLists.Traits;

import Entities.TraitLists.Trait;

public class Giant extends Trait {


    @Override
    public void printDescription() {
        System.out.println("This is the trait GIANT");
    }

    @Override
    public void inititializeTrait() {

    }

    public String toString() {
        return "GIANT";
    }
}