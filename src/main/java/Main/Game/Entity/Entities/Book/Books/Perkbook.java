package Main.Game.Entity.Entities.Book.Books;


import Main.Game.Entity.Entities.Book.Books.Perks.DoubleHit;
import Main.Game.Entity.Entities.Book.PassiveBook;
import Main.Game.Entity.Entity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Perkbook extends PassiveBook {

    private static ArrayList<Perk> perkbook;

    public Perkbook() {
        perkbook = new ArrayList<>();
        perkbook.add(new DoubleHit());
    }
    public void use(Entity actor, ArrayList<HashMap<Entity, Integer>> actions) {
        for(Perk perk : perkbook) {
            perk.use(actor, actions);
        }
    }

    @Override
    public void add(Perk perk) {
        perkbook.add(perk);
    }

    @Override
    public void remove(Perk perk) {
        if(perkbook.contains(perk)) {
            perkbook.remove(perk);
        }
    }
    @Override
    public boolean include(Perk perk) {
        return perkbook.contains(perk);
    }

    @Override
    public boolean contains(String string) { //ToDo simplify this and getPerk/include
        Perk perk = this.getPerk(string);
        if(perk != null) {
            return this.include(perk);
        }
        return false;
    }

    @Override
    public  Perk getPerk(String name) {
        for(Perk perk: perkbook) {
            if (perk.toString().equals(name)) {
                return perk;
            }
        }
        return null;
    }

    @Override
    public Perk getRandomPerk() {
        Random intRandom = new Random();
        return perkbook.get(intRandom.nextInt(perkbook.size()));
    }

    @Override
    public void printBook() {
        System.out.println(perkbook.toString());
    }

    @Override
    public String toString() {
        String string = "";
        for(Perk perk : perkbook) {
            string += perk.toString() + ", ";
        }
        return string.substring(0, string.length()-2);
    }
}
