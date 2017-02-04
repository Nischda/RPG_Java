import Entities.Player;
import Map.Map;
import Map.TileLists.Tile;
import Map.TileLists.Tiles.*;

public class Game {

    private Player player;
    private boolean gameEnd = false;
    private Map map;

    public Game(){
        this.player = new Intro().playerCreation();
        this.map = new Map(this.player, new Tile[][] {
                new Tile[]{   new Mountain(), new Mountain(), new Mountain(), new Mountain(), new Mountain()},
                new Tile[]{   new Ocean(), new Road(), new Plain(), new Forest(), new Ocean()},
                new Tile[]{   new Ocean(), new Road(), new Plain(), new Plain(), new Ocean()},
                new Tile[]{   new Ocean(), new Road(), new Road(), new Plain(), new Ocean()},
                new Tile[]{   new Ocean(), new Village(), new Road(), new Forest(), new Ocean()},
                });
    }

    public void loop() {
        while(!gameEnd) {
            map.chooseAction();
        }
    }
}
