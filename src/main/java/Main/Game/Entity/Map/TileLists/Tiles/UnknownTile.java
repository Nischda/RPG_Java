package Main.Game.Entity.Map.TileLists.Tiles;

import Main.Game.Entity.Entities.NPCFactory;
import Main.Game.Entity.Entity;
import Main.Game.Entity.Map.Battlefield;
import Main.Game.Entity.Map.TileLists.Tile;
import Main.Game.Entity.Entities.Player;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class UnknownTile extends Tile {

    private Scanner in = new Scanner(System.in);
    Player player;
    ArrayList<Entity> enemyList;

    @Override
    public void printTile() {
        System.out.println("UnknownTile");
    }
    @Override
    public String toString() {
        return "?";
    }
    public String toS() {
        return "ERROR - should be known by now";
    }

    public void chooseAction(Player player) {
        initializeTile();
        this.player = player;
        boolean validAction = false;

        while(!validAction) {
            System.out.println("You are " + this.toS());
            System.out.println("What do you want to do? (scout/camp/inventory/wander)");
            String action = in.nextLine().toUpperCase();

            switch(action) {
                case "SCOUT":
                    searchArea();
                    validAction = true;
                    break;
                case "CAMP":
                    camp();
                    validAction = true;
                    break;
                case "INVENTORY":
                    //accessInventory
                    validAction = true;
                    break;
                case "WANDER":
                    wander();
                    validAction = true;
                    break;
                default:
                    System.out.println("You can't do that");
                    validAction = false;
                    break;
            }
        }
    }
    public void initializeTile() {
        this.enemyList = NPCFactory.createNPCs(3, 2);
    }

    public void searchArea() {
        System.out.println("You start to search the area...");
        Random intrandom = new Random();
        int rand = intrandom.nextInt(10) + 1;
        if(rand < 8) {
            hunt();
        }
        else{
            startEvent();
        }

    }
    public void startEvent() {
        System.out.println("You encountered a special event.");
    }

    public void camp() {
        System.out.println("You rest next to a tree.");
    }

    public void wander() {

    }

    public void hunt() {
        ArrayList<Entity> playerList= new ArrayList<>();
        playerList.add(this.player);

        System.out.println("You stumple upon:");
        Entity.printEntities(this.enemyList);
        Battlefield battlefield = new Battlefield(playerList, enemyList);
    }
}
