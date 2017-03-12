package Main.Game.Entity.Entities.Books.AbilityBooks.Skills;


import Main.Game.Entity.Entities.Books.AbilityBooks.Ability;
import Main.Game.Entity.Entities.Entities;
import Main.Game.Entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Whirlwind extends Ability {

    @Override
    public ArrayList<HashMap<Entity, Integer>> use(Entity actor, int damage, Entities targets) {
        System.out.println("You attack all targets!");
        ArrayList<HashMap<Entity, Integer>> actions = new ArrayList<>();
        for(Entity target: targets) {
            actions.add(target.receivePhysicalDamage(damage, actor.name()));
        }
        return actions;
    }
    @Override
    public void aiUse(Entity actor, int damage, Entities targets) {
        System.out.println(actor.getName() + " uses " + this.toString() + ".");
        for(Entity target: targets) {
            target.receivePhysicalDamage(damage, actor.name());
        }
    }

    @Override
    public boolean fulfillRequirement() {
        return true; //add conditions
    }
    @Override
    public String toString() {
        return "whirlwind";
    }
}
