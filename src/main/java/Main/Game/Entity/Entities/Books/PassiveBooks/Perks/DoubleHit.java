package Main.Game.Entity.Entities.Books.PassiveBooks.Perks;

import Main.Game.Entity.Entities.Books.PassiveBooks.Perk;
import Main.Game.Entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class DoubleHit extends Perk {

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
    public String toString() {
        return "double hit";
    }
}
