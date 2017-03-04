package Main.Game.Entity.Entities.Book.Books.Perks;

import Main.Game.Entity.Entities.Book.Books.Perk;
import Main.Game.Entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class DoubleHit extends Perk {

    private Scanner in = new Scanner(System.in);
    Random intRandom = new Random();
    private int chance = 9;

    @Override
    public void use(Entity actor, ArrayList<HashMap<Entity, Integer>> actions) {

        int rand = intRandom.nextInt(10) + 1;
        if(rand <= chance) {
            System.out.println("Perk " + this.toString() + " procced!");
            for(HashMap<Entity, Integer> action : actions) {
                for(Entity entity : action.keySet()) {
                    entity.receivePhysicalDamage(action.get(entity), actor.getName());
                }
            }
        }
    }

    @Override
    public boolean fulfillRequirement() {
        return true; //add conditions
    }
    @Override
    public String toString() {
        return "double hit";
    }
}
