package Map;

import Entities.Entity;
import Entities.NPCFactory;
import Entities.Player;
import Map.TileLists.Tile;
import Map.TileLists.Tiles.PlayerTile;
import Map.TileLists.Tiles.UnknownTile;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Map {

    private Player player;
    private Scanner in = new Scanner(System.in);
    private ArrayList<ArrayList<Tile>> map;
    private ArrayList<ArrayList<Tile>> playerMap;
    private int x = 2;
    private int y = 2;

    public Map(Player player,ArrayList<ArrayList<Tile>> map) {
        this.player = player;
        this.map = map;
        createPlayerMap();

    }


    public void createPlayerMap() {
        int mapHeight = this.map.size();
        int mapLength = this.map.get(0).size();
        playerMap = new ArrayList<ArrayList<Tile>>();
        for(int y = 0; y < mapHeight; y++) {
            ArrayList<Tile> unknownTileList = new ArrayList<Tile>();
            for(int x = 0; x < mapLength; x++) {
                unknownTileList.add( new UnknownTile());
            }
            this.playerMap.add(unknownTileList);
        }
        this.playerMap.get(y).set(x, map.get(y).get(x));
    }
    public void updatePlayerMap() {
        this.playerMap.get(y).set(x, map.get(y).get(x)); //reveal Playerposition
    }

    private void printPlayerMap() {
        ArrayList<ArrayList<Tile>> newMap = (ArrayList<ArrayList<Tile>>) this.playerMap.clone(); //make deepclone instead of if check?
        for(int i = 0; i < this.playerMap.size();i++){
            String row = "";
            for(int j = 0; j < this.playerMap.get(i).size(); j++){
                if(i == y && j == x) {
                    row += "-" + this.playerMap.get(i).get(j).toString();
                }
                else {
                    row += " " + this.playerMap.get(i).get(j).toString();
                }
            }
            System.out.println(row);
        }

    }
    private void chooseDirection() {
        boolean validDirection = false;

        while(!validDirection) {
            System.out.println("Where do you want to go? (N/E/S/W)");
            System.out.println(y + " " + x);
            System.out.println(this.map.get(y).get(x));
            printPlayerMap();
            String direction = in.nextLine().toUpperCase();

            switch(direction) {
                case "N":
                    if(isPassable(y-1, x)) {
                        System.out.println("You walk north");
                        validDirection = true;
                        this.y--;
                    }
                    break;
                case "W":
                    if(isPassable(y, x-1)) {
                        System.out.println("You walk east");
                        validDirection = true;
                        this.x--;
                    }
                    break;
                case "S":
                    if(isPassable(y+1, x)) {
                        System.out.println("You walk south");
                        validDirection = true;
                        this.y++;
                    }
                    break;
                case "E":
                    if(isPassable(y, x+1)) {
                        System.out.println("You walk west");
                        validDirection = true;
                        this.x++;
                    }
                    break;
                default:
                    System.out.println("Can't walk there");
                    validDirection = false;
                    break;
            }
        }
        updatePlayerMap();

    }

    public void chooseAction() {
        boolean validAction = false;

        while(!validAction) {
            System.out.println("You are on: " + map.get(y).get(x).toString());
            printPlayerMap();
            System.out.println("What do you want to do? (stay/walk/inventory)");
            String action = in.nextLine().toUpperCase();

            switch(action) {
                case "STAY":
                    stay();
                    validAction = true;
                    break;
                case "WALK":
                    chooseDirection();
                    validAction = true;
                    break;
                case "INVENTORY":
                    //accessInventory();
                    validAction = true;
                    break;
                default:
                    System.out.println("You can't do that");
                    validAction = false;
                    break;
            }
        }
    }

    public boolean isPassable(int x, int y) {
        String locationName = this.map.get(x).get(y).toString();
        if(locationName.equals("O")
                || locationName.equals("M")) {
            System.out.println("Destination is not passable");
            return false;
        }
        return true;
    }

    public void stay() {
        Tile tile = map.get(y).get(x);
        tile.chooseAction(this.player);
    }

}
