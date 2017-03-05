package Main.Game.Entity.Entities.Book.Books;


import Main.Game.Entity.Entities.Book.ActiveBook;
import Main.Game.Entity.Entities.Book.Books.Spells.Spark;

import java.util.ArrayList;
import java.util.Random;

public class Spellbook extends ActiveBook {

    private static ArrayList<Ability> spellbook;

    public Spellbook() {
        spellbook = new ArrayList<>();
        spellbook.add(new Spark());
    }

    @Override
    public void add(Ability ability) {
        spellbook.add(ability);
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
    public boolean contains(String string) { //ToDo simplify this and getAbility/include
        Ability ability = this.getAbility(string);
        if(ability != null) {
            return this.include(ability);
        }
        return false;
    }

    @Override
    public  Ability getAbility(String name) {
        for(Ability ability: spellbook) {
            if (ability.toString().equals(name)) {
                return ability;
            }
        }
        return null;
    }

    @Override
    public Ability getRandomAbility() {
        Random intRandom = new Random();
        return spellbook.get(intRandom.nextInt(spellbook.size()));
    }

    @Override
    public void printBook() {
        System.out.println(spellbook.toString());
    }

    @Override
    public String toString() {
        String string = "";
        for(Ability ability : spellbook) {
            string += ability.toString() + ", ";
        }
        return string.substring(0, string.length()-2);
    }
}
