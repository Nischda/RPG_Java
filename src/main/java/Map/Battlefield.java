package Map;

import Entities.Entity;

import java.util.*;


public class Battlefield {
    private Scanner in = new Scanner(System.in);
    private ArrayList<Entity> players;
    private ArrayList<Entity> enemies;

    public Battlefield(ArrayList<Entity> players, ArrayList<Entity> enemies) {
        this.players = players;
        this.enemies = enemies;

        executeRound();
    }

    public void executeRound() {
        boolean battleEnd = false;
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
            System.out.println("Round: " + roundCount);
            while (playerGotTurns || enemyGotTurns) {

                turnCount++;
                System.out.println("Turn: " + turnCount);
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
        String input;
        System.out.println("Your turn: " + entity.toString());
        System.out.println("What do you want to do?");
        input = in.nextLine().toUpperCase();
        System.out.println("Nothing has been done");
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