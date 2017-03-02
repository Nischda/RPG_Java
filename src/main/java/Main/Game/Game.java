package Main.Game;

import Main.Game.Entity.Map.Map;
import Main.Game.Entity.Entities.Player;
import Main.Game.Entity.Map.TileLists.Tile;

import java.util.ArrayList;

public class Game {

    private Player player;
    private boolean gameEnd = false;
    private Map worldMap;

    public Game(){
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
}
