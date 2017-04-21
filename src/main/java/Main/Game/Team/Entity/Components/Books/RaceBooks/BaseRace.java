package Main.Game.Team.Entity.Components.Books.RaceBooks;


import java.util.ArrayList;
import java.util.Arrays;

public class BaseRace extends Race {

    private String name;
    private String article;
    private ArrayList<Integer> attributeList;
    private String description;

    public BaseRace(String name, String article, int strength, int endurance, int knowledge, int perception, int mentality, int hardening, int improvisation, String description) {
        attributeList = new ArrayList<>(Arrays.asList(strength, endurance, knowledge, perception, mentality, hardening, improvisation));
        this.name = name;
        this.article = article;
        this.description = description;
    }

    @Override
    public ArrayList<Integer> getStats() {
        return attributeList;
    }

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public String toString() {
        return name;
    }
}
