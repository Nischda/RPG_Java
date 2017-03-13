package Main.Game.Entity.Entities.ProfessionLists;
import Main.Game.Entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Profession {

    private static HashMap<String, Profession> professionList = new HashMap<>();

    public abstract void printDescription();
    public abstract ArrayList<Double> getMods();

    public void addToList() {
        professionList.put(this.toString(), this);
    }

    public static boolean include(String profession) {

        return professionList.containsKey(profession);
    }

    public static Profession getProfession(String profession) {
        if (professionList.containsKey(profession)) {
            return (Profession) professionList.get(profession);
        }
        return null;
    }

    public static void add(String name, Profession profession) {
        professionList.put(name, profession);
    }

    public static String toS() {
        return professionList.values().toString();
    }
}
