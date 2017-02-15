package Main.Game.Entity.Entities.Book.Books;


import Main.Game.Entity.Entities.Book.Book;
import Main.Game.Entity.Entities.Book.Books.Spells.Spark;
import java.util.HashMap;

public class Skillbook extends Book {

    private static HashMap<String, Ability> skillBook = new HashMap<>();

    public Skillbook() {
        this.skillBook = new HashMap<>();
        this.skillBook.put("Spark", new Spark());
    }

    @Override
    public void add(String name, Ability ability) {
        this.skillBook.put(name, ability);
    }
    @Override
    public void remove(String name) {
        if(skillBook.containsKey(name)) {
            skillBook.remove(name);
        }
    }
    @Override
    public boolean include(String name) {
        return skillBook.containsKey(name);
    }
    @Override
    public  Ability getAbility(String name) {
        if (skillBook.containsKey(name)) {
            return (Ability) skillBook.get(name);
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
        for(String name : skillBook.keySet()) {
            string += ", " + name;
        }
        return string;
    }
}
