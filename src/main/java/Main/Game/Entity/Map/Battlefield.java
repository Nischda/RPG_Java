package Main.Game.Entity.Map;

import Main.Game.Entity.Entities.Entities;
import Main.Game.Entity.Entity;

import java.util.*;


public class Battlefield {
    private Scanner in = new Scanner(System.in);
    private Entities entities1;
    private Entities enemies;
    private boolean battleEnd = false;

    public Battlefield(Entities entities1, Entities enemies) {
        this.entities1 = entities1;
        this.enemies = enemies;

        executeRound();
    }

    public void executeRound() {
        int roundCount = 0;

        while (!battleEnd) {
            boolean playerGotTurns = true;
            boolean enemyGotTurns = true;
            int turnCount = 0;
            entities1.sortEntities();
            enemies.sortEntities();

            roundCount++;
            int playerTurnCount = 0;
            int enemyTurnCount = 0;
            while (playerGotTurns || enemyGotTurns) { //rounds end if every entity has acted
                turnCount++;
                //System.out.println("Round: " + roundCount + " | Turn: " + turnCount);
                System.out.println();
                if ((entities1.get(0).getStatValue("endurance") >= enemies.get(0).getStatValue("endurance") && playerGotTurns) || (playerGotTurns && !enemyGotTurns)) {//Playerturn
                    playerTurnCount++;
                    if (playerTurnCount >= entities1.size()) {
                        playerGotTurns = false;
                    }
                    executePlayerTurn(entities1.get(0));
                    entities1.rotate(-1);
                }
                else if (enemyGotTurns) {//Enemyturn
                    enemyTurnCount++;
                    if (enemyTurnCount >= enemies.size()) {
                        enemyGotTurns = false;
                    }
                    executeNPCTurn(enemies.get(0));
                    enemies.rotate(-1);
                }
            }
        }
    }

    public void executePlayerTurn(Entity entity) {
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("Your turn:");
        entities1.printEntities();
        enemies.printEntities();
            boolean validAction = false;

            while(!validAction) {
                System.out.println("What do you want to do? (attack/cast/item/escape/)");
                String action = in.nextLine().toUpperCase();

                switch(action) {
                    case "ATTACK":
                        entity.attack(entities1, enemies);
                        validAction = true;
                        break;
                    case "CAST":
                        entity.cast(entities1, enemies);
                        validAction = true;
                        break;
                    case "ITEM":
                        entity.item(entities1, enemies);
                        validAction = true;
                        break;
                    case "ESCAPE":
                        if(entity.escape(entities1, enemies)) battleEnd = true;
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
        //System.out.println("Turn of: " + entity.toString());
        Random intRandom = new Random();
        int rand = intRandom.nextInt(10) + 1;
        if(rand < 5) entity.attack(enemies, entities1);
        else {
            entity.cast(enemies, entities1);
        }
        //add item use chance of inventory contains items
        //add escapechance if health is < 20%
        //add
    }


}