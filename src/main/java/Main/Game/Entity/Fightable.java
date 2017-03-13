package Main.Game.Entity;


import Main.Game.Entity.Entities.Books.AbilityBooks.Ability;
import Main.Game.Entity.Entities.Books.PassiveBooks.PerkBook.Perk;
import Main.Game.Entity.Entities.Entities;

import java.util.HashMap;

public interface Fightable {
    public abstract void attack(Entities entities1,Entities entities2);
    public abstract void cast(Entities entities1,Entities entities2);
    public abstract void item(Entities entities1,Entities entities2);
    public abstract boolean escape(Entities entities1,Entities entities2);
    public abstract HashMap<Entity, Integer> receivePhysicalDamage(int damage, String actor);
    public abstract HashMap receiveSpellDamage(int damage, String actor);
    public abstract void checkLeathal();

    public abstract void addToSkillbook(Ability ability);
    public abstract void addToSpellbook(Ability ability);
    public abstract void addToPerkbook(Perk perk);

}
