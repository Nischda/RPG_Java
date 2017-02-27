package Main.Game.Entity.Entities.Item.Items;


import Main.Game.Entity.Entities.Item.Consumable;
import Main.Game.Entity.Entities.Item.Equipable;
import Main.Game.Entity.Entities.Item.Item;
import Main.Game.Entity.Entities.Player;
import Main.Game.Entity.Entity;

import java.util.ArrayList;

public class Fruit extends Item implements Equipable, Consumable {

    private String type = "Fruit";
    private String name;
    private int damage;
    private int speed;
    private int price;
    private int weight;
    private ArrayList<String> slots;

    public Fruit(String name, int damage, int speed, int price, int weight, ArrayList<String> slots) {
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

    public String toString() {
        return this.name;
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
    public void use(Entity entity) {
        entity.receiveDamage(this.damage, this.name);
    }

    @Override
    public void effect() {
        //nutritious
    }
}
