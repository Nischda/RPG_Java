package Professions;

import Races.Race;
import java.util.HashMap;


public class ProfessionList {

    private static HashMap professionList = new HashMap();

    public static boolean include(String profession) {
        return professionList.containsKey(profession);
    }

    public static Race getRace(String race) {
        if (professionList.containsKey(race)) {
            professionList.get(race);
        }
        return null;
    }

    public static void add(String name, Profession profession) {
        professionList.put(name, profession);
    }

    public static String toS() {
        return professionList.toString();
    }
}
