package Entities.TraitLists;

import java.util.ArrayList;

public class CustomTraitList {

    private static ArrayList<Trait> traitList = new ArrayList<>();

    public void initializeAllTraits() {
        for(Trait trait : traitList) {
            trait.inititializeTrait();
        }
    }

    public boolean include(Trait trait) {
        return traitList.contains(trait);
    }


    public void addToList(Trait trait) {
        traitList.add(trait);
    }

    @Override
    public String toString() {
        return traitList.toString();
    }
}
