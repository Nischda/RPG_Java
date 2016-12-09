import ProfessionLists.Profession;
import RaceLists.*;
import TraitLists.Trait;

public class Player {

    private String name;
    private Profession profession;
    private Race race;
    private Trait[] traits;

    private int xp;
    private int hp;
    private int mp;

    private int baseStrength;
    private int baseEndurance;
    private int baseKnowledge;
    private int basePerception;
    private int baseMentality;
    private int baseHardening;
    private int baseImprovisation;

    private int strengthMod;
    private int enduranceMod;
    private int knowledgeMod;
    private int perceptionMod;
    private int mentalityMod;
    private int hardeningMod;
    private int improvisationMod;

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
        return traits.toString();
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

    public int getStrengthMod() {
        return strengthMod;
    }

    public void setStrengthMod(int strengthMod) {
        this.strengthMod = strengthMod;
    }

    public int getEnduranceMod() {
        return enduranceMod;
    }

    public void setEnduranceMod(int enduranceMod) {
        this.enduranceMod = enduranceMod;
    }

    public int getKnowledgeMod() {
        return knowledgeMod;
    }

    public void setKnowledgeMod(int knowledgeMod) {
        this.knowledgeMod = knowledgeMod;
    }

    public int getPerceptionMod() {
        return perceptionMod;
    }

    public void setPerceptionMod(int perceptionMod) {
        this.perceptionMod = perceptionMod;
    }

    public int getMentalityMod() {
        return mentalityMod;
    }

    public void setMentalityMod(int mentalityMod) {
        this.mentalityMod = mentalityMod;
    }

    public int getHardeningMod() {
        return hardeningMod;
    }

    public void setHardeningMod(int hardeningMod) {
        this.hardeningMod = hardeningMod;
    }

    public int getImprovisationMod() {
        return improvisationMod;
    }

    public void setImprovisationMod(int improvisationMod) {
        this.improvisationMod = improvisationMod;
    }


    public Player(String name, Profession classType, Race race, Trait[] traitses, int xp, int hp, int mp,
                  int baseStrength, int baseEndurance, int baseKnowledge, int basePerception, int baseMentality, int baseHardening, int baseImprovisation) {
        this.name = name;
        this.profession = classType;
        this.race = race;
        this.traits = traitses;
        this.xp = xp;
        this.hp = hp;
        this.mp = mp;
        this.baseStrength = baseStrength;
        this.baseEndurance = baseEndurance;
        this.baseKnowledge = baseKnowledge;
        this.baseMentality = baseMentality;
        this.basePerception = basePerception;
        this.baseHardening = baseHardening;
        this.baseImprovisation = baseImprovisation;

    }


}
