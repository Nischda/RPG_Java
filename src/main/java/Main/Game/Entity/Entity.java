package Main.Game.Entity;


import Main.Game.Entity.Entities.Entities;
import Main.Game.Entity.Entities.Item.Equipable;

import java.util.ArrayList;

public abstract class Entity implements Fightable{

//add contrustor to do shit from here for player & entity?

    public abstract void addTeam(Entities team);
    public abstract void addToHp(double value);
    public abstract void addToMp(double value);
    public abstract void addToXp(double value);
    public abstract void addToStatMod(String name, double value);

    public abstract void addToDamageMod(double value);
    public abstract void addToStaminaMod(double value);
    public abstract void addToSpellDamageMod(double value);
    public abstract void addToCharismaMod(double value);
    public abstract void addToEffectChanceMod(double value);
    public abstract void addToHpRegMod(double value);
    public abstract void addToMpRegMod(double value);
    public abstract void addToArmorMod(double value);
    public abstract void addToResistanceMod(double value);
    public abstract void addToMaxHpMod(double value);
    public abstract void addToMaxMpMod(double value);

    public abstract int getStatValue(String name);
    public abstract String getName();

    public abstract void equip (Equipable equipable);
    public abstract String toString();

    protected int calculateBaseMaxHp(int baseStrength) {
        return (int)(baseStrength * 10);
    }
    protected int calculateBaseMaxMp(int baseKnowledge) {
        return (int)(baseKnowledge * 10);
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

    protected int calculateDamage(double baseDamage, int damageMod) {
        return (int)(baseDamage * damageMod);
    }
    protected int calculateStamina(double baseStamina, int staminaMod) {
        return (int)(baseStamina * staminaMod);
    }
    protected int calculateSpellDamage(double baseSpellDamage, int spellDamageMod) {
        return (int)(baseSpellDamage * spellDamageMod);
    }
    protected int calculateCharisma(double baseCharisma, int charismaMod) {
        return (int)(baseCharisma * charismaMod);
    }
    protected int calculateEffectChance(double baseEffectChance, int effectChanceMod) {
        return (int)(baseEffectChance * effectChanceMod);
    }
    protected int calculateHpReg(double baseHpReg, int hpRegMod) {
        return (int)(baseHpReg * hpRegMod);
    }
    protected int calculateMpReg(double baseMpReg, int mpRegMod) {
        return (int)(baseMpReg * mpRegMod);
    }
    protected int calculateArmor(double baseArmor, int armorMod) {
        return (int)(baseArmor * armorMod);
    }
    protected int calculateResistance(double baseResistance, int resistanceMod) {
        return (int)(baseResistance * resistanceMod);
    }
    protected int calculateMaxHp(double baseMaxHp, int maxHpMod) {
        return (int)(baseMaxHp * maxHpMod);
    }
    protected int calculateMaxMp(double baseMaxMp, int maxMpMod) {
        return (int)(baseMaxMp * maxMpMod);
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

    public static void printEntities(Entities entities) {
        StringBuilder string = new StringBuilder();
        int count = 1;
        for (Entity entity : entities) {
            string.append(count + ". " + entity.toString());
            count++;
        }
        System.out.println(string.toString());
    }

}
