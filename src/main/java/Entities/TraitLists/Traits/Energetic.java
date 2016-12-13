package Entities.TraitLists.Traits;

import Entities.TraitLists.Trait;

public class Energetic extends Trait {


    @Override
    public void printDescription() {
        System.out.println("This is the trait ENERGETIC");
    }

    @Override
    public void inititializeTrait() {

    }

    public String toString() {
        return "ENERGETIC";
    }
}
