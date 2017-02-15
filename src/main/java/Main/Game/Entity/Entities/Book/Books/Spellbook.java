package Main.Game.Entity.Entities.Book.Books;


import Main.Game.Entity.Entities.Book.Book;
import Main.Game.Entity.Entities.Book.Books.Spells.Spark;

import java.util.HashMap;

public class Spellbook extends Book {

    private static HashMap<String, Ability> spellBook = new HashMap<>();

    public Spellbook() {
        this.spellBook = new HashMap<>();
        this.spellBook.put("Spark", new Spark());
    }

    @Override
    public void add(String name, Ability ability) {
        this.spellBook.put(name, ability);
    }
    @Override
    public void remove(String name) {
        if(spellBook.containsKey(name)) {
            spellBook.remove(name);
        }
    }
    @Override
    public boolean include(String name) {
        return spellBook.containsKey(name);
    }
    @Override
    public  Ability getAbility(String name) {
        if (spellBook.containsKey(name)) {
            return (Ability) spellBook.get(name);
        }
        return null;
    }

    @Override
    public void printBook() {
        System.out.println(this.spellBook.toString());
    }

    @Override
    public String toString() {
        String string = "";
        for(String name : spellBook.keySet()) {
            string += ", " + name;
        }
        return string;
    }
}
