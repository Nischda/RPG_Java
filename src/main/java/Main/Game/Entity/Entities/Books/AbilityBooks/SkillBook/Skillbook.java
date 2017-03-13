package Main.Game.Entity.Entities.Books.AbilityBooks.SkillBook;


import Main.Game.Entity.Entities.Books.AbilityBooks.Ability;
import Main.Game.Entity.Entities.Books.AbilityBooks.SkillBook.Skills.Slash;
import Main.Game.Entity.Entities.Books.AbilityBooks.SkillBook.Skills.Whirlwind;
import Main.Game.Entity.Entities.Books.Book;

import java.util.ArrayList;
import java.util.Random;

public class Skillbook extends Book<Ability> {

    private static ArrayList<Ability> skillBook;

    public Skillbook() {
        skillBook = new ArrayList<>();
        skillBook.add(new Slash());
        skillBook.add(new Whirlwind());
    }

    @Override
    public void add(Ability ability) {
        skillBook.add(ability);
    }
    @Override
    public void remove(Ability ability) {
        if(skillBook.contains(ability)) {
            skillBook.remove(ability);
        }
    }
    @Override
    public boolean include(Ability ability) {
        return skillBook.contains(ability);
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
        for(Ability ability: skillBook) {
            if (ability.toString().equals(name)) {
                return ability;
            }
        }
        return null;
    }

    @Override
    public Ability getRandom() {
        Random intRandom = new Random();
        return skillBook.get(intRandom.nextInt(skillBook.size()));
    }

    @Override
    public void printBook() {
        System.out.println(skillBook.toString());
    }

    @Override
    public String toString() {
        String string = "";
        for(Ability ability : skillBook) {
            string += ability.toString() + ", ";
        }
        return string.substring(0, string.length()-2);
    }
}
