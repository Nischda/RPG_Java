package Map.TileLists.Tiles;


import Map.TileLists.Tile;

public class PlayerTile extends Tile{


    @Override
    public void printTile() {
        System.out.println("PlayerTile");
    }
    @Override
    public String toString() {
        return " ";
    }
    public String toS() {
        return "UNUSED";
    }
}
