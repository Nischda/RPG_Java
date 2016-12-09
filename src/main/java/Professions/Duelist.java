package Professions;

public class Duelist extends Profession {

    private static String description = "A Duelist";

    public Duelist() {
        ProfessionList.add(this.toString(), this);
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