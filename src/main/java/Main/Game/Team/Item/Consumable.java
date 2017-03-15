package Main.Game.Team.Item;


import Main.Game.Team.Team;
import Main.Game.Team.Entity.Entity;

public interface Consumable {
    public void use(Team team1, Team team2);
    public void use(Entity target);
    public void effect();
}
