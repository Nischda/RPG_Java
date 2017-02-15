package Main.Game;

import Main.Game.Entity.ProfessionLists.Profession;
import Main.Game.Entity.Entities.Player;
import Main.Game.Entity.Entities.RaceLists.Race;
import Main.Game.Entity.Entities.TraitLists.CustomTraitList;
import Main.Game.Entity.Entities.TraitLists.Trait;

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
            String professionName = in.nextLine().toUpperCase();
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
            String raceName = in.nextLine().toUpperCase();
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
            System.out.println(String.format("Current traits: %s/%s:%s.", curTraits, maxTraits, customTraitList.toString()));
            String input = in.nextLine().toUpperCase();
            if(curTraits < maxTraits) {
                validTraits = true;
                if (Trait.include(input)) {
                    Trait traitObject = Trait.getTrait(input);
                    if (!customTraitList.include(traitObject)) {
                        customTraitList.addToList(traitObject);
                        curTraits++;
                    }
                }
                else if(input.equals("ACCEPT")) {
                    approval = true;
                }
            }
        }
        System.out.println(String.format("The world destined you the burden of: %s", customTraitList.toString()));
    }
    public Player playerCreation() {
        boolean validInput = false;
        while(!validInput) {
            System.out.println("Do you want to crate a custom character? (yes/no)");
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
        System.out.println(String.format("You are the %s %s. You are a skillful %s and your traits are: %s.", this.race, this.name, this.profession, customTraitList.toString()));
        return new Player(this.name,this.profession,this.race,this.customTraitList);
}

}
