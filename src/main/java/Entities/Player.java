package Entities;

import Entities.ProfessionLists.Profession;
import Entities.RaceLists.*;
import Entities.TraitLists.CustomTraitList;
import Entities.TraitLists.Trait;

public class Player {

    private String name;
    private Profession profession;
    private Race race;
    private CustomTraitList customTraitList;

    private int xp = 0;
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

    private double strengthMod;
    private double enduranceMod;
    private double knowledgeMod;
    private double perceptionMod;
    private double mentalityMod;
    private double hardeningMod;
    private double improvisationMod;

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
    }


    private void calculateMaxHp() {
        this.hp = (int)Math.round(strengthMod * baseStrength);
    }
    private void calculateMaxMp() {
        this.hp = (int)Math.round(strengthMod * baseStrength);
    }
    private void addXp(int xp) {
        this.xp += xp;
        //add check for level up
    }

}
