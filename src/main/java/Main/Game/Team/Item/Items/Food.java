package Main.Game.Team.Item.Items;


import Main.Game.Team.Entity.Components.Books.AttributeBooks.AttributeBook;
import Main.Game.Team.Team;
import Main.Game.Team.Item.Consumable;
import Main.Game.Team.Item.Equipable;
import Main.Game.Team.Item.Item;
import Main.Game.Team.Entity.Entity;

import java.util.ArrayList;
import java.util.Scanner;

public class Food extends Item implements Equipable, Consumable {

    private Scanner in = new Scanner(System.in);

    private String type = "food";
    private String prefix;
    private String name;
    private Double matMod;
    private Double statMod;
    private ArrayList<String> slots;

    private AttributeBook attributeBook;
    private String description;

    public Food(Double statMod, Double matMod, String name, ArrayList<String> slots, AttributeBook attributeBook, String description) {
        this.name = name;
        this.statMod = statMod;
        this.matMod = matMod;
        this.slots = slots;
        this.attributeBook = attributeBook;
        this.description = description;
    }

    public void printInfo() {
        System.out.println("SwordInfo to be added");
    }


    @Override
    public int getStatValue(String name) {
        if (attributeBook.contains(name)) {
            return attributeBook.getValue(name);
        }
        return 0;
    }

    @Override
    public ArrayList<String> getSlots() {
        return this.slots;
    }

    @Override
    public void use(Team team1, Team team2) {
        Team targets;
        System.out.println("Choose your target team (1: " + team1.getName() + "/2: " + team2.getName() + ")");//Todo add rangecheck
        int targetTeam = Integer.parseInt(in.nextLine());
        if(targetTeam == 1) {
            targets = team1;
        }
        else {
            targets = team2;
        }
        System.out.println("Choose your target (up to " + targets.size() + ")");//Todo add rangecheck
        System.out.println(targets.toString());
        Entity target = targets.get(Integer.parseInt(in.nextLine())-1);
        target.receivePhysicalDamage(attributeBook.getValue("damage"), this.name);
    }

    @Override
    public void use(Entity target) {
        target.receivePhysicalDamage(attributeBook.getValue("damage"), this.name);
    }

    @Override
    public void equip(Entity target) {
        target.equip(this);
    }

    @Override
    public void effect() {
        //nutritious
    }
    @Override
    public String toString() {
        return this.name;
    }
}
