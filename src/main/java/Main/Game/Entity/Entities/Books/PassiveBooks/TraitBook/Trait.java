package Main.Game.Entity.Entities.Books.PassiveBooks.TraitBook;

import Main.Game.Entity.Entities.Books.PassiveBooks.TraitBook.Traits.BaseTrait;
import Main.Game.Entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Trait {

    private static HashMap<String, Trait> traitRegister = new HashMap<>();


    public static void initialize () {
        traitRegister = new HashMap<>();
        traitRegister.put("beloved", new BaseTrait("beloved", "charisma", 0.2, "armor", -0.2, "This is the trait beloved."));
        traitRegister.put("broken", new BaseTrait("broken", "damage", 0.1, "maxHp", -0.1, "This is the trait beloved.") {});
        traitRegister.put("corrupted", new BaseTrait("corrupted", "", 0.2, "", -0.2, "This is the trait beloved.") {});
        traitRegister.put("cursed", new BaseTrait("cursed", "spellDamage", 0.1, "maxHp", -0.1, "This is the trait beloved.") {});
        traitRegister.put("energetic", new BaseTrait("energetic", "maxMp", 0.2, "maxHp", -0.2, "This is the trait beloved.") {});
        traitRegister.put("enthusiastic", new BaseTrait("enthusiastic", "speed", 0.2, "evasion", -0.2, "This is the trait beloved.") {});
        traitRegister.put("forgotten", new BaseTrait("forgotten", "armor", 0.2, "charisma", -0.2, "This is the trait beloved.") {});
        traitRegister.put("merciless", new BaseTrait("merciless", "damage", 0.2, "charisma", -0.3, "This is the trait beloved.") {});
        traitRegister.put("mountain", new BaseTrait("mountain", "maxHp", 0.2, "agility", -0.2, "This is the trait beloved.") {});
        traitRegister.put("old", new BaseTrait("old", "spellDamage", 0.2, "maxHp", -0.2, "This is the trait beloved.") {});
        traitRegister.put("rabbit", new BaseTrait("rabbit", "effectChance", 0.2, "resistance", -0.2, "This is the trait beloved.") {});
        traitRegister.put("rock", new BaseTrait("rock", "resistance", 0.2, "damage", -0.1, "This is the trait beloved.") {});
        traitRegister.put("shapeshifter", new BaseTrait("shapeshifter", "", 0.2, "", -0.2, "This is the trait beloved.") {});
        traitRegister.put("steed", new BaseTrait("steed", "evasion", 0.2, "spellDamage", -0.2, "This is the trait beloved.") {});
        traitRegister.put("beloved", new BaseTrait("wanderer", "speed", 0.2, "maxMp", -0.2, "This is the trait beloved.") {});
        traitRegister.put("golem", new BaseTrait("golem", "armor", 0.2, "effectChance", -0.2, "This is the trait beloved.") {});
    }

    public abstract void printDescription();
    public abstract void initializeTrait(Entity entity);
    public abstract String toString();


    public static boolean include(String trait) {
        return traitRegister.containsKey(trait);
    }

    public static Trait getTrait(String trait) {
        System.out.println("1111");
        if (traitRegister.containsKey(trait)) {
            System.out.println("works");
            return traitRegister.get(trait);
        }
        return null;
    }
/*
    public static void addToList() {
        traitRegister.put(this.toString(), this);
    }
    */

    public static String toS() {
        return traitRegister.values().toString();
    }


}
