package TraitLists.Traits;

import TraitLists.Trait;
import TraitLists.TraitList;

public class Cursed extends Trait{

    public Cursed() {
        TraitList.add(this.toString(), this);
    }

    public void printDescription() {
        System.out.println("This is the trait CURSED");
    }

    public String toString() {
        return "CURSED";
    }
}
