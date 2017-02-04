package Map.TileLists.Tiles;

import Map.TileLists.Tile;

public class Mountain extends Tile {

    @Override
    public void printTile() {
        System.out.println("Mountain");
    }
    @Override
    public String toString() {
       return "M";
    }
}
