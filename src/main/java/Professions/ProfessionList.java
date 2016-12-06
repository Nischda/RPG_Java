package Professions;

import java.util.ArrayList;


public class ProfessionList {

    private static ArrayList<String> professionList;

    public static boolean include(String element) {
        return professionList.contains(element);
    }

    public static void add(String string) {
        professionList.add(string);
    }
}
