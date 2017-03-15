package Main.Game.Team.Item.Items;


import Main.Game.Team.Item.Equipable;
import Main.Game.Team.Item.Item;
import Main.Game.Team.Entity.Entity;

import java.util.Scanner;

public class Sword extends Item implements Equipable {

    private Scanner in = new Scanner(System.in);

    private String type = "sword";
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

    public Sword(String name, int speed, int price, int weight, String slot, int damage, int stamina, int spellDamage, int charisma, int effectChance, int hpReg, int mpReg, int armor, int resistance, int maxHp, int maxMp) {
        this.name = name;
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

    public void printInfo() {
        System.out.println("SwordInfo to be added");
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
    public String getSlot() {
        return this.slot;
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
