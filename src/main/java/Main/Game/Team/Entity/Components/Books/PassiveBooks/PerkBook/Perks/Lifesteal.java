package Main.Game.Team.Entity.Components.Books.PassiveBooks.PerkBook.Perks;

import Main.Game.Team.Entity.Components.Books.PassiveBooks.PerkBook.Perk;
import Main.Game.Team.Entity.Entity;
import Main.Game.Utility.Library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class Lifesteal extends Perk {

    private static String name = "lifesteal";
    private static String description = "DoublHit gives a 10% chance to hit enemies twice.";

    Random intRandom = new Random();
    private int chance = 1;

    @Override
    public void use(Entity actor, ArrayList<HashMap<Entity, Integer>> actions) {

        int rand = intRandom.nextInt(10) + 1;
        if(rand <= chance) {
            System.out.println("Perk " + this.toString() + " procced!");
            for(HashMap<Entity, Integer> action : actions) {
                for(Entity entity : action.keySet()) {
                    actor.addToHp(action.get(entity));
                }
            }
        }
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name;
    }
}
