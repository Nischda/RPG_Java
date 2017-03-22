package Main.Game;

import Main.Game.Team.Entity.Components.Books.PassiveBooks.TraitBook.Trait;
import Main.Game.Team.Entity.Components.Books.ProfessionBooks.Profession;
import Main.Game.Team.Entity.Components.Books.RaceBooks.Race;
import Main.Game.Team.Team;
import Main.Game.Team.Entity.Components.Map.Map;
import Main.Game.Team.Entity.Components.Map.TileLists.Tile;
import Main.Game.Utility.FileHandler.TxtReader;
import Main.Game.Utility.Input.Console;

import java.util.ArrayList;

public class Game {

    private Team team;
    private boolean gameEnd = false;
    private Map worldMap;

    public Game(){
        initialize();
    }

    public void initialize() {
        Trait.initialize();
        Race.initialize();
        Profession.initialize();
        this.team = new Team("playerTeam");
        this.team.add(new Intro().playerCreation());
        this.team.add(new Intro().playerCreation());
        generateMap();
    }

    public void loop() {
        while(!gameEnd) {
            worldMap.chooseAction();
        }
        restart();
    }

    public void generateMap() {
        ArrayList<ArrayList<Tile>> map = null;
        this.worldMap = new Map(this.team, TxtReader.generateMap());
    }

    private void restart() {
        String input = "";
        System.out.println("Would you like to dive in again? (yes)");
        boolean validInput = false;
        while (!validInput) {
            System.out.println("From now on you will be known as? (enter your name)");

            input = Console.getStringInput();
            if (input.equals("yes")) {
                validInput = true;
            }
            else {
                System.out.println("Try again.");
            }
        }
    }
}
