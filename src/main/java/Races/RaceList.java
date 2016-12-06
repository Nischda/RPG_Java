package Races;

import java.util.HashMap;

public class RaceList {
    private static HashMap raceMap;

    public static boolean include(String race) {
        return raceMap.containsKey(race);
    }

    public static Race getRace(String race) {
        if (raceMap.containsKey(race)) {
            raceMap.get(race);
        }
        return null;
    }

    public static void add(String name, Race race) {
        raceMap.put(name, race);
    }
}
/*
       return raceList.stream().anyMatch(element -> element.keySet().equals(race));

        for(HashMap map : raceList) {
                if(map.containsKey(race)) {
                return (Race)map.get(race);
                }
                }
                return null;
*/