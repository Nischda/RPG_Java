package Main.Game.Entity.Entities.Books.StatBooks;


import Main.Game.Entity.Entities.Books.Book;
import Main.Game.Entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class StatBook extends Book<Stat> { //Todo not yet adjusted in any kind of way

    private static ArrayList<Stat> statBook;

    public StatBook() {
        statBook = new ArrayList<>();
    }
    public void use(Entity actor, ArrayList<HashMap<Entity, Integer>> actions) {
        for(Stat stat : statBook) {
            //stat.use(actor, actions);
        }
    }

    @Override
    public void add(Stat stat) {
        statBook.add(stat);
    }

    @Override
    public void remove(Stat stat) {
        if(statBook.contains(stat)) {
            statBook.remove(stat);
        }
    }
    @Override
    public boolean include(Stat stat) {
        return statBook.contains(stat);
    }

    @Override
    public boolean contains(String string) { //ToDo simplify this and getStat/include
        Stat stat = this.get(string);
        if(stat != null) {
            return this.include(stat);
        }
        return false;
    }

    @Override
    public Stat get(String name) {
        for(Stat stat: statBook) {
            if (stat.toString().equals(name)) {
                return stat;
            }
        }
        return null;
    }

    @Override
    public Stat getRandom() {
        Random intRandom = new Random();
        return statBook.get(intRandom.nextInt(statBook.size()));
    }

    @Override
    public void printBook() {
        System.out.println(statBook.toString());
    }

    @Override
    public String toString() {
        String string = "";
        for(Stat stat : statBook) {
            string += stat.toString() + ", ";
        }
        return string.substring(0, string.length()-2);
    }
}
