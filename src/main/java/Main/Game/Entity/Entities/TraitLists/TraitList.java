package Main.Game.Entity.Entities.TraitLists;

import Main.Game.Entity.Entity;

import java.util.ArrayList;

public class TraitList {

    private static ArrayList<Trait> traitList = new ArrayList<>();

    public void initializeAllTraits(Entity entity) {
        for(Trait trait : traitList) {
            trait.initializeTrait(entity);
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
