package Main.Game.Team.Entity.Components.Map.TileLists;


import Main.Game.Team.Team;

public abstract class Tile {

    public abstract void printTile();

    public abstract String toString();

    public abstract void chooseAction(Team team);

    public abstract void searchArea();

    public abstract void camp();

    public abstract void wander();

}