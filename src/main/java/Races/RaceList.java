package Races;

import java.util.ArrayList;
import java.util.HashMap;

public class RaceList {
    private static ArrayList<HashMap> raceList;

    public static boolean include(String race) {
        return raceList.stream().anyMatch(element -> element.equals(race));
    }

    public static Race getRace(String race) {
        for(HashMap map : raceList) {
            if(map.containsKey(race)) {
                return (Race)map.get(race);
            }
        }
        return null;
    }

    public static void add(HashMap race) {
        raceList.add(race);
    }
}