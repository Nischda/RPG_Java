package Main.Game.Entity.Entities.Books.PassiveBooks.TraitBook;

import Main.Game.Entity.Entities.Books.PassiveBooks.TraitBook.Traits.BaseTrait;
import Main.Game.Entity.Entity;
import Main.Game.TxtReader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Trait {

    private String traitsPath = "D:/RPG_Java/src/main/java/Main/Resources/traits.txt";
    private static HashMap<String, Trait> traitRegister;


    public static void initialize () {
        traitRegister = TxtReader.generateTraitRegister(new File("D:/RPG_Java/src/main/java/Main/Resources/traits.txt"));
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
