import Entities.Player;
import Map.Map;
import Map.TileLists.Tile;
import Map.TileLists.Tiles.*;

import java.util.ArrayList;
import java.util.Arrays;

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
        ArrayList<ArrayList<Tile>> map = new ArrayList<>();
        map.add(new ArrayList<>(Arrays.asList(new Mountain(),new Mountain(),new Mountain(),new Mountain(),new Mountain())));
        map.add(new ArrayList<>(Arrays.asList(new Ocean(), new Road(), new Plain(), new Forest(), new Ocean())));
        map.add(new ArrayList<>(Arrays.asList(new Ocean(), new Road(), new Plain(), new Plain(), new Ocean())));
        map.add(new ArrayList<>(Arrays.asList(new Ocean(), new Road(), new Road(), new Plain(), new Ocean())));
        map.add(new ArrayList<>(Arrays.asList(new Ocean(), new Village(), new Road(), new Forest(), new Ocean())));

      this.worldMap = new Map(this.player, map);
    }
}
