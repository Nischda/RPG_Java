package Main.Game.Entity.Entities.Book;


import Main.Game.Entity.Entities.Book.Books.Ability;

public abstract class Book {

    public abstract void add(Ability ability);
    public abstract void remove(Ability ability);

    public abstract void printBook();
    public abstract boolean include(Ability ability);
    public abstract boolean contains(String string);
    public abstract Ability getAbility(String name);
public abstract Ability getRandomAbility();
}
