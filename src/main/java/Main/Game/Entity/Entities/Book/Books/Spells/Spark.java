package Main.Game.Entity.Entities.Book.Books.Spells;


import Main.Game.Entity.Entities.Book.Books.Ability;
import Main.Game.Entity.Entity;

public class Spark extends Ability {

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
        return "spark";
    }
}
