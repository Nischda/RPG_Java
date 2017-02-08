package Map.TileLists.Tiles;

import Map.TileLists.Tile;

public class UnknownTile extends Tile {

    @Override
    public void printTile() {
        System.out.println("UnknownTile");
    }
    @Override
    public String toString() {
        return "?";
    }
    public String toS() {
        return "ERROR - should be known by now";
    }
}
