package Main.Game.Entity.Entities.Books.AbilityBooks.SpellBook;


import Main.Game.Entity.Entities.Books.AbilityBooks.Ability;
import Main.Game.Entity.Entities.Books.AbilityBooks.SpellBook.Spells.Spark;
import Main.Game.Entity.Entities.Books.Book;

import java.util.ArrayList;
import java.util.Random;

public class SpellBook extends Book<Ability> {

    private static ArrayList<Ability> spellBook;

    public SpellBook() {
        spellBook = new ArrayList<>();
        spellBook.add(new Spark());
    }

    @Override
    public void add(Ability ability) {
        spellBook.add(ability);
    }
    @Override
    public void remove(Ability ability) {
        if(spellBook.contains(ability)) {
            spellBook.remove(ability);
        }
    }
    @Override
    public boolean include(Ability ability) {
        return spellBook.contains(ability);
    }

    @Override
    public boolean contains(String string) { //ToDo simplify this and getAbility/include
        Ability ability = this.get(string);
        if(ability != null) {
            return this.include(ability);
        }
        return false;
    }

    @Override
    public  Ability get(String name) {
        for(Ability ability: spellBook) {
            if (ability.toString().equals(name)) {
                return ability;
            }
        }
        return null;
    }

    @Override
    public Ability getRandom() {
        Random intRandom = new Random();
        return spellBook.get(intRandom.nextInt(spellBook.size()));
    }

    @Override
    public void printBook() {
        System.out.println(spellBook.toString());
    }

    @Override
    public String toString() {
        String string = "";
        for(Ability ability : spellBook) {
            string += ability.toString() + ", ";
        }
        return string.substring(0, string.length()-2);
    }
}
