package Main.Game;

import Main.Game.Entity.Entities.ProfessionLists.Profession;
import Main.Game.Entity.Entities.Player;
import Main.Game.Entity.Entities.RaceLists.Race;
import Main.Game.Entity.Entities.TraitLists.TraitList;
import Main.Game.Entity.Entities.TraitLists.Trait;

import java.util.Scanner;

public class Intro {

    private String name;
    private Profession profession;
    private Race race;
    private TraitList traitList = new TraitList();

    private Scanner in = new Scanner(System.in);


    public void promptName() {
        boolean validName = false;
        while (!validName) {
            System.out.println("From now on you will be known as? (enter your name)");

             this.name = in.nextLine();
            if (this.name.length() >= 3 && this.name.length() <= 20) {
                validName = true;
            }
        }
        System.out.println(String.format("From now on you will be known as %s.\n", this.name));
    }

    public void promptClassType() {
        boolean validProfession = false;

        while (!validProfession) {
            System.out.println("You are widely known as a professional? (enter your profession)");
            System.out.println(Profession.toS());
            String professionName = in.nextLine().toLowerCase();
            if (Profession.include(professionName)) {
                this.profession = Profession.getProfession(professionName);
                validProfession = true;
            }
        }
        System.out.println(String.format("You are widely known as a professional %s.\n", this.profession));
    }

    public void promptRace() {
        boolean validRace = false;

        while (!validRace) {
            System.out.println("You are a proud? (enter your race)");
            System.out.println(Race.toS());
            String raceName = in.nextLine().toLowerCase();
            if (Race.include(raceName)) {
                this.race = Race.getRace(raceName);
                validRace = true;
            }
        }
        System.out.println(String.format("You are a proud %s.\n", this.race));
    }

    public void promptTraits() {
        boolean validTraits = false;
        int maxTraits = 3;
        int curTraits = 0;
        boolean approval = false;
        while (!validTraits || !approval) {
            System.out.println("The world destined you the burden of? (enter up to 3 traits, enter 'accept' to continue)");
            System.out.println(Trait.toS());
            System.out.println(String.format("Current traits: %s/%s:%s.", curTraits, maxTraits, traitList.toString()));
            String input = in.nextLine().toLowerCase();
            if(curTraits < maxTraits) {
                validTraits = true;
                if (Trait.include(input)) {
                    Trait traitObject = Trait.getTrait(input);
                    if (!traitList.include(traitObject)) {
                        traitList.addToList(traitObject);
                        curTraits++;
                    }
                }
                else if(input.equals("accept")) {
                    approval = true;
                }
            }
        }
        System.out.println(String.format("The world destined you the burden of: %s", traitList.toString()));
    }
    public Player playerCreation() {
        boolean validInput = false;
        while(!validInput) {
            System.out.println("Do you want to crate a custom character? (yes/no)");
            String createCharacter = in.nextLine().toLowerCase();
            System.out.println(createCharacter);
            if (createCharacter.equals("yes")) {
                promptName();
                promptClassType();
                promptRace();
                promptTraits();
                validInput = true;
            }
            else if(createCharacter.equals("no")){
                this.name = "Bob";
                this.profession = Profession.getProfession("duelist");
                this.race = Race.getRace("dwarf");
                Trait traitObject = Trait.getTrait("cursed");
                traitList.addToList(traitObject);
                validInput = true;
            }
        }
        System.out.println(String.format("You are the %s %s. You are a skillful %s and your traits are: %s.", this.race, this.name, this.profession, traitList.toString()));
        return new Player(this.name,this.profession,this.race,this.traitList);
}

}
