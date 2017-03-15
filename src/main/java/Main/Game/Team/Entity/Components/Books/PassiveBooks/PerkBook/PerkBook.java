package Main.Game.Team.Entity.Components.Books.PassiveBooks.PerkBook;


import Main.Game.Team.Entity.Components.Books.Book;
import Main.Game.Team.Entity.Components.Books.PassiveBooks.PerkBook.Perks.DoubleHit;
import Main.Game.Team.Entity.Entity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class PerkBook extends Book<Perk> {

    private static ArrayList<Perk> perkBook;

    public PerkBook() {
        perkBook = new ArrayList<>();
        perkBook.add(new DoubleHit());
    }
    public void use(Entity actor, ArrayList<HashMap<Entity, Integer>> actions) {
        for(Perk perk : perkBook) {
            perk.use(actor, actions);
        }
    }

    @Override
    public void add(Perk perk) {
        perkBook.add(perk);
    }


    @Override
    public void remove(Perk perk) {
        if(perkBook.contains(perk)) {
            perkBook.remove(perk);
        }
    }
    @Override
    public boolean include(Perk perk) {
        return perkBook.contains(perk);
    }

    @Override
    public boolean contains(String string) { //ToDo simplify this and getPerk/include
        Perk perk = this.get(string);
        if(perk != null) {
            return this.include(perk);
        }
        return false;
    }

    @Override
    public Perk get(String name) {
        for(Perk perk: perkBook) {
            if (perk.toString().equals(name)) {
                return perk;
            }
        }
        return null;
    }

    @Override
    public Perk getRandom() {
        Random intRandom = new Random();
        return perkBook.get(intRandom.nextInt(perkBook.size()));
    }

    @Override
    public void printBook() {
        System.out.println(perkBook.toString());
    }

    @Override
    public String toString() {
        String string = "";
        for(Perk perk : perkBook) {
            string += perk.toString() + ", ";
        }
        return string.substring(0, string.length()-2);
    }
}
