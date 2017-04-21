package Main.Game.Team.Entity.Components.Map;

import Main.Game.Team.Team;
import Main.Game.Utility.Input.Console;
import Main.Game.Team.Entity.Components.Map.TileLists.Tile;
import Main.Game.Team.Entity.Components.Map.TileLists.Tiles.UnknownTile;

import java.util.ArrayList;

public class Map {

    private Team team;
    private ArrayList<ArrayList<Tile>> map;
    private ArrayList<ArrayList<Tile>> playerMap;
    private int x = 2;
    private int y = 2;

    public Map(Team team, ArrayList<ArrayList<Tile>> map) {
        this.team = team;
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
            Console.input();
            if(Console.gotBuffer()) {
                String direction = Console.getBuffer();


                switch (direction) {
                    case "n":
                        if (isPassable(y - 1, x)) {
                            System.out.println("You walk north");
                            validDirection = true;
                            this.y--;
                        }
                        break;
                    case "w":
                        if (isPassable(y, x - 1)) {
                            System.out.println("You walk east");
                            validDirection = true;
                            this.x--;
                        }
                        break;
                    case "s":
                        if (isPassable(y + 1, x)) {
                            System.out.println("You walk south");
                            validDirection = true;
                            this.y++;
                        }
                        break;
                    case "e":
                        if (isPassable(y, x + 1)) {
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
        }
        updatePlayerMap();

    }

    public void chooseAction() {
        boolean validAction = false;

        while(!validAction) {
            System.out.println("You are on: " + map.get(y).get(x).toString());
            printPlayerMap();
            System.out.println("What do you want to do? (stay/walk/use/equip)");
            Console.input();
            if (Console.gotBuffer()) {
                String action = Console.getBuffer();

                switch (action) {
                    case "stay":
                        stay();
                        validAction = true;
                        break;
                    case "walk":
                        chooseDirection();
                        validAction = true;
                        break;
                    case "use":
                        team.useItem();
                        validAction = true;
                        break;
                    case "equip":
                        team.equipItem();
                        validAction = true;
                        break;
                    default:
                        System.out.println("You can't do that");
                        validAction = false;
                        break;
                }
                System.out.println("----------------------------------------------------------------------------------------------------");
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
        tile.chooseAction(this.team);
    }

}
