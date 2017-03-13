package Main.Game.Entity.Entities.RaceLists.Races;


import Main.Game.Entity.Entities.RaceLists.Race;
import Main.Game.Entity.Entity;

import java.util.ArrayList;
import java.util.Arrays;

public class Gnome extends Race{

    private String description = "A gnome";
    private ArrayList<Integer> stats = new ArrayList<>(Arrays.asList(7,7,17,6,13,6,14));
    // strength, endurance, knowledge, perception, mentality, hardening, perception, improvisation

    @Override
    public ArrayList<Integer> getStats() {
        return stats;
    }
    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public String toString() {
        return "gnome";
    }

}
