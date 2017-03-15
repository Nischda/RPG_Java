package Main.Game.Team.Entity.Components.Books.PassiveBooks.TraitBook;

import Main.Game.Team.Entity.Entity;
import Main.Game.Utility.FileHandler.TxtReader;

import java.io.File;
import java.util.HashMap;

public abstract class Trait {

    private static HashMap<String, Trait> traitRegister;


    public static void initialize () {
        traitRegister = TxtReader.generateTraitRegister(new File("D:/RPG_Java/src/main/resources/traits.txt"));
    }

    public abstract void printDescription();
    public abstract void initializeTrait(Entity entity);
    public abstract String toString();


    public static boolean include(String trait) {
        return traitRegister.containsKey(trait);
    }

    public static Trait getTrait(String trait) {
        if (traitRegister.containsKey(trait)) {
            return traitRegister.get(trait);
        }
        return null;
    }

    public static String toS() {
        return traitRegister.values().toString();
    }


}
