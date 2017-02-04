package Map;

import Entities.Entity;
import Entities.Player;
import Map.TileLists.Tile;

import java.util.ArrayList;
import java.util.Scanner;

public class Map {

    private Player player;
    private Scanner in = new Scanner(System.in);
    private Tile[][] map;
    private int x = 2;
    private int y = 2;

    public Map(Player player, Tile[][] map) {
        this.player = player;
        this.map = map;

    }

    public void chooseAction() {
        boolean validAction = false;

        while(!validAction) {
            System.out.println("You are on: " + map[x][y].toString());
            System.out.println("What do you want to do? Stay/Walk/Inventory");
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

    private void printMap() {
        for(int i = 0; i < this.map.length;i++){
            String row = "";
            for(Tile tile : (Tile[])this.map[i]){
                row += " " + tile.toString();
            }
            System.out.println(row);
        }

    }
    private void chooseDirection() {
        boolean validDirection = false;

        while(!validDirection) {
            System.out.println("Where do you want to go? N/E/S/W");
            printMap();
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
        String locationName = this.map[x][y].toString();
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
        System.out.println(player.getHp());
        ArrayList<Entity> enemyList = new ArrayList<>();
        enemyList.add(this.player);
        Battlefield battlefield = new Battlefield(playerList, enemyList);
    }
}
