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
        for(int x = 0; x < mapHeight; x++) {
            ArrayList<Tile> unknownTileList = new ArrayList<Tile>();
            for(int y = 0; y < mapLength; y++) {
                unknownTileList.add( new UnknownTile());
            }
            this.playerMap.add(unknownTileList);
        }
        this.playerMap.get(2).set(2, map.get(2).get(2)); //reveal Playerposition
    }

    public void chooseAction() {
        boolean validAction = false;

        while(!validAction) {
            System.out.println("You are on: " + map.get(x).get(y).toString());
            System.out.println("What do you want to do? (stay/walk/inventory)");
            String action = in.nextLine().toUpperCase();

            switch(action) {
                case "STAY":
                        hunt();
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

    private void printMap(int playerX, int playerY) {
        ArrayList<ArrayList<Tile>> newMap = this.playerMap;
        //newMap[playerX][playerY] = new PlayerTile();
        for(int i = 0; i < this.playerMap.size();i++){
            String row = "";
            for(Tile tile : this.playerMap.get(i)){
                row += " " + tile.toString();
            }
            System.out.println(row);
        }

    }
    private void chooseDirection() {
        boolean validDirection = false;

        while(!validDirection) {
            System.out.println("Where do you want to go? (N/E/S/W)");
            printMap(x,y);
            String direction = in.nextLine().toUpperCase();

            switch(direction) {
                case "N":
                    if(isPassable(x,y+1)) {
                        System.out.println("You walk north");
                        validDirection = true;
                        this.y++;
                    }
                    break;
                case "E":
                    if(isPassable(x+1,y)) {
                        System.out.println("You walk east");
                        validDirection = true;
                        this.x++;
                    }
                    break;
                case "S":
                    if(isPassable(x,y-1)) {
                        System.out.println("You walk south");
                        validDirection = true;
                        this.y--;
                    }
                    break;
                case "W":
                    if(isPassable(x-1,y)) {
                        System.out.println("You walk west");
                        validDirection = true;
                        this.x--;
                    }
                    break;
                default:
                    System.out.println("Can't walk there");
                    validDirection = false;
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
    public void hunt() {
        ArrayList<Entity> playerList= new ArrayList<>();
        playerList.add(this.player);
        ArrayList<Entity> enemyList = NPCFactory.createNPCs(3, 2);
        Battlefield battlefield = new Battlefield(playerList, enemyList);
    }

}
