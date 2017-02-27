package Main.Game.Entity.Map.TileLists;


import Main.Game.Entity.Entities.Player;

public abstract class Tile {

    public abstract void printTile();

    public abstract String toString();

    public abstract void chooseAction(Player player);

    public abstract void searchArea();

    public abstract void camp();

    public abstract void wander();

}