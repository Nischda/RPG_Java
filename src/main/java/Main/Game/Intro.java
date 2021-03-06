package Main.Game;

import Main.Game.Team.Entity.Components.Books.PassiveBooks.TraitBook.Trait;
import Main.Game.Team.Entity.Components.Books.PassiveBooks.TraitBook.TraitBook;
import Main.Game.Team.Entity.Components.Books.ProfessionBooks.Profession;
import Main.Game.Team.Entity.Entities.Player;
import Main.Game.Team.Entity.Components.Books.RaceBooks.Race;
import Main.Game.Utility.Input.Console;

public class Intro {

    private String name;
    private Profession profession;
    private Race race;
    private TraitBook traitBook = new TraitBook();

    public void promptName() {
        boolean validName = false;
        while (!validName) {
            System.out.println("From now on you will be known as? (enter your name)");

            Console.input(); //Todo redo for capitalized name
            if (Console.gotBuffer()) {
                 this.name = Console.getBuffer();
                if (this.name.length() >= 3 && this.name.length() <= 20) {
                    validName = true;
                } else {
                    System.out.println("Try again.");
                }
            }
        }
        System.out.println(String.format("From now on you will be known as %s.\n", this.name));
    }

    public void promptClassType() {
        boolean validProfession = false;

        while (!validProfession) {
            System.out.println("You are widely known as a professional? (enter your profession)");
            System.out.println(Profession.toS());
            Console.input();
            if(Console.gotBuffer()) {
                String professionName = Console.getBuffer();

                if (Profession.include(professionName)) {
                    this.profession = Profession.getProfession(professionName);
                    validProfession = true;
                } else {
                    System.out.println("Try again.");
                }
            }
        }
        System.out.println(String.format("You are widely known as a professional %s.\n", this.profession));
    }

    public void promptRace() {
        boolean validRace = false;

        while (!validRace) {
            System.out.println("You are a proud? (enter your race)");
            System.out.println(Race.toS());
            Console.input();
            if(Console.gotBuffer()) {
                String raceName = Console.getBuffer();

                if (Race.include(raceName)) {
                    this.race = Race.getRace(raceName);
                    validRace = true;
                } else {
                    System.out.println("Try again.");
                }
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
            Trait.toS();
            System.out.println(String.format("Current traits: %s/%s:%s.", curTraits, maxTraits, traitBook.toString()));
            Console.input();
            if(Console.gotBuffer()) {
                String input = Console.getBuffer();

                if (curTraits < maxTraits) {
                    validTraits = true;
                    if (Trait.include(input)) {
                        Trait traitObject = Trait.getTrait(input);
                        if (!traitBook.contains(input)) {
                            traitBook.add(traitObject);
                            curTraits++;
                        }
                    } else if (input.equals("accept")) {
                        approval = true;
                    }
                } else {
                    approval = true;
                }
            }
        }
        System.out.println(String.format("The world destined you the burden of: %s", traitBook.toString()));
    }
    public Player playerCreation() {
        boolean validInput = false;
        while(!validInput) {
            System.out.println("Do you want to crate a custom character? (yes/no)");
            Console.input();
            if(Console.gotBuffer()) {
                String createCharacter = Console.getBuffer();

                System.out.println(createCharacter);
                if (createCharacter.equals("yes")) {
                    promptName();
                    promptClassType();
                    promptRace();
                    promptTraits();
                    validInput = true;
                } else if (createCharacter.equals("no")) {
                    this.name = "Bob";
                    this.profession = Profession.getProfession("duelist");
                    this.race = Race.getRace("dwarf");
                    Trait traitObject = Trait.getTrait("cursed");
                    traitBook.add(traitObject);
                    validInput = true;
                }
            }
        }
        System.out.println(String.format("You are the %s %s. You are a skillful %s and your traits are: %s.", this.race, this.name, this.profession, traitBook.toString()));
        return new Player(this.name,this.profession,this.race,this.traitBook);
}

}
