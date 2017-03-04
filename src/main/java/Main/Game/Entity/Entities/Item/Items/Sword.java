package Main.Game.Entity.Entities.Item.Items;


import Main.Game.Entity.Entities.Item.Equipable;
import Main.Game.Entity.Entities.Item.Item;

import java.util.ArrayList;

public class Sword extends Item implements Equipable {

    private String type = "sword";
    private String name;
    private int damage;
    private int speed;
    private int price;
    private int weight;
    private ArrayList<String> slots;

    public Sword(String name, int damage, int speed, int price, int weight, ArrayList<String> slots) {
        this.name = name;
        this.damage = damage;
        this.speed = speed;
        this.price = price;
        this.weight = weight;
        this.slots = slots;
    }

    public void printInfo() {
        System.out.println("SwordInfo to be added");
    }

    @Override
    public boolean isEquipableOn(String slot) {
        if(this.slots.contains(slot)) return true;
        return false;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }
    @Override
    public String toString() {
        return this.name + "\n";
    }
}
