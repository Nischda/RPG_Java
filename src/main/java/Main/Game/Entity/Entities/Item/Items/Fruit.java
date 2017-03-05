package Main.Game.Entity.Entities.Item.Items;


import Main.Game.Entity.Entities.Entities;
import Main.Game.Entity.Entities.Item.Consumable;
import Main.Game.Entity.Entities.Item.Equipable;
import Main.Game.Entity.Entities.Item.Item;
import Main.Game.Entity.Entity;

import java.util.ArrayList;
import java.util.Scanner;

public class Fruit extends Item implements Equipable, Consumable {

    private Scanner in = new Scanner(System.in);

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
    public void use(Entities entities1, Entities entities2) {
        Entities targets;
        System.out.println("Choose your target team (1: " + entities1.getName() + "/2: " + entities2.getName() + ")");//Todo add rangecheck
        int targetTeam = Integer.parseInt(in.nextLine());
        if(targetTeam == 1) {
            targets = entities1;
        }
        else {
            targets = entities2;
        }
        System.out.println("Choose your target (up to " + targets.size() + ")");//Todo add rangecheck
        System.out.println(targets.toString());
        Entity target = targets.get(Integer.parseInt(in.nextLine())-1);
        target.receivePhysicalDamage(this.damage, this.name);
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
