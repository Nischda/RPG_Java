package Main.Game.Entity.Entities.Books.AbilityBooks;


import Main.Game.Entity.Entities.Books.AbilityBooks.Skills.Slash;
import Main.Game.Entity.Entities.Books.AbilityBooks.Skills.Whirlwind;
import Main.Game.Entity.Entities.Books.Book;

import java.util.ArrayList;
import java.util.Random;

public class Skillbook extends Book<Ability> {

    private static ArrayList<Ability> skillbook;

    public Skillbook() {
        skillbook = new ArrayList<>();
        skillbook.add(new Slash());
        skillbook.add(new Whirlwind());
    }

    @Override
    public void add(Ability ability) {
        skillbook.add(ability);
    }
    @Override
    public void remove(Ability ability) {
        if(skillbook.contains(ability)) {
            skillbook.remove(ability);
        }
    }
    @Override
    public boolean include(Ability ability) {
        return skillbook.contains(ability);
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
        for(Ability ability: skillbook) {
            if (ability.toString().equals(name)) {
                return ability;
            }
        }
        return null;
    }
    @Override
    public Ability getRandom() {
        Random intRandom = new Random();
        return skillbook.get(intRandom.nextInt(skillbook.size()));
    }

    @Override
    public void printBook() {
        System.out.println(skillbook.toString());
    }

    @Override
    public String toString() {
        String string = "";
        for(Ability ability : skillbook) {
            string += ability.toString() + ", ";
        }
        return string.substring(0, string.length()-2);
    }
}
