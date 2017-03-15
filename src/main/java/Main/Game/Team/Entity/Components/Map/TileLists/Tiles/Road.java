package Main.Game.Team.Entity.Components.Map.TileLists.Tiles;

import Main.Game.Team.Team;
import Main.Game.Team.Entity.Components.Map.Battlefield;
import Main.Game.Team.Entity.Components.Map.TileLists.Tile;
import Main.Game.Team.Entity.Entity;
import Main.Game.Utility.Factories.NPCFactory;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class Road extends Tile {

    private String creaturePath = "D:/RPG_Java/src/main/resources/Tiles/roadCreatures.txt";
    private Scanner in = new Scanner(System.in);
    Team team;
    Team enemies;

    @Override
    public void printTile() {
        System.out.println("Road");
    }

    @Override
    public String toString() {
        return "R";
    }
    public String toS() {
        return "on a road";
    }

    public void chooseAction(Team team) {
        initializeTile();
        this.team = team;
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
        this.enemies = NPCFactory.createNPCs(new File(creaturePath),2,1); //ToDo add Ranges
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
        System.out.println("You stumple upon:");
        Entity.printEntities(this.enemies);
        Battlefield battlefield = new Battlefield(team, enemies);
    }
}