package Professions;

public class Duelist extends Profession {

    private String description = "A Professions.Duelist";

    public void printDescription() {
        System.out.println(this.description);
    }
    public void initializePerks() {

    }

    public static void main(String []args){
        ProfessionList.add("Professions.Duelist");

    }
}

    /*
    public static void register() {
        Professionlist.register("Professions.Duelist");
    }
*/