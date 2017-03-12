package Main.Game.Entity.Entities.Books.PassiveBooks;


import Main.Game.Entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Perk {

    public abstract void use(Entity actor, ArrayList<HashMap<Entity, Integer>> actions);
    public abstract String toString();
}