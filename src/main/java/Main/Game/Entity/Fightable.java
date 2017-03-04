package Main.Game.Entity;


import Main.Game.Entity.Entities.Book.Books.Ability;
import Main.Game.Entity.Entities.Book.Books.Perk;

import java.util.ArrayList;
import java.util.HashMap;

public interface Fightable {
    public abstract void attack(ArrayList<Entity> players, ArrayList<Entity> enemies);
    public abstract void cast(ArrayList<Entity> players, ArrayList<Entity> enemies);
    public abstract void item(ArrayList<Entity> players, ArrayList<Entity> enemies);
    public abstract boolean escape(ArrayList<Entity> players, ArrayList<Entity> enemies);
    public abstract HashMap<Entity, Integer> receivePhysicalDamage(int damage, String actor);
    public abstract HashMap receiveSpellDamage(int damage, String actor);
    public abstract void checkLeathal();

    public abstract void addToSkillbook(Ability ability);
    public abstract void addToSpellbook(Ability ability);
    public abstract void addToPerkbook(Perk perk);

}
