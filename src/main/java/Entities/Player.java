package Entities;

import Entities.Items.Item;
import Entities.ProfessionLists.Profession;
import Entities.RaceLists.*;
import Entities.TraitLists.CustomTraitList;

import java.util.ArrayList;

public class Player {

    private String name;
    private Profession profession;
    private Race race;
    private CustomTraitList customTraitList;

    private int xp = 0;
    private int level = 1;
    private int xpToNextLevel = 100;
    private int attributePoints = 0;

    private int maxHp;
    private int hp;
    private int maxMp;
    private int mp;

    private static ArrayList<Item> inventory = new ArrayList<>();

    private int baseStrength; //see if making double
    private int baseEndurance;
    private int baseKnowledge;
    private int basePerception;
    private int baseMentality;
    private int baseHardening;
    private int baseImprovisation;

    private double strengthMod;
    private double enduranceMod;
    private double knowledgeMod;
    private double perceptionMod;
    private double mentalityMod;
    private double hardeningMod;
    private double improvisationMod;

    private int strength; //see if making double
    private int endurance;
    private int knowledge;
    private int perception;
    private int mentality;
    private int hardening;
  //  private int improvisation;

    private int baseDamage;
    private int baseStamina;
    private int baseSpellDamage;
    private int baseCharisma;
    private int baseEffectChance;
    private int baseHpReg;
    private int baseMpReg;
    private int baseArmor;
    private int baseResistance;

    public int getBaseImprovisation() {
        return baseImprovisation;
    }

    public void setBaseImprovisation(int baseImprovisation) {
        this.baseImprovisation = baseImprovisation;
    }

    public int getBaseStrength() {
        return baseStrength;
    }

    public void setBaseStrength(int baseStrength) {
        this.baseStrength = baseStrength;
    }

    public int getBaseEndurance() {
        return baseEndurance;
    }

    public void setBaseEndurance(int baseEndurance) {
        this.baseEndurance = baseEndurance;
    }

    public int getBaseKnowledge() {
        return baseKnowledge;
    }

    public void setBaseKnowledge(int baseKnowledge) {
        this.baseKnowledge = baseKnowledge;
    }

    public int getBasePerception() {
        return basePerception;
    }

    public void setBasePerception(int basePerception) {
        this.basePerception = basePerception;
    }

    public int getBaseMentality() {
        return baseMentality;
    }

    public void setBaseMentality(int baseMentality) {
        this.baseMentality = baseMentality;
    }

    public int getBaseHardening() {
        return baseHardening;
    }

    public void setBaseHardening(int baseHardening) {
        this.baseHardening = baseHardening;
    }

    public String name() {
        return name;
    }

    public String profession() {
        return profession.toString();
    }

    public String race() {
        return race.toString();
    }

    public String traits() {
        return customTraitList.toString();
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public double getStrengthMod() {
        return strengthMod;
    }

    public void setStrengthMod(double strengthMod) {
        this.strengthMod = strengthMod;
    }

    public double getEnduranceMod() {
        return enduranceMod;
    }

    public void setEnduranceMod(double enduranceMod) {
        this.enduranceMod = enduranceMod;
    }

    public double getKnowledgeMod() {
        return knowledgeMod;
    }

    public void setKnowledgeMod(double knowledgeMod) {
        this.knowledgeMod = knowledgeMod;
    }

    public double getPerceptionMod() {
        return perceptionMod;
    }

    public void setPerceptionMod(double perceptionMod) {
        this.perceptionMod = perceptionMod;
    }

    public double getMentalityMod() {
        return mentalityMod;
    }

    public void setMentalityMod(double mentalityMod) {
        this.mentalityMod = mentalityMod;
    }

    public double getHardeningMod() {
        return hardeningMod;
    }

    public void setHardeningMod(double hardeningMod) {
        this.hardeningMod = hardeningMod;
    }

    public double getImprovisationMod() {
        return improvisationMod;
    }

    public void setImprovisationMod(double improvisationMod) {
        this.improvisationMod = improvisationMod;
    }

    public int getStrength() {
        return strength;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getKnowledge() {
        return knowledge;
    }

    public int getPerception() {
        return perception;
    }

    public int getMentality() {
        return mentality;
    }

    public int getHardening() {
        return hardening;
    }


    public Player(String name, Profession profession, Race race, CustomTraitList traitList) {
        this.name = name;
        this.profession = profession;
        this.race = race;
        this.customTraitList = traitList;

        profession.initializePerks(this);
        race.initializeAttributes(this);
        traitList.initializeAllTraits();

        calculateMaxHp();
        this.hp = maxHp;
        calculateMaxMp();
        this.mp = maxMp;

        calculateStrength();
        calculateEndurance();
        calculateKnowledge();
        calculatePerception();
        calculateMentality ();
        calculateHardening();

        calculateBaseDamage();
        calculateBaseStamina();
        calculateBaseSpellDamage();
        calculateBaseCharisma();
        calculateBaseEffectChance();
        calculateBaseHpReg();
        calculateBaseMpReg ();
        calculateBaseArmor();
        calculateBaseResistance();
    }


    private void calculateMaxHp() {
        this.maxHp = (int)Math.round(strengthMod * baseStrength * 10);
    }
    private void calculateMaxMp() {
        this.maxMp = (int)Math.round(knowledgeMod * baseKnowledge * 10);
    }

    private void calculateStrength() {
        this.strength = (int)Math.round(strengthMod * baseStrength);
    }
    private void calculateEndurance() {
        this.endurance = (int)Math.round(enduranceMod * baseEndurance);
    }
    private void calculateKnowledge() {
        this.knowledge = (int)Math.round(knowledgeMod * baseKnowledge);
    }
    private void calculatePerception() {
        this.perception = (int)Math.round(perceptionMod * basePerception);
    }
    private void calculateMentality() {
        this.mentality = (int)Math.round(mentalityMod * baseMentality);
    }
    private void calculateHardening() {
        this.hardening = (int)Math.round(hardeningMod * baseHardening);
    }

    private void calculateBaseDamage() {
        this.baseDamage = this.baseStrength;
    } // *weaponmodifier * other boni
    private void calculateBaseStamina() {
        this.baseStamina = this.baseEndurance * 2;
    } // *weaponmodifier * other boni
    private void calculateBaseSpellDamage() {
        this.baseSpellDamage = this.knowledge *2;
    } // *weaponModifier * other boni
    private void calculateBaseCharisma() {
        this.baseCharisma = this.perception *2;
    } // *status *armorModifier * other boni
    private void calculateBaseEffectChance() {
        this.baseEffectChance = this.perception;
    } //  other boni
    private void calculateBaseHpReg() {
        this.baseMpReg = this.mentality;
    } // *status
    private void calculateBaseMpReg() {
        this.baseHpReg = this.mentality;
    } // *status
    private void calculateBaseArmor() {
        this.baseArmor = this.hardening *10;
    } // *armorModifier * other boni
    private void calculateBaseResistance() {
        this.baseResistance = this.hardening *5;
    } // *armorModifier * other boni

    private void addXp(int xp) {
        this.xp += xp;
        if(this.xp > this.xpToNextLevel) {
            this.xp -= this.xpToNextLevel;
            this.xpToNextLevel *= 1.2;
            this.level += 1;
            this.attributePoints += 5;
            System.out.println("You leveled up! You are now level " + this.level + ".");
            System.out.println("You have " + this.attributePoints + "left so spend.");
        }
    }
    public void printStatus() {
        System.out.println("XP: " + this.xp + "/" + this.xpToNextLevel);
        System.out.println("HP: " + this.hp + "/" + this.maxHp);
        System.out.println("MP: " + this.mp + "/" + this.maxMp);
        System.out.println("Status effects: ");
    }
    public void printAttributes() {
        System.out.println("str: "+ this.baseStrength + " end: "+ this.baseStamina+ " kno: "+ this.baseKnowledge + " per: "+ this.basePerception + " men: "+ this.baseMentality + " har: "+ this.baseHardening);
    }

    public void printInventory() {
        inventory.toString();
    }

    public void spendAttributePoints() {
        System.out.println("What do you want to spend your " + this.attributePoints + "points on?");
        printAttributes();
        //continue
    }

}
