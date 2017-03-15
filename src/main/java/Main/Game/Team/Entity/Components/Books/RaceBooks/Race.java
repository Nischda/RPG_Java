package Main.Game.Team.Entity.Components.Books.RaceBooks;

import Main.Game.Utility.FileHandler.TxtReader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Race {

    private static HashMap<String, Race> raceRegister = new HashMap();

    public static void initialize () {
        raceRegister = TxtReader.generateRaceRegister(new File("D:/RPG_Java/src/main/resources/races.txt"));
    }

    public abstract void printDescription();
    public abstract ArrayList<Integer> getStats();
    public static boolean include(String race) {
        return raceRegister.containsKey(race);
    }

    public static Race getRace(String race) {
        if (raceRegister.containsKey(race)) {
            return (Race)raceRegister.get(race);
        }
        return null;
    }

    public static String toS() {
        String string = "  ";
        for(Race race : raceRegister.values()) {
            string += race.toString() + ", ";
        }
        return string.substring(0, string.length()-2);
    }
}
