package Main.Game.Entity.Entities.Book;


import Main.Game.Entity.Entities.Book.Books.Ability;

public abstract class Book {

    public abstract void add(String name, Ability ability);
    public abstract void remove(String name);

    public abstract void printBook();
    public abstract boolean include(String name);
    public abstract Ability getAbility(String name);

}
