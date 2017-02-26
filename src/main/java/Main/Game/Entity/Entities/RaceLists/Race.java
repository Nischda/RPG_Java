package Main.Game.Entity.Entities.RaceLists;

import Main.Game.Entity.Entity;
import java.util.HashMap;

public abstract class Race {

    private static HashMap raceList = new HashMap();

    public abstract void printDescription();
    public abstract void initializeAttributes(Entity entity);

    public static boolean include(String race) {
        return raceList.containsKey(race);
    }

    public static Race getRace(String race) {
        if (raceList.containsKey(race)) {
            return (Race)raceList.get(race);
        }
        return null;
    }

    public void addToList() {
        raceList.put(this.toString(), this);
    }
    public static String toS() {
        return raceList.values().toString();
    }
}