package Main.Game.Entity;


import java.util.ArrayList;

public interface Fightable {
    public abstract void attack(ArrayList<Entity> players, ArrayList<Entity> enemies);
    public abstract void cast(ArrayList<Entity> players, ArrayList<Entity> enemies);
    public abstract void item(ArrayList<Entity> players, ArrayList<Entity> enemies);
    public abstract boolean escape(ArrayList<Entity> players, ArrayList<Entity> enemies);
    public abstract void receivePhysicalDamage(int damage, String actor);
    public abstract void receiveSpellDamage(int damage, String actor);
    public abstract void checkLeathal();
}
