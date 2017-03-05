package Main.Game;

import Main.Game.Entity.Entities.Entities;
import Main.Game.Entity.Entities.ProfessionLists.Professions.*;
import Main.Game.Entity.Entities.RaceLists.Races.*;
import Main.Game.Entity.Entities.TraitLists.Traits.Cursed;
import Main.Game.Entity.Map.Map;
import Main.Game.Entity.Map.TileLists.Tile;

import java.util.ArrayList;

public class Game {

    private Entities entities;
    private boolean gameEnd = false;
    private Map worldMap;

    public Game(){
        initializeStuff();
        this.entities = new Entities("playerTeam");
        this.entities.add(new Intro().playerCreation());
        this.entities.add(new Intro().playerCreation());
        generateMap();
    }

    public void loop() {
        while(!gameEnd) {
            worldMap.chooseAction();
        }
    }

    public void generateMap() {
        TxtReader txtReader = new TxtReader();
        ArrayList<ArrayList<Tile>> map = null;
        this.worldMap = new Map(this.entities, txtReader.generateMap());
    }

    public void initializeStuff() {
        new Duelist().addToList();
        new Bruiser().addToList();
        new Knight().addToList();
        new Kabbalist().addToList();
        new Trickster().addToList();
        new Carnivore().addToList();
        new Craftsman().addToList();
        new Farmer().addToList();
        new Fighter().addToList();
        new Omnivore().addToList();
        new Spiritualist().addToList();

        new Dwarf().addToList();
        new Elf().addToList();
        new Ent().addToList();
        new Necrotic().addToList();
        new Beast().addToList();
        new Dragon().addToList();
        new Giant().addToList();
        new Gnome().addToList();
        new Naga().addToList();
        new Orc().addToList();
        new Human().addToList();

        new Cursed().addToList();
    }
}
