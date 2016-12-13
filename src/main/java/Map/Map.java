package Map;

import Map.TileLists.Tile;


public class Map {

    private Object[] map;
    private int x = 0;
    private int y = 0;

    public Map(Object[] map) {
        this.map = map;
    }



    public void printMap() {
        for(int i = 0; i < this.map.length;i++){
            String row = "";
            for(Tile tile : (Tile[])this.map[i]){
                row += tile.toString();
            }
            System.out.println(row);
        }

    }
    public void choiceDirections() {

    }

}
