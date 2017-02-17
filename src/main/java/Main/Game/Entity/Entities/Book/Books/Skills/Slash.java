package Main.Game.Entity.Entities.Book.Books.Skills;


import Main.Game.Entity.Entities.Book.Books.Ability;
import Main.Game.Entity.Entity;

public class Slash extends Ability {

    @Override
    public void use(Entity actor, int damage, Entity target) {
        target.receiveDamage(damage, actor.name());
    }

    @Override
    public boolean fulfillRequirement() {
        return true; //add conditions
    }
    @Override
    public String toString() {
        return "slash";
    }
}
