package Main.Game.Team.Entity.Components.Books.AbilityBooks.SkillBook.Skills;


import Main.Game.Team.Entity.Components.Books.AbilityBooks.Ability;
import Main.Game.Team.Team;
import Main.Game.Team.Entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Whirlwind extends Ability {

    @Override
    public ArrayList<HashMap<Entity, Integer>> use(Entity actor, int damage, Team targets) {
        System.out.println("You attack all targets!");
        ArrayList<HashMap<Entity, Integer>> actions = new ArrayList<>();
        for(Entity target: targets) {
            actions.add(target.receivePhysicalDamage(damage, actor.getName()));
        }
        return actions;
    }
    @Override
    public void aiUse(Entity actor, int damage, Team targets) {
        System.out.println(actor.getName() + " uses " + this.toString() + ".");
        for(Entity target: targets) {
            target.receivePhysicalDamage(damage, actor.getName());
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
