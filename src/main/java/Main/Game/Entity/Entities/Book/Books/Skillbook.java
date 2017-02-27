package Main.Game.Entity.Entities.Book.Books;


import Main.Game.Entity.Entities.Book.Book;
import Main.Game.Entity.Entities.Book.Books.Skills.Slash;
import Main.Game.Entity.Entities.Book.Books.Skills.Whirlwind;
import Main.Game.Entity.Entities.Book.Books.Spells.Spark;

import java.util.ArrayList;
import java.util.HashMap;

public class Skillbook extends Book {

    private static ArrayList<Ability> skillBook;

    public Skillbook() {
        this.skillBook = new ArrayList<>();
        this.skillBook.add(new Slash());
        this.skillBook.add(new Whirlwind());
    }

    @Override
    public void add(Ability ability) {
        this.skillBook.add(ability);
    }
    @Override
    public void remove(Ability ability) {
        if(skillBook.contains(ability)) {
            skillBook.remove(ability);
        }
    }
    @Override
    public boolean include(Ability ability) {
        return this.skillBook.contains(ability);
    }

    @Override
    public boolean contains(String string) {
        return this.include(this.getAbility(string));
    }

    @Override
    public  Ability getAbility(String name) {
        for(Ability ability: skillBook)
        if (ability.toString().equals(name)) {
            return ability;
        }
        return null;
    }

    @Override
    public void printBook() {
        System.out.println(this.skillBook.toString());
    }

    @Override
    public String toString() {
        String string = "";
        for(Ability ability : skillBook) {
            string += ", " + ability.toString();
        }
        return string;
    }
}
