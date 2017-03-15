package Main.Game.Team.Entity.Components.Books.PassiveBooks.TraitBook;


import Main.Game.Team.Entity.Components.Books.Book;
import Main.Game.Team.Entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class TraitBook extends Book<Trait> {

    private static ArrayList<Trait> traitRegister;
    private static ArrayList<Trait> traitBook;

    public TraitBook() {
        traitBook = new ArrayList<Trait>();
    }
    public void use(Entity actor, ArrayList<HashMap<Entity, Integer>> actions) {
        for(Trait trait : traitBook) {

        }
    }

    @Override
    public void add(Trait trait) {
        traitBook.add(trait);
    }

    @Override
    public void remove(Trait trait) {
        if(traitBook.contains(trait)) {
            traitBook.remove(trait);
        }
    }
    @Override
    public boolean include(Trait trait) {
        return traitBook.contains(trait);
    }

    @Override
    public boolean contains(String string) { //ToDo simplify this and getTrait/include
        Trait trait = this.get(string);
        if(trait != null) {
            return this.include(trait);
        }
        return false;
    }

    @Override
    public Trait get(String name) {
        for(Trait trait: traitBook) {
            if (trait.toString().equals(name)) {
                return trait;
            }
        }
        return null;
    }

    @Override
    public Trait getRandom() {
        Random intRandom = new Random();
        return traitBook.get(intRandom.nextInt(traitBook.size()));
    }

    @Override
    public void printBook() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String string = "  ";
        for(Trait trait : traitBook) {
            string += trait.toString() + ", ";
        }
        return string.substring(0, string.length()-2);
    }
}
