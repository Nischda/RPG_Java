package Entities;


import Entities.Items.Inventory;

import java.util.ArrayList;

public abstract class Entity{

//add contrustor to do shit from here for player & entity?


    public abstract void addToHp(double value);
    public abstract void addToMp(double value);
    public abstract void addToXp(double value);

    public abstract void addToStrengthMod(double value);
    public abstract void addToEnduranceMod(double value);
    public abstract void addToKnowledgeMod(double value);
    public abstract void addToPerceptionMod(double value);
    public abstract void addToMentalityMod(double value);
    public abstract void addToHardeningMod(double value);
    public abstract void addToImprovisationMod(double value);

    public abstract int getStrength();
    public abstract int getEndurance();
    public abstract int getKnowledge();
    public abstract int getPerception();
    public abstract int getMentality();
    public abstract int getHardening();
    public abstract int getImprovisation();

    public abstract void attack(ArrayList<Entity> players, ArrayList<Entity> enemies);
    public abstract void cast(ArrayList<Entity> players, ArrayList<Entity> enemies);
    public abstract void item(ArrayList<Entity> players, ArrayList<Entity> enemies);
    public abstract void escape(ArrayList<Entity> players, ArrayList<Entity> enemies);
    public abstract void receiveDamage(int damage);
    public abstract void checkLeathal();

    public abstract void setBaseAttributes(int baseStrength, int baseEndurance, int baseKnowledge, int basePerception, int baseMentality, int baseHardening, int baseImprovisation);


    protected int calculateMaxHp(double strengthMod, int baseStrength) {
        return (int)(strengthMod * baseStrength * 10);
    }
    protected int calculateMaxMp(double knowledgeMod, int baseKnowledge) {
        return (int)(knowledgeMod * baseKnowledge * 10);
    }
    protected int calculateStrength(double strengthMod, int baseStrength) {
        return (int)(strengthMod * baseStrength);
    }
    protected int calculateEndurance(double enduranceMod, int baseEndurance ) {
        return (int)(enduranceMod * baseEndurance);
    }
    protected int calculateKnowledge(double knowledgeMod, int baseKnowledge) {
        return (int)(knowledgeMod * baseKnowledge);
    }
    protected int calculatePerception(double perceptionMod, int basePerception) {
        return (int)(perceptionMod * basePerception);
    }
    protected int calculateMentality(double mentalityMod, int baseMentality) {
        return (int)(mentalityMod * baseMentality);
    }
    protected int calculateHardening(double hardeningMod, int baseHardening) {
        return (int)(hardeningMod * baseHardening);
    }
    protected int calculateBaseImprovisation(double improvisationMod, int baseImprovisation) {
        return (int)(improvisationMod * baseImprovisation);
    }

    protected int calculateBaseDamage(int baseStrength) {
        return baseStrength;
    } // *weaponmodifier * other boni
    protected int calculateBaseStamina(int baseEndurance) {
        return baseEndurance * 2;
    } // *weaponmodifier * other boni
    protected int calculateBaseSpellDamage(int baseKnowledge) {
        return baseKnowledge *2;
    } // *weaponModifier * other boni
    protected int calculateBaseCharisma(int basePerception) {
        return basePerception *2;
    } // *status *armorModifier * other boni
    protected int calculateBaseEffectChance(int basePerception) {
        return basePerception;
    } //  other boni
    protected int calculateBaseHpReg(int baseMentality) {
        return baseMentality;
    } // *status
    protected int calculateBaseMpReg(int baseMentality) {
        return baseMentality;
    } // *status
    protected int calculateBaseArmor(int baseHardening) {
        return baseHardening *10;
    } // *armorModifier * other boni
    protected int calculateBaseResistance(int baseHardening) {
        return baseHardening *5;
    } // *armorModifier * other boni

    public void printStatus(int xp, int xpToNextLevel, int hp, int maxHp, int mp, int maxMp) {
        System.out.println("XP: " + xp + "/" + xpToNextLevel);
        System.out.println("HP: " + hp + "/" + maxHp);
        System.out.println("MP: " + mp + "/" + maxMp);
        System.out.println("Status effects: ");
    }

    public void printAttributes(int baseStrength, int baseStamina, int baseKnowledge, int basePerception, int baseMentality, int baseHardening) {
        System.out.println("str: "+ baseStrength + " end: "+ baseStamina+ " kno: "+ baseKnowledge + " per: "+ basePerception + " men: "+ baseMentality + " har: "+ baseHardening);
    }

    public void printInventory(Inventory inventory) {
        System.out.println(inventory.toString());
    }

    public abstract String toString();


}
