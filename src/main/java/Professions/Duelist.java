package Professions;

public class Duelist extends Profession {

    private static String description = "A Professions.Duelist";

    public void printDescription() {
        System.out.println(this.description);
    }

    public void initializePerks() {

    }

    public Duelist() {
        ProfessionList.add("Duelist", this);
    }
}