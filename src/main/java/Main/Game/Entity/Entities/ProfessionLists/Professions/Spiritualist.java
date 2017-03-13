package Main.Game.Entity.Entities.ProfessionLists.Professions;

import Main.Game.Entity.Entities.ProfessionLists.Profession;
import Main.Game.Entity.Entity;

import java.util.ArrayList;
import java.util.Arrays;

public class Spiritualist extends Profession {

    private static String description = "An spiritualist";
    private ArrayList mods = new ArrayList<>(Arrays.asList(0.2,0.0,0.0,0.0,0.1,0.0,0.0,0.0));
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
        return "spiritualist";
    }
}