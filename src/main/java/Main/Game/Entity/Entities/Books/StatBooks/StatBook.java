package Main.Game.Entity.Entities.Books.StatBooks;


import Main.Game.Entity.Entities.Books.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class StatBook extends Book<Stat> { //Todo not yet adjusted in any kind of way

    private HashMap<String, Stat> statMap;

    public StatBook(ArrayList<Integer> stats, ArrayList<Double> mods) {
        statMap = new HashMap<>();
        System.out.println(stats.get(0) + "  " + mods.get(0));
        statMap.put("strength", new baseStat("strength", stats.get(0), mods.get(0)));
        statMap.put("endurance", new baseStat("endurance", stats.get(1), mods.get(1)));
        statMap.put("knowledge", new baseStat("knowledge", stats.get(2), mods.get(2)));
        statMap.put("perception", new baseStat("perception", stats.get(3), mods.get(3)));
        statMap.put("mentality", new baseStat("mentality", stats.get(4), mods.get(4)));
        statMap.put("hardening", new baseStat("hardening", stats.get(5), mods.get(5)));
        statMap.put("improvisation", new baseStat("improvisation", stats.get(6), mods.get(6)));
    }

    @Override
    public void add(Stat stat) {
        statMap.put(stat.toString(), stat);
    }

    @Override
    public void remove(Stat stat) {
        if(statMap.containsKey(stat.toString())) {
            statMap.remove(stat.toString());
        }
    }

    @Override
    public boolean include(Stat stat) {
        return statMap.containsKey(stat.toString());
    }

    @Override
    public boolean contains(String name) { //ToDo simplify this and getStat/include
            return statMap.containsKey(name);
    }

    @Override
    public Stat get(String name) {
        if (this.contains(name)) {
            System.out.println("works");
            return statMap.get(name);
        }
        return null;
    }


    @Override
    public Stat getRandom() {
        Random intRandom = new Random();
        return statMap.get(intRandom.nextInt(statMap.size()));
    }

    @Override
    public void printBook() {
        System.out.println(statMap.toString());
    }

    @Override
    public String toString() {
        String string = "";
        for(Stat stat : statMap.values()) {
            string += stat.toString() + ": " + stat.getString() + ",";
        }
        return string.substring(0, string.length()-2);
    }
}
