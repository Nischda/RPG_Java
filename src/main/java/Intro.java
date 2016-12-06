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
        boolean validNProfession = false;
        while (!validNProfession) {
            System.out.println(ProfessionList.toS());
            System.out.println("You are widely known as a professional ...");
            String profession = in.nextLine();
            if (ProfessionList.include(profession)) {
                validNProfession = true;
            }
        }
        System.out.println("You are widely known as a professional " + profession.toString());
    }

    public void promptRace() {
        boolean validRace = false;
        while (!validRace) {
            System.out.println("You are a proud ...");
            String race = in.nextLine();
            if (RaceList.include(race)) {
                validRace = true;
            }
        }
        System.out.println("You are a proud " + race.toString());
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
