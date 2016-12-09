package TraitLists.Traits;

import TraitLists.Trait;

public class Cursed extends Trait{



    public void printDescription() {
        System.out.println("This is the trait CURSED");
    }

    @Override
    public void activateTrait() {

    }

    public String toString() {
        return "CURSED";
    }
}
