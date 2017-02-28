package Main.Game.Entity.Map;

import Main.Game.Entity.Entity;

import java.util.*;


public class Battlefield {
    private Scanner in = new Scanner(System.in);
    private ArrayList<Entity> players;
    private ArrayList<Entity> enemies;
    private boolean battleEnd = false;

    public Battlefield(ArrayList<Entity> players, ArrayList<Entity> enemies) {
        this.players = players;
        this.enemies = enemies;

        executeRound();
    }

    public void executeRound() {
        int playerTurnCount = 0;
        int enemyTurnCount = 0;
        int roundCount = 0;

        while (!battleEnd) {
            boolean playerGotTurns = true;
            boolean enemyGotTurns = true;
            int turnCount = 0;
            sortEntities(players);
            sortEntities(enemies);

            roundCount++;
            while (playerGotTurns || enemyGotTurns) { //rounds end if every entity has acted
                turnCount++;
                System.out.println("Round: " + roundCount + " | Turn: " + turnCount);
                if ((players.get(0).getEndurance() >= enemies.get(0).getEndurance() && playerGotTurns) || (playerGotTurns && !enemyGotTurns)) {//Playerturn
                    playerTurnCount++;
                    if (playerTurnCount >= players.size() - 1) {
                        playerGotTurns = false;
                    }
                    executePlayerTurn(players.get(0));
                    Collections.rotate(players, -1);
                }
                else if (enemyGotTurns) {//Enemyturn
                    enemyTurnCount++;
                    if (enemyTurnCount >= enemies.size() - 1) {
                        enemyGotTurns = false;
                    }
                    executeNPCTurn(enemies.get(0));
                    Collections.rotate(enemies, -1);
                }
            }
        }
    }

    public void executePlayerTurn(Entity entity) {
        System.out.println("Your turn:");
        Entity.printEntities(this.players);
        Entity.printEntities(this.enemies);
            boolean validAction = false;

            while(!validAction) {
                System.out.println("What do you want to do? (attack/cast/item/escape/)");
                String action = in.nextLine().toUpperCase();

                switch(action) {
                    case "ATTACK":
                        entity.attack(players, enemies);
                        validAction = true;
                        break;
                    case "CAST":
                        entity.cast(players, enemies);
                        validAction = true;
                        break;
                    case "ITEM":
                        entity.item(players, enemies);
                        validAction = true;
                        break;
                    case "ESCAPE":
                        if(entity.escape(players, enemies)) battleEnd = true;
                        validAction = true;
                        break;
                    default:
                        System.out.println("You can't do that");
                        validAction = false;
                        break;
                }
            }
    }

    public void executeNPCTurn(Entity entity) {
        System.out.println("Turn of: " + entity.toString());
    }

    private void sortEntities(ArrayList<Entity> entities) {
        Collections.sort(entities, new Comparator<Entity>() {
            @Override
            public int compare(Entity e1, Entity e2) {
                return e1.getEndurance() - e2.getEndurance();
            }
        });
    }


}