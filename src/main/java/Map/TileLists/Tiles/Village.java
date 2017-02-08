package Map.TileLists.Tiles;

import Map.TileLists.Tile;

public class Village extends Tile {

    @Override
    public void printTile() {
        System.out.println("Village");
    }
    @Override
    public String toString() {
       return "V";
    }
    public String toS() {
        return "in a village";
    }
}
