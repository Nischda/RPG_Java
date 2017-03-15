package Main.Game.Team.Entity.Components.Books.ProfessionBooks;

import Main.Game.Utility.FileHandler.TxtReader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Profession {

    private static HashMap<String, Profession> professionRegister = new HashMap();

    public static void initialize () {
        professionRegister = TxtReader.generateProfessionRegister(new File("D:/RPG_Java/src/main/resources/professions.txt"));
    }

    public abstract void printDescription();
    public abstract ArrayList<Double> getMods();
    public abstract String getPerkName();
    public static boolean include(String race) {
        return professionRegister.containsKey(race);
    }

    public static Profession getProfession(String profession) {
        if (professionRegister.containsKey(profession)) {
            return (Profession)professionRegister.get(profession);
        }
        return null;
    }

    public static String toS() {
        String string = "  ";
        for(Profession profession : professionRegister.values()) {
            string += profession.toString() + ", ";
        }
        return string.substring(0, string.length()-2);
    }
}
