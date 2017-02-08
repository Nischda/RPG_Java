package Map.TileLists.Tiles;


import Map.TileLists.Tile;

public class Forest extends Tile{


    @Override
    public void printTile() {
        System.out.println("Forest");
    }
    @Override
    public String toString() {
        return "F";
    }
    public String toS() {
        return "in a forest";
    }
}
