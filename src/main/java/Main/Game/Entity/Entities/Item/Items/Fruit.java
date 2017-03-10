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
    private int speed;
    private int price;
    private int weight;
    private String slot;

    private int damage;
    private int stamina;
    private int spellDamage;
    private int charisma;
    private int effectChance;
    private int hpReg;
    private int mpReg;
    private int armor;
    private int resistance;
    private int maxHp;
    private int maxMp;

    public Fruit(String name, int speed, int price, int weight, String slot, int damage, int stamina, int spellDamage, int charisma, int effectChance, int hpReg, int mpReg, int armor, int resistance, int maxHp, int maxMp) {
        this.name = name;
        this.damage = damage;
        this.speed = speed;
        this.price = price;
        this.weight = weight;
        this.slot = slot;

        this.damage = damage;
        this.stamina = stamina;
        this.spellDamage = spellDamage;
        this.charisma = charisma;
        this.effectChance = effectChance;
        this.hpReg = hpReg;
        this.mpReg = mpReg;
        this.armor = armor;
        this.resistance = resistance;
        this.armor = armor;
        this.resistance = resistance;
        this.maxHp = maxHp;
        this.maxMp = maxMp;
    }

    public void printInfo() {
        System.out.println("SwordInfo to be added");
    }


    @Override
    public int getDamage() {
        return damage;
    }
    @Override
    public int getStamina() {
        return stamina;
    }
    @Override
    public int getSpellDamage() {
        return spellDamage;
    }
    @Override
    public int getCharisma() {
        return charisma;
    }
    @Override
    public int getEffectChance() {
        return effectChance;
    }
    @Override
    public int getHpReg() {
        return hpReg;
    }
    @Override
    public int getMpReg() {
        return mpReg;
    }
    @Override
    public int getArmor() {
        return armor;
    }
    @Override
    public int getResistance() {
        return resistance;
    }
    @Override
    public int getMaxHp() {
        return maxHp;
    }
    @Override
    public int getMaxMp() {
        return maxMp;
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
    public String getSlot() {
        return this.slot;
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
    public void use(Entity target) {
        target.receivePhysicalDamage(this.damage, this.name);
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
