package Main.Game.Entity.Entities.Book.Books;


import Main.Game.Entity.Entities.Entities;
import Main.Game.Entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Ability {

    public abstract ArrayList<HashMap<Entity, Integer>> use(Entity actor, int damage, Entities targets);
    public abstract void aiUse(Entity actor, int damage, Entities targets);
    public abstract boolean fulfillRequirement();
    public abstract String toString();
}