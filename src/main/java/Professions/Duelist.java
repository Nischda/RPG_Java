package Professions;

public class Duelist extends Profession {

    private static String description = "A Professions.Duelist";

    public Duelist() {
        ProfessionList.add("Duelist", this);
    }

    public void printDescription() {
        System.out.println(this.description);
    }

    public void initializePerks() {

    }

    @Override
    public String toString() {
        return "Duelist";
    }
}