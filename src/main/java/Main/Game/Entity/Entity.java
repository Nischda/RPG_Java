package Main.Game.Entity;


import Main.Game.Entity.Entities.Item.Inventory;

import java.util.ArrayList;

public abstract class Entity implements Fightable{

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

    public abstract String name();
    public abstract int getStrength();
    public abstract int getEndurance();
    public abstract int getKnowledge();
    public abstract int getPerception();
    public abstract int getMentality();
    public abstract int getHardening();
    public abstract int getImprovisation();
    public abstract String getName();

    public abstract void setBaseAttributes(int baseStrength, int baseEndurance, int baseKnowledge, int basePerception, int baseMentality, int baseHardening, int baseImprovisation);
    public abstract String toString();

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
        return baseHardening;
    } // *armorModifier * other boni
    protected int calculateBaseResistance(int baseHardening) {
        return baseHardening;
    } // *armorModifier * other boni

    public static void printEntities(ArrayList<Entity> entityList) {
        StringBuilder string = new StringBuilder();
        int count = 1;
        for (Entity entity : entityList) {
            string.append(count + ". " + entity.toString());
            count++;
        }
        System.out.println(string.toString());
    }

}
