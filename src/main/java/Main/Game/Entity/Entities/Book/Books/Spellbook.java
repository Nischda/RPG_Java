package Main.Game.Entity.Entities.Book.Books;


import Main.Game.Entity.Entities.Book.Book;
import Main.Game.Entity.Entities.Book.Books.Spells.Spark;

import java.util.ArrayList;
import java.util.HashMap;

public class Spellbook extends Book {

    private static ArrayList<Ability> spellbook;

    public Spellbook() {
        this.spellbook = new ArrayList<>();
        this.spellbook.add(new Spark());
    }

    @Override
    public void add(Ability ability) {
        this.spellbook.add(ability);
    }
    @Override
    public void remove(Ability ability) {
        if(spellbook.contains(ability)) {
            spellbook.remove(ability);
        }
    }
    @Override
    public boolean include(Ability ability) {
        return spellbook.contains(ability);
    }

    @Override
    public boolean contains(String string) {
        return this.include(this.getAbility(string));
    }

    @Override
    public  Ability getAbility(String name) {
        for(Ability ability: spellbook)
            if (ability.toString().equals(name)) {
                return ability;
            }
        return null;
    }

    @Override
    public void printBook() {
        System.out.println(this.spellbook.toString());
    }

    @Override
    public String toString() {
        String string = "";
        for(Ability ability : spellbook) {
            string += ", " + ability.toString();
        }
        return string;
    }
}
