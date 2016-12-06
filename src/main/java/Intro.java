import Professions.Profession;
import Professions.ProfessionList;
import Races.RaceList;

public class Intro {

    private String name;
    private Profession profession;
    private Race race;
    private Trait[] traits;

    public void PromptName() {
        boolean validName = false;
        while(!validName) {
            System.out.println("From now on you will be known as ...");
            name = System.console().readLine();
            if(name.length() > 3 && name.length() < 20) {
                validName = true;
            }
        }
        System.out.println("From now on you will be known as " + name);

    }

    public void PromptClassType() {
        boolean validNProfession = false;
        while(!validNProfession) {
            System.out.println("You are widely known as a professional ...");
            String profession = System.console().readLine();
            if(ProfessionList.include(profession)) {
                validNProfession = true;
            }
        }
        System.out.println("You are widely known as a professional " + profession.toString());
    }

    public void PromptRace() {
        boolean validRace = false;
        while(!validRace) {
            System.out.println("You are a proud ...");
            String race = System.console().readLine();
            if(RaceList.include(race)) {
                validRace = true;
            }
        }
        System.out.println("You are a proud " + race.toString());
    }

    public void PromptTraits() {
        boolean validTraits = false;
        while(!validTraits) {
            System.out.println("The world destined you to you to be marked with: ...");
            String trait = System.console().readLine();
            if() {
                validTraits = true;
            }
        }
    }


}
