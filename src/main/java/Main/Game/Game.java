package Main.Game;

import Main.Game.Team.Entity.Components.Books.PassiveBooks.TraitBook.Trait;
import Main.Game.Team.Entity.Components.Books.ProfessionBooks.Profession;
import Main.Game.Team.Entity.Components.Books.RaceBooks.Race;
import Main.Game.Team.Team;
import Main.Game.Team.Entity.Components.Map.Map;
import Main.Game.Team.Entity.Components.Map.TileLists.Tile;
import Main.Game.Utility.FileHandler.TxtReader;

import java.util.ArrayList;

public class Game {

    private Team team;
    private boolean gameEnd = false;
    private Map worldMap;

    public Game(){
        initializeStuff();
        this.team = new Team("playerTeam");
        this.team.add(new Intro().playerCreation());
        this.team.add(new Intro().playerCreation());
        generateMap();
    }

    public void loop() {
        while(!gameEnd) {
            worldMap.chooseAction();
        }
    }

    public void generateMap() {
        ArrayList<ArrayList<Tile>> map = null;
        this.worldMap = new Map(this.team, TxtReader.generateMap());
    }

    public void initializeStuff() {
        Trait.initialize();
        Race.initialize();
        Profession.initialize();
    }
}
