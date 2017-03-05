package Main.Game.Entity.Entities.Item;


import Main.Game.Entity.Entities.Entities;

public abstract class Item {
    public abstract void printInfo();
    public abstract String toString();
    public abstract void use(Entities entities1, Entities entities2);
}
