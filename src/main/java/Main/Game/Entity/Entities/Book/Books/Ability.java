package Main.Game.Entity.Entities.Book.Books;


import Main.Game.Entity.Entity;

public abstract class Ability {

    public abstract void use(Entity actor, int damage, Entity target);
    public abstract boolean fulfillRequirement();
    public abstract String toString();
}