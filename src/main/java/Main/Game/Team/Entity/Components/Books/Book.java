package Main.Game.Team.Entity.Components.Books;


public abstract class Book<Value> {

    public abstract void add(Value value);
    public abstract void remove(Value value);

    public abstract void printBook();
    public abstract boolean include(Value perk);
    public abstract boolean contains(String string);
    public abstract Value get(String string);
    public abstract Value getRandom();
}
