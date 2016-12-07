package Professions;

import java.util.HashMap;


public class ProfessionList {

    private static HashMap professionList = new HashMap();

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
