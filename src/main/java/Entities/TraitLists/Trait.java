package Entities.TraitLists;

import java.util.HashMap;

public abstract class Trait {

    private static HashMap<String, Trait> traitList = new HashMap<>();

    public abstract void printDescription();
    public abstract void inititializeTrait();
    public abstract String toString();


    public static boolean include(String trait) {
        return traitList.containsKey(trait);
    }

    public static Trait getTrait(String trait) {
        if (traitList.containsKey(trait)) {
            return traitList.get(trait);
        }
        return null;
    }

    public void addToList() {
        traitList.put(this.toString(), this);
    }

    public static String toS() {
        return traitList.values().toString();
    }
}
