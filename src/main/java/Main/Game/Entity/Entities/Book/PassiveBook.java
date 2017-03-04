package Main.Game.Entity.Entities.Book;

import Main.Game.Entity.Entities.Book.Books.Perk;

public abstract class PassiveBook {

    public abstract void add(Perk perk);
    public abstract void remove(Perk perk);

    public abstract void printBook();
    public abstract boolean include(Perk perk);
    public abstract boolean contains(String string);
    public abstract Perk getPerk(String name);
public abstract Perk getRandomPerk();
}
