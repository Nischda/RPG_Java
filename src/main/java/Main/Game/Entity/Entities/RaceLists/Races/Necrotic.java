package Main.Game.Entity.Entities.RaceLists.Races;


import Main.Game.Entity.Entities.RaceLists.Race;
import Main.Game.Entity.Entity;

import java.util.ArrayList;
import java.util.Arrays;

public class Necrotic extends Race {

    private String description = "A necrotic";
    private ArrayList<Integer> stats = new ArrayList<>(Arrays.asList(14,10,8,5,11,12,10));
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
        return "necrotic";
    }

}
