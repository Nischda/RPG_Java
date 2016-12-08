import Professions.Profession;
import Professions.ProfessionList;
import Races.*;

import java.util.ArrayList;

import java.util.Scanner;

public class Intro {

    private String name;
    private Profession profession;
    private Race race;
    private static ArrayList<Trait> traits = new ArrayList<Trait>();

    private Scanner in = new Scanner(System.in);


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
            String professionName = in.nextLine().toUpperCase();
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
            String raceName = in.nextLine().toUpperCase();
            if (RaceList.include(raceName)) {
                this.race = RaceList.getRace(raceName);
                validRace = true;
            }
        }
        System.out.println("You are a proud " + this.race);
    }

    public void promptTraits() {
        boolean validTraits = false;
        int maxTraits = 3;
        int curTraits = 0;
        boolean approval = false;
        while (!validTraits || !approval) {
            System.out.println("The world destined you the burden of: ...");
            System.out.println("Enter up to 3 of the following traits: " + Trait.toS());
            System.out.println("Enter 'ACCEPT' to continue");
            System.out.println("Current traits: " + curTraits + "/" + maxTraits + ": " +  traits.toString());
            String input = in.nextLine().toUpperCase();
            if(curTraits < maxTraits) {
                if (Trait.exists(input)) {
                    Trait traitObject = Trait.getTrait(input);
                    if (!traits.contains(traitObject)) {
                        traits.add(traitObject);
                        curTraits++;
                        validTraits = true;
                    }
                }
                else if(input.equals("ACCEPT")) {
                    approval = true;
                }
            }
        }
        System.out.println("The world destined you the burden of: " + traits.toString());
    }

    public void characterCreation() {
        promptName();
        promptClassType();
        promptRace();
        promptTraits();
    }

}
