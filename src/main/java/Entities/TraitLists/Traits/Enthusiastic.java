package Entities.TraitLists.Traits;

import Entities.TraitLists.Trait;

public class Enthusiastic extends Trait {


    @Override
    public void printDescription() {
        System.out.println("This is the trait ENTHUSIASTIC");
    }

    @Override
    public void inititializeTrait() {

    }

    public String toString() {
        return "ENTHUSIASTIC";
    }
}
