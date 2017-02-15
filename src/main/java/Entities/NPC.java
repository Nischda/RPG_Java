package Entities;

import Entities.Items.Inventory;
import Entities.ProfessionLists.Profession;
import Entities.RaceLists.*;
import Entities.TraitLists.CustomTraitList;

import java.util.ArrayList;
import java.util.Scanner;

public class NPC extends Entity {

    private Scanner in = new Scanner(System.in);
    private static Inventory inventory = new Inventory();

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
    private int improvisation;

    private int baseDamage;
    private int baseStamina;
    private int baseSpellDamage;
    private int baseCharisma;
    private int baseEffectChance;
    private int baseHpReg;
    private int baseMpReg;
    private int baseArmor;
    private int baseResistance;

    private int damage;
    private int stamina;
    private int spellDamage;
    private int charisma;
    private int effectChance;
    private int hpReg;
    private int mpReg;
    private int armor;
    private int resistance;


    public NPC(String name, Profession profession, Race race, CustomTraitList traitList) {
        this.name = name;
        this.profession = profession;
        this.race = race;
        this.customTraitList = traitList;

        profession.initializePerks(this);
        race.initializeAttributes(this);
        traitList.initializeAllTraits();

        updateNPC();
        this.hp = maxHp;
        this.mp = maxMp;

        printStatus();
        System.out.println(this.toString());
    }

    public void updateNPC() {
        calculateAttributes();
        calculateBaseValues();
        calculateValues();

    }
    private void calculateAttributes() {
        this.strength = calculateStrength(strengthMod, baseStrength );
        this.endurance = calculateEndurance(enduranceMod, baseEndurance);
        this.knowledge = calculateKnowledge(knowledgeMod, baseKnowledge);
        this.perception = calculatePerception(perceptionMod, basePerception);
        this.mentality = calculateMentality(mentalityMod, baseMentality);
        this.hardening = calculateHardening(hardeningMod,baseHardening);
        this.improvisation = calculateBaseImprovisation(improvisationMod, baseImprovisation);
    }
    private void calculateBaseValues() {
        this.baseDamage = calculateBaseDamage(baseStrength); //add weapon
        this.baseStamina = calculateBaseStamina(baseEndurance); //add clothes
        this.baseSpellDamage = calculateBaseSpellDamage(baseKnowledge); //add clothes & weapon
        this.baseCharisma = calculateBaseCharisma(basePerception); //add clothes
        this.baseEffectChance = calculateBaseEffectChance(basePerception); //add clothes
        this.baseHpReg = calculateBaseHpReg(baseMentality); //add clothes
        this.baseMpReg = calculateBaseMpReg (baseMentality); //add clothes
        this.baseArmor = calculateBaseArmor(baseHardening); //add clothes & weapon
        this.baseResistance = calculateBaseResistance(baseHardening); //add clothes
        this.maxHp = calculateMaxHp(strengthMod, baseStrength); //make base?
        this.maxMp = calculateMaxMp(knowledgeMod, baseKnowledge); //make base?
    }
    private void calculateValues() {
        this.damage = baseDamage;               //add status effects
        this.stamina = baseStamina;             //add status effects
        this.spellDamage = baseSpellDamage;     //add status effects
        this.charisma = baseCharisma;           //add status effects
        this.effectChance = baseEffectChance;   //add status effects
        this.hpReg = baseHpReg;                 //add status effects
        this.mpReg = baseMpReg;                 //add status effects
        this.armor = baseArmor;                 //add status effects
        this.resistance = baseResistance;       //add status effects
    }

    //SET BASE ATTRIBUTES
    @Override
    public void setBaseAttributes(int baseStrength, int baseEndurance, int baseKnowledge, int basePerception, int baseMentality, int baseHardening, int baseImprovisation) {
        this.baseStrength = baseStrength;
        this.baseEndurance = baseEndurance;
        this.baseKnowledge = baseKnowledge;
        this.basePerception = basePerception;
        this.baseMentality = baseMentality;
        this.baseHardening = baseHardening;
        this.baseImprovisation = baseImprovisation;
    }


    // AddTo Stats
    @Override
    public void addToHp(double value) {
        this.hp += value;
    }
    @Override
    public void addToMp(double value) {
        this.mp += value;
    }
    @Override
    public void addToXp(double value) {
        this.xp += value;
    }

    // AddTo ATTRIBUTE MODIFIER
    @Override
    public void addToStrengthMod(double value) {
        strengthMod += value;
    }
    @Override
    public void addToEnduranceMod(double value) {
        enduranceMod += value;
    }
    @Override
    public void addToKnowledgeMod(double value) {
        knowledgeMod += value;
    }
    @Override
    public void addToPerceptionMod(double value) {
        perceptionMod += value;
    }
    @Override
    public void addToMentalityMod(double value) {
        mentalityMod += value;
    }
    @Override
    public void addToHardeningMod(double value) {
        hardeningMod += value;
    }
    @Override
    public void addToImprovisationMod(double value) {
        improvisationMod += value;
    }

    //GET ATTRIBUTES
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
    @Override
    public int getImprovisation() {
        return improvisation;
    }

//move somewhere else, utility class for abilities?
    //ATTACK MOVES
    public void attack(ArrayList<Entity> players, ArrayList<Entity> enemies) {
        boolean validAction = false;

        while (!validAction) {
            System.out.println("Choose your attack move. (slash/charge/back)");
            String action = in.nextLine().toUpperCase();
            System.out.println("Choose your target (1/2/3)");
            String target = in.nextLine();
            switch (action) {
                case "SLASH":
                    slash(enemies.get(Integer.parseInt(target)));
                    validAction = true;
                    break;
                case "CHARGE":
                    charge(enemies.get(Integer.parseInt(target)));
                    validAction = true;
                    break;
                case "BACK":
                    System.out.println("not yet implemented. doing nothing");
                    validAction = true;
                    break;
                default:
                    System.out.println("You can't do that");
                    validAction = false;
                    break;
            }
        }
    }

    public void slash(Entity entity) {
        entity.receiveDamage(this.baseDamage);
    }

    public void charge(Entity entity) {
        entity.receiveDamage((this.baseDamage * 2));
    }

    //CAST SPELLS
    public void cast(ArrayList<Entity> players, ArrayList<Entity> enemies) {

    }

    public void firebolt(Entity entity) {

    }

    //USE ITEMS
    public void item(ArrayList<Entity> players, ArrayList<Entity> enemies) {

    }

    public void escape(ArrayList<Entity> players, ArrayList<Entity> enemies) {

    }

    //PLAYER STATUS
    public void receiveDamage(int damage) {
        int pureDamage = damage / baseArmor;
        this.hp -= pureDamage;
        System.out.println(this.name + " received" + pureDamage + " damage.");
        checkLeathal();
    }

    public void checkLeathal() {
        if (this.hp < 0) {
            System.out.println(this.name + " died.");
        }
    }


    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    private void addXp(int xp) {
        this.xp += xp;
        if (this.xp > this.xpToNextLevel) {
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
        return String.format("name: %s, profession: %s, race: %s, HP: %s, MP: %s, endurance: %s ", this.name, this.profession, this.race, this.hp, this.mp, this.endurance);
    }
}