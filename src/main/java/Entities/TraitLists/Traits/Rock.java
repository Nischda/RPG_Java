package Entities.TraitLists.Traits;

import Entities.TraitLists.Trait;

public class Rock extends Trait {


    @Override
    public void printDescription() {
        System.out.println("This is the trait ROCK");
    }

    @Override
    public void inititializeTrait() {

    }

    public String toString() {
        return "ROCK";
    }
}
