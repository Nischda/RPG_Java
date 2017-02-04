package Entities;

import Entities.Items.Inventory;
import Entities.ProfessionLists.Profession;
import Entities.RaceLists.*;
import Entities.TraitLists.CustomTraitList;

public class Player extends Entity {

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

    private static Inventory inventory = new Inventory();

    private int baseStrength; //see if making double
    private int baseEndurance;
    private int baseKnowledge;
    private int basePerception;
    private int baseMentality;
    private int baseHardening;
    private int baseImprovisation;

    private double strengthMod = 1;
    private double enduranceMod = 1;
    private double knowledgeMod = 1;
    private double perceptionMod = 1;
    private double mentalityMod = 1;
    private double hardeningMod = 1;
    private double improvisationMod = 1;

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


    public Player(String name, Profession profession, Race race, CustomTraitList traitList) {
        this.name = name;
        this.profession = profession;
        this.race = race;
        this.customTraitList = traitList;

        profession.initializePerks(this);
        race.initializeAttributes(this);
        traitList.initializeAllTraits();

        this.baseStrength = calculateStrength(strengthMod, baseStrength );
        this.baseEndurance = calculateEndurance(enduranceMod, baseEndurance);
        this.baseKnowledge = calculateKnowledge(knowledgeMod, baseKnowledge);
        this.basePerception = calculatePerception(perceptionMod, basePerception);
        this.baseMentality = calculateMentality(mentalityMod, baseMentality);
        this.baseHardening = calculateHardening(hardeningMod,baseHardening);

        this.baseDamage = calculateBaseDamage(baseStrength);
        this.baseStamina = calculateBaseStamina(baseEndurance);
        this.baseSpellDamage = calculateBaseSpellDamage(baseKnowledge);
        this.baseCharisma = calculateBaseCharisma(basePerception);
        this.baseEffectChance = calculateBaseEffectChance(basePerception);
        this.baseHpReg = calculateBaseHpReg(baseMentality);
        this.baseMpReg = calculateBaseMpReg (baseMentality);
        this.baseArmor = calculateBaseArmor(baseHardening);
        this.baseResistance = calculateBaseResistance(baseHardening);

        this.maxHp = calculateMaxHp(strengthMod, baseStrength);
        this.hp = maxHp;
        this.maxMp = calculateMaxMp(knowledgeMod, baseKnowledge);
        this.mp = maxMp;

        printStatus();
        System.out.println(this.toString());
    }



    @Override
    public void setBaseStrength(int baseStrength) {
        this.baseStrength = baseStrength;
    };
    @Override
    public void setBaseEndurance(int baseEndurance) {
        this.baseEndurance = baseEndurance;
    };
    @Override
    public void setBaseKnowledge(int baseKnowledge) {
        this. baseKnowledge = baseKnowledge;
    };
    @Override
    public void setBasePerception(int basePerception) {
        this. basePerception = basePerception;
    };
    @Override
    public void setBaseMentality (int baseMentality) {
        this. baseMentality = baseMentality;
    };
    @Override
    public void  setBaseHardening(int baseHardening) {
        this.baseHardening = baseHardening;
    };

    @Override
    public int getHp() {
        return hp;
    }
    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }
    @Override
    public int getMp() {
        return mp;
    }
    @Override
    public void setMp(int mp) {
        this.mp = mp;
    }
    @Override
    public double getStrengthMod() {
        return strengthMod;
    }
    @Override
    public void setStrengthMod(double strengthMod) {
        this.strengthMod = strengthMod;
    }
    @Override
    public double getEnduranceMod() {
        return enduranceMod;
    }
    @Override
    public void setEnduranceMod(double enduranceMod) {
        this.enduranceMod = enduranceMod;
    }
    @Override
    public double getKnowledgeMod() {
        return knowledgeMod;
    }
    @Override
    public void setKnowledgeMod(double knowledgeMod) {
        this.knowledgeMod = knowledgeMod;
    }
    @Override
    public double getPerceptionMod() {
        return perceptionMod;
    }
    @Override
    public void setPerceptionMod(double perceptionMod) {
        this.perceptionMod = perceptionMod;
    }
    @Override
    public double getMentalityMod() {
        return mentalityMod;
    }
    @Override
    public void setMentalityMod(double mentalityMod) {
        this.mentalityMod = mentalityMod;
    }
    @Override
    public double getHardeningMod() {
        return hardeningMod;
    }
    @Override
    public void setHardeningMod(double hardeningMod) {
        this.hardeningMod = hardeningMod;
    }
    @Override
    public double getImprovisationMod() {
        return improvisationMod;
    }
    @Override
    public void setImprovisationMod(double improvisationMod) {
        this.improvisationMod = improvisationMod;
    }
    @Override
    public int getStrength() {
        return strength;
    }
    @Override
    public int getEndurance() {
        return endurance;
    }
    @Override
    public int getKnowledge() {
        return knowledge;
    }
    @Override
    public int getPerception() {
        return perception;
    }
    @Override
    public int getMentality() {
        return mentality;
    }
    @Override
    public int getHardening() {
        return hardening;
    }

    public int getXp() {
        return xp;
    }
    public void setXp(int xp) {
        this.xp = xp;
    }

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

    public void spendAttributePoints() {
        System.out.println("What do you want to spend your " + this.attributePoints + "points on?");
        printAttributes(baseStrength, baseStamina, baseKnowledge, basePerception, baseMentality, baseHardening);
        //continue
    }
    @Override
    public String toString() {
        return String.format("name: %s, profession: %s, race: %s, HP: %s, MP: %s, endurance: %s ",this.name, this.profession,this.race, this.hp, this.mp, this.endurance);
    }

}
