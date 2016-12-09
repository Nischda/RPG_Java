package ProfessionLists.Professions;

import ProfessionLists.Profession;

public class Duelist extends Profession {

    private static String description = "A Duelist";

    public Duelist() {
    }

    public void printDescription() {
        System.out.println(this.description);
    }

    public void initializePerks() {

    }

    @Override
    public String toString() {
        return "DUELIST";
    }
}