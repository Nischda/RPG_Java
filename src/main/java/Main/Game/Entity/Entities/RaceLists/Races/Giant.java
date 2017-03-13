package Main.Game.Entity.Entities.RaceLists.Races;


import Main.Game.Entity.Entities.RaceLists.Race;
import Main.Game.Entity.Entity;

import java.util.ArrayList;
import java.util.Arrays;

public class Giant extends Race {

    private String description = "A giant";
    private ArrayList<Integer> stats = new ArrayList<>(Arrays.asList(15,2,2,2,2,6,1));
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
        return "giant";
    }
}
