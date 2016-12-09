package TraitLists;

import java.util.HashMap;

public abstract class Trait {

    private static HashMap<String, Trait> traitList = new HashMap<>();

    public abstract void activateTrait();
    public abstract String toString();


    public static boolean include(String trait) {
        return traitList.containsKey(trait);
    }

    public static Trait getTrait(String profession) {
        if (traitList.containsKey(profession)) {
            return (Trait) traitList.get(profession);
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
