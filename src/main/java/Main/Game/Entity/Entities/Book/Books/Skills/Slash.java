package Main.Game.Entity.Entities.Book.Books.Skills;


import Main.Game.Entity.Entities.Book.Books.Ability;
import Main.Game.Entity.Entity;

public class Slash extends Ability {

    public void use(Entity actor, int damage, Entity target) {
        target.receiveDamage(damage, actor.name());
    }
}
