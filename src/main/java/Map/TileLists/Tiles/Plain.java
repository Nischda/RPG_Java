package Map.TileLists.Tiles;


import Map.TileLists.Tile;

public class Plain extends Tile{


    @Override
    public void printTile() {
        System.out.println("Plain");
    }
    @Override
    public String toString() {
        return "P";
    }
}
