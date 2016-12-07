import Professions.Profession;
import Professions.ProfessionList;
import Races.*;

import java.util.ArrayList;

import java.util.Scanner;

public class Intro {

    private String name;
    private Profession profession;
    private Race race;
    private static ArrayList<Trait> traits;

    private Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

    }

    public void promptName() {
        boolean validName = false;

        while (!validName) {
            System.out.println("From now on you will be known as ...");
             name = in.nextLine();
            if (name.length() > 3 && name.length() < 20) {
                validName = true;
            }
        }
        System.out.println("From now on you will be known as " + name);

    }

    public void promptClassType() {
        boolean validProfession = false;

        while (!validProfession) {
            System.out.println("You are widely known as a professional ...");
            String professionName = in.nextLine();
            if (ProfessionList.include(professionName)) {
                this.profession = ProfessionList.getProfession(professionName);
                validProfession = true;
            }
        }
        System.out.println("You are widely known as a professional " + this.profession);
    }

    public void promptRace() {
        boolean validRace = false;

        while (!validRace) {
            System.out.println("You are a proud ...");
            String raceName = in.nextLine();
            if (RaceList.include(raceName)) {
                this.race = RaceList.getRace(raceName);
                validRace = true;
            }
        }
        System.out.println("You are a proud " + this.race);
    }

    public void promptTraits() {
        boolean validTraits = false;

        while (!validTraits) {
            System.out.println("The world destined you to you to be marked with: ...");
            String traitName = in.nextLine();
            if (Trait.exists(traitName)) {
                traits.add(Trait.getTrait(traitName));
                validTraits = true;
            }
        }
        System.out.println("The world destined you to you to be marked with: ..." + traits.toString());
    }
    public void characterCreation() {
        promptName();
        promptClassType();
        promptRace();
        promptTraits();
    }

}
