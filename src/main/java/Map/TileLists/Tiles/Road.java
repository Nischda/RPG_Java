package Map.TileLists.Tiles;

import Map.TileLists.Tile;

public class Road extends Tile {

    @Override
    public void printTile() {
        System.out.println("Road");
    }

    @Override
    public String toString() {
        return "R";
    }
    public String toS() {
        return "on a road";
    }
}
