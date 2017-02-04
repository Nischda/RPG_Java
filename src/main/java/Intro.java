import Entities.Player;
import Entities.ProfessionLists.Profession;
import Entities.RaceLists.*;
import Entities.TraitLists.CustomTraitList;
import Entities.TraitLists.Trait;

import java.util.Scanner;

public class Intro {

    private String name;
    private Profession profession;
    private Race race;
    private CustomTraitList customTraitList = new CustomTraitList();

    private Scanner in = new Scanner(System.in);


    public void promptName() {
        boolean validName = false;
        while (!validName) {
            System.out.println("From now on you will be known as ...");
             name = in.nextLine();
            if (name.length() >= 3 && name.length() <= 20) {
                validName = true;
            }
        }
        System.out.println("From now on you will be known as " + name);

    }

    public void promptClassType() {
        boolean validProfession = false;

        while (!validProfession) {
            System.out.println("You are widely known as a professional ...");
            System.out.println(Profession.toS());
            String professionName = in.nextLine().toUpperCase();
            if (Profession.include(professionName)) {
                this.profession = Profession.getProfession(professionName);
                validProfession = true;
            }
        }
        System.out.println("You are widely known as a professional " + this.profession);
    }

    public void promptRace() {
        boolean validRace = false;

        while (!validRace) {
            System.out.println("You are a proud ...");
            System.out.println(Race.toS());
            String raceName = in.nextLine().toUpperCase();
            if (Race.include(raceName)) {
                this.race = Race.getRace(raceName);
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
            System.out.println("Enter up to 3 of the following traits: ");
            System.out.println(Trait.toS());
            System.out.println("Enter 'ACCEPT' to continue");
            System.out.println("Current traits: " + curTraits + "/" + maxTraits + ": " +  customTraitList.toString());
            String input = in.nextLine().toUpperCase();
            if(curTraits < maxTraits) {
                if (Trait.include(input)) {
                    Trait traitObject = Trait.getTrait(input);
                    if (!customTraitList.include(traitObject)) {
                        customTraitList.addToList(traitObject);
                        curTraits++;
                        validTraits = true;
                    }
                }
                else if(input.equals("ACCEPT")) {
                    approval = true;
                }
            }
        }
        System.out.println("The world destined you the burden of: " + customTraitList.toString());
    }
    public Player playerCreation() {
        boolean validInput = false;
        while(!validInput) {
            System.out.println("Do you want to crate a custom character? 'yes'/'no'");
            String createCharacter = in.nextLine().toUpperCase();
            System.out.println(createCharacter);
            if (createCharacter.equals("YES")) {
                promptName();
                promptClassType();
                promptRace();
                promptTraits();
                validInput = true;
            }
            else if(createCharacter.equals("NO")){
                this.name = "Bob";
                this.profession = Profession.getProfession("DUELIST");
                this.race = Race.getRace("DWARF");
                Trait traitObject = Trait.getTrait("CURSED");
                customTraitList.addToList(traitObject);
                validInput = true;
            }
        }
        System.out.println("You are the " + this.race + " " + this.name + " the " + this.profession + "and your traits are:" + customTraitList.toString() + ".");
        Player player = new Player(this.name,this.profession,this.race,this.customTraitList);
        return player;
}

}
