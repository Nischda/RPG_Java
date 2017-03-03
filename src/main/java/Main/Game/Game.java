package Main.Game;

import Main.Game.Entity.Entities.ProfessionLists.Professions.*;
import Main.Game.Entity.Entities.RaceLists.Races.*;
import Main.Game.Entity.Entities.TraitLists.Traits.Cursed;
import Main.Game.Entity.Map.Map;
import Main.Game.Entity.Entities.Player;
import Main.Game.Entity.Map.TileLists.Tile;

import java.util.ArrayList;

public class Game {

    private Player player;
    private boolean gameEnd = false;
    private Map worldMap;

    public Game(){
        initializeStuff();
        this.player = new Intro().playerCreation();
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
        this.worldMap = new Map(this.player, txtReader.generateMap());
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
