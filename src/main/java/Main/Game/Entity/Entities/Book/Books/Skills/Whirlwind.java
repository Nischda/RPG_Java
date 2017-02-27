package Main.Game.Entity.Entities.Book.Books.Skills;


import Main.Game.Entity.Entities.Book.Books.Ability;
import Main.Game.Entity.Entity;

import java.util.ArrayList;

public class Whirlwind extends Ability {

    @Override
    public void use(Entity actor, int damage, ArrayList<Entity> targets) {
        System.out.println("You attack all targets!");

        for(Entity target: targets) {
            target.receiveDamage(damage, actor.name());
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
