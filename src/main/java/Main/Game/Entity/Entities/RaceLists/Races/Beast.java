package Main.Game.Entity.Entities.RaceLists.Races;


import Main.Game.Entity.Entities.RaceLists.Race;
import Main.Game.Entity.Entity;

import java.util.ArrayList;
import java.util.Arrays;

public class Beast extends Race {

    private String description = "A beast";
    private ArrayList<Integer> stats = new ArrayList<>(Arrays.asList(6,5,3,9,4,4,3));
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
        return "beast";
    }
}
