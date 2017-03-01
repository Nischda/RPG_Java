package Main.Game.Entity.Entities.Book.Books;


import Main.Game.Entity.Entity;

import java.util.ArrayList;

public abstract class Ability {

    public abstract void use(Entity actor, int damage, ArrayList<Entity> target);
    public abstract void aiUse(Entity actor, int damage, ArrayList<Entity> target);
    public abstract boolean fulfillRequirement();
    public abstract String toString();
}