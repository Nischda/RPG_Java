package Entities;


import Entities.Items.Inventory;

import java.util.ArrayList;

public abstract class Entity{

//add contrustor to do shit from here for player & entity?

    public abstract int getHp();
    public abstract void setHp(int hp);
    public abstract int getMp();
    public abstract void setMp(int mp);

    public abstract double getStrengthMod();
    public abstract void setStrengthMod(double strengthMod);
    public abstract double getEnduranceMod();
    public abstract void setEnduranceMod(double enduranceMod);
    public abstract double getKnowledgeMod();
    public abstract void setKnowledgeMod(double knowledgeMod);
    public abstract double getPerceptionMod();
    public abstract void setPerceptionMod(double perceptionMod);
    public abstract double getMentalityMod();
    public abstract void setMentalityMod(double mentalityMod);
    public abstract double getHardeningMod();
    public abstract void setHardeningMod(double hardeningMod);
    public abstract double getImprovisationMod();
    public abstract void setImprovisationMod(double improvisationMod);

    public abstract int getStrength();
    public abstract int getEndurance();
    public abstract int getKnowledge();
    public abstract int getPerception();
    public abstract int getMentality();
    public abstract int getHardening();
    public abstract int getImprovisation();

    public abstract void setBaseStrength(int baseStrength);
    public abstract void setBaseEndurance(int baseEndurance);
    public abstract void setBaseKnowledge(int baseKnowledge);
    public abstract void setBasePerception(int basePerception);
    public abstract void setBaseMentality (int baseMentality);
    public abstract void setBaseHardening(int baseHardening);



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

    public abstract void attack(ArrayList<Entity> players, ArrayList<Entity> enemies);
    public abstract void cast(ArrayList<Entity> players, ArrayList<Entity> enemies);
    public abstract void item(ArrayList<Entity> players, ArrayList<Entity> enemies);
    public abstract void escape(ArrayList<Entity> players, ArrayList<Entity> enemies);
    public abstract void receiveDamage(int damage);
    public abstract void checkLeathal();

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
