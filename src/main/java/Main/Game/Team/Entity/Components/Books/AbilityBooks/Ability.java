package Main.Game.Team.Entity.Components.Books.AbilityBooks;


import Main.Game.Team.Team;
import Main.Game.Team.Entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Ability {

    public abstract ArrayList<HashMap<Entity, Integer>> use(Entity actor, int damage, Team targets);
    public abstract void aiUse(Entity actor, int damage, Team targets);
    public abstract boolean fulfillRequirement();
    public abstract String toString();
}