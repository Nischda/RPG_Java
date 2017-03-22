package Main.Game.Team.Entity.Components.Map;

import Main.Game.Team.Team;
import Main.Game.Team.Entity.Entity;

import java.util.*;


public class Battlefield {
    private Scanner in = new Scanner(System.in);
    private Team team1;
    private Team enemies;
    private boolean battleEnd = false;

    public Battlefield(Team team1, Team enemies) {
        this.team1 = team1;
        this.enemies = enemies;

        executeRound();
    }

    public void executeRound() {
        int roundCount = 0;

        while (!battleEnd) {
            boolean playerGotTurns = true;
            boolean enemyGotTurns = true;
            int turnCount = 0;
            team1.sortTeam();
            enemies.sortTeam();

            roundCount++;
            int playerTurnCount = 0;
            int enemyTurnCount = 0;
            while (playerGotTurns || enemyGotTurns) { //rounds end if every entity has acted
                turnCount++;
                //System.out.println("Round: " + roundCount + " | Turn: " + turnCount);
                System.out.println();
                if ((team1.get(0).getStatValue("speed") >= enemies.get(0).getStatValue("speed") && playerGotTurns) || (playerGotTurns && !enemyGotTurns)) {//Playerturn
                    playerTurnCount++;
                    if (playerTurnCount >= team1.size()) {
                        playerGotTurns = false;
                    }
                    executePlayerTurn(team1.get(0));
                    team1.rotate(-1);
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
        team1.printTeam();
        enemies.printTeam();
            boolean validAction = false;

            while(!validAction) {
                System.out.println("What do you want to do? (attack/cast/item/escape/)");
                String action = in.nextLine().toUpperCase();

                switch(action) {
                    case "ATTACK":
                        entity.attack(team1, enemies);
                        validAction = true;
                        break;
                    case "CAST":
                        entity.cast(team1, enemies);
                        validAction = true;
                        break;
                    case "ITEM":
                        entity.item(team1, enemies);
                        validAction = true;
                        break;
                    case "ESCAPE":
                        if(entity.escape(team1, enemies)) battleEnd = true;
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
        if(rand < 5) entity.attack(enemies, team1);
        else {
            entity.cast(enemies, team1);
        }
        //add item use chance of getInventory contains items
        //add escapechance if health is < 20%
        //add
    }


}