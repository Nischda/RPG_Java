package Main.Game.Entity.Entities.ProfessionLists.Professions;

import Main.Game.Entity.Entities.ProfessionLists.Profession;
import Main.Game.Entity.Entity;

import java.util.ArrayList;
import java.util.Arrays;

public class Fighter extends Profession {

    private static String description = "A fighter";
    private ArrayList mods = new ArrayList<>(Arrays.asList(0.2,0.0,0.0,0.0,0.0,0.0,0.2,0.0));
    // strength, endurance, knowledge, perception, mentality, hardening, perception, improvisation

    @Override
    public ArrayList<Double> getMods() {
        return mods;
    }

    @Override
    public void printDescription() {
        System.out.println(description);
    }

    @Override
    public String toString() {
        return "fighter";
    }
}