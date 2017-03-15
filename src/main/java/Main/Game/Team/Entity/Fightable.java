package Main.Game.Team.Entity;


import Main.Game.Team.Entity.Components.Books.AbilityBooks.Ability;
import Main.Game.Team.Entity.Components.Books.PassiveBooks.PerkBook.Perk;
import Main.Game.Team.Team;

import java.util.HashMap;

public interface Fightable {
    public abstract void attack(Team team1, Team team2);
    public abstract void cast(Team team1, Team team2);
    public abstract void item(Team team1, Team team2);
    public abstract boolean escape(Team team1, Team team2);
    public abstract HashMap<Entity, Integer> receivePhysicalDamage(int damage, String actor);
    public abstract HashMap receiveSpellDamage(int damage, String actor);
    public abstract void checkLeathal();

    public abstract void addToSkillbook(Ability ability);
    public abstract void addToSpellbook(Ability ability);
    public abstract void addToPerkbook(Perk perk);

}
