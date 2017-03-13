package Main.Game.Entity.Entities.ProfessionLists.Professions;

import Main.Game.Entity.Entity;
import Main.Game.Entity.Entities.ProfessionLists.Profession;

import java.util.ArrayList;
import java.util.Arrays;

public class Trickster extends Profession {

    private static String description = "A trickster";
    private ArrayList mods = new ArrayList<>(Arrays.asList(0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.2));
    // strength, endurance, knowledge, perception, mentality, hardening, perception, improvisation

    @Override
    public ArrayList<Double> getMods() {
        return mods;
    }

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public String toString() {
        return "trickster";
    }
}