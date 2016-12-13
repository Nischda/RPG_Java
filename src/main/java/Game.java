import Entities.Player;
import Map.Map;
import Map.TileLists.Tile;
import Map.TileLists.Tiles.*;

public class Game {

    private Player player;
    private Map map;

    public Game(){
        this.player = new Intro().playerCreation();
        this.map = new Map(new Object[] {
                new Tile[]{   new Mountain(), new Mountain(), new Mountain(), new Mountain(), new Mountain()},
                new Tile[]{   new Ocean(), new Road(), new Plain(), new Forest(), new Ocean()},
                new Tile[]{   new Ocean(), new Road(), new Plain(), new Plain(), new Ocean()},
                new Tile[]{   new Ocean(), new Road(), new Road(), new Plain(), new Ocean()},
                new Tile[]{   new Ocean(), new Village(), new Road(), new Forest(), new Ocean()},
                });
    }

    public void loop() {
        map.choiceDirections();
        map.printMap();
    }
}
