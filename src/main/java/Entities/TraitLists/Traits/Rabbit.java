package Entities.TraitLists.Traits;

import Entities.TraitLists.Trait;

public class Rabbit extends Trait {


    @Override
    public void printDescription() {
        System.out.println("This is the trait RABBIT");
    }

    @Override
    public void inititializeTrait() {

    }

    public String toString() {
        return "RABBIT";
    }
}
