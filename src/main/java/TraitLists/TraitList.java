package TraitLists;

import java.util.HashMap;


public class TraitList {

    private static HashMap traitList = new HashMap();

    public static boolean include(String trait) {

        return traitList.containsKey(trait);
    }

    public static Trait getTrait(String trait) {
        if (traitList.containsKey(trait)) {
            return (Trait) traitList.get(trait);
        }
        return null;
    }

    public static void add(String name, Trait trait) {
        traitList.put(name, trait);
    }

    public static String toS() {
        return traitList.values().toString();
    }
}
