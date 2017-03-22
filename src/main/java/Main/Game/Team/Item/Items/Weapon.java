package Main.Game.Team.Item.Items;


import Main.Game.Team.Entity.Components.Books.AttributeBooks.AttributeBook;
import Main.Game.Team.Item.Equipable;
import Main.Game.Team.Item.Item;
import Main.Game.Team.Entity.Entity;

import java.util.ArrayList;
import java.util.Scanner;

public class Weapon extends Item implements Equipable {

    private Scanner in = new Scanner(System.in);

    private String type = "weapon";
    private String prefix;
    private String name;
    private Double matMod;
    private Double statMod;
    private ArrayList<String> slots;

    private AttributeBook attributeBook;
    private String description;

    public Weapon(Double statMod, Double matMod, String name, ArrayList<String> slots, AttributeBook attributeBook, String description) {
        this.name = name;
        this.statMod = statMod;
        this.matMod = matMod;
        this.slots = slots;
        this.attributeBook = attributeBook;
        this.description = description;
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

    public void printInfo() {
        System.out.println("SwordInfo to be added");
    }




    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public void equip(Entity target) {
        target.equip(this);
    }
}
