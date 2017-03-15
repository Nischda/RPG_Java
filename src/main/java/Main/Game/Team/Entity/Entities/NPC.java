package Main.Game.Team.Entity.Entities;

import Main.Game.Team.Entity.Components.Books.AbilityBooks.Ability;
import Main.Game.Team.Entity.Components.Books.AbilityBooks.SkillBook.Skillbook;
import Main.Game.Team.Entity.Components.Books.AbilityBooks.SpellBook.SpellBook;
import Main.Game.Team.Entity.Components.Books.PassiveBooks.PerkBook.Perk;
import Main.Game.Team.Entity.Components.Books.PassiveBooks.PerkBook.PerkBook;
import Main.Game.Team.Entity.Components.Books.AttributeBooks.AttributeBook;
import Main.Game.Team.Entity.Components.Books.PassiveBooks.TraitBook.TraitBook;
import Main.Game.Team.Entity.Components.Books.ProfessionBooks.Profession;
import Main.Game.Team.Entity.Entity;
import Main.Game.Team.Team;
import Main.Game.Team.Item.Equipable;
import Main.Game.Team.Entity.Components.Books.RaceBooks.Race;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class NPC extends Entity {

    private Scanner in = new Scanner(System.in);
    private String name;
    private AttributeBook attributeBook;
    private Profession profession;
    private Race race;
    private TraitBook traitBook;
    private Skillbook skillbook;
    private SpellBook spellBook;
    private PerkBook perkBook;
    private Team team;
    private HashMap<String, Equipable> equipment;

    private int xp = 0;
    private int level = 1;
    private int xpToNextLevel = 100;
    private int attributePoints = 0;

    private int maxHp;
    private int hp;
    private int maxMp;
    private int mp;

    private int baseDamage;
    private int baseStamina;
    private int baseSpellDamage;
    private int baseCharisma;
    private int baseEffectChance;
    private int baseHpReg;
    private int baseMpReg;
    private int baseArmor;
    private int baseResistance;
    private int baseMaxHp;
    private int baseMaxMp;

    private double damageMod = 1;
    private double staminaMod = 1;
    private double spellDamageMod = 1;
    private double charismaMod = 1;
    private double effectChanceMod = 1;
    private double maxHpMod = 1;
    private double maxMpMod = 1;
    private double hpRegMod = 1;
    private double mpRegMod = 1;
    private double armorMod = 1;
    private double resistanceMod = 1;

    private int damage;
    private int stamina;
    private int spellDamage;
    private int charisma;
    private int effectChance;
    private int hpReg;
    private int mpReg;
    private int armor;
    private int resistance;

    private int equipmentDamage;
    private int equipmentStamina;
    private int equipmentSpellDamage;
    private int equipmentCharisma;
    private int equipmentEffectChance;
    private int equipmentHpReg;
    private int equipmentMpReg;
    private int equipmentArmor;
    private int equipmentResistance;
    private int equipmentMaxHp;
    private int equipmentMaxMp;



    public NPC(String name, Profession profession, Race race, TraitBook traitBook) {
        this.name = name;
        this.profession = profession;
        this.race = race;
        this.traitBook = traitBook;
        this.skillbook = new Skillbook();
        this.spellBook = new SpellBook();
        this.perkBook = new PerkBook();
        this.equipment = new HashMap<>();

        this.attributeBook = new AttributeBook(race.getStats(), profession.getMods());

        //traitBook.initializeAllTraits(this); //Todo

        updateNPC();
        this.hp = maxHp;
        this.mp = maxMp;
    }

    public void updateNPC() {
        calculateBaseValues();
        calculateValues();

    }

    private void calculateBaseValues() {
        this.baseDamage = calculateBaseDamage(attributeBook.get("strength").get());
        this.baseStamina = calculateBaseStamina(attributeBook.get("endurance").get());
        this.baseSpellDamage = calculateBaseSpellDamage(attributeBook.get("knowledge").get());
        this.baseCharisma = calculateBaseCharisma(attributeBook.get("perception").get());
        this.baseEffectChance = calculateBaseEffectChance(attributeBook.get("perception").get());
        this.baseHpReg = calculateBaseHpReg(attributeBook.get("mentality").get());
        this.baseMpReg = calculateBaseMpReg (attributeBook.get("mentality").get());
        this.baseArmor = calculateBaseArmor(attributeBook.get("hardening").get());
        this.baseResistance = calculateBaseResistance(attributeBook.get("hardening").get());
        this.baseMaxHp = calculateBaseMaxHp(attributeBook.get("strength").get());
        this.baseMaxMp = calculateBaseMaxMp(attributeBook.get("knowledge").get());
    }
    private void calculateValues() { //ToDo Add Clothes/Status effects
        this.damage = calculateDamage(damageMod, baseDamage);
        this.stamina = calculateStamina(staminaMod, baseStamina);
        this.spellDamage = calculateSpellDamage(spellDamageMod, baseSpellDamage);
        this.charisma = calculateCharisma(charismaMod, baseCharisma);
        this.effectChance = calculateEffectChance(effectChanceMod, baseEffectChance);
        this.hpReg = calculateHpReg(hpRegMod, baseHpReg);
        this.mpReg = calculateMpReg(mpRegMod, baseMpReg);
        this.armor = calculateArmor(armorMod, baseArmor);
        this.resistance = calculateResistance(resistanceMod, baseResistance);
        this.maxHp = calculateMaxHp(maxHpMod, baseMaxHp);
        this.maxMp = calculateMaxMp(maxMpMod, baseMaxMp);
    }

    public String name() {
        return this.name;
    }


    // AddTo Stats
    @Override
    public void addToHp(double value) {
        this.hp += value;
        System.out.println(this.name() + " was healed for " + value + ".");
    }
    @Override
    public void addToMp(double value) {
        this.mp += value;
        System.out.println(this.name() + " gained " + value + "mp.");
    }
    @Override
    public void addToXp(double value) {
        this.xp += value;
        System.out.println(this.name() + " gained " + value + "xp.");
    }

    //add to books
    @Override
    public void addToSkillbook(Ability ability) {
        this.skillbook.add(ability);
    }
    @Override
    public void addToSpellbook(Ability ability) {
        this.spellBook.add(ability);
    }
    @Override
    public void addToPerkbook(Perk perk) {
        this.perkBook.add(perk);
    }


    @Override
    public void addToStatMod(String name, double value) {
        attributeBook.get(name).addMod(value);
    }
    @Override
    public void addTeam(Team team) {
        this.team = team;
    }
    @Override
    public int getStatValue(String name) {
        return attributeBook.get(name).get();
    }
    @Override
    public String getName(){
        return this.name;
    } //ToDo differentiate with real name

    /*
    // AddTo Attribute MODIFIER
    @Override
    public void addToDamageMod(double value) {
        damageMod += value;
    }
    @Override
    public void addToStaminaMod(double value) {
        staminaMod += value;
    }
    @Override
    public void addToSpellDamageMod(double value) {
        spellDamageMod += value;
    }
    @Override
    public void addToCharismaMod(double value) {
        charismaMod += value;
    }
    @Override
    public void addToEffectChanceMod(double value) {
        effectChanceMod += value;
    }
    @Override
    public void addToHpRegMod(double value) {
        hpRegMod += value;
    }
    @Override
    public void addToMpRegMod(double value) {
        mpRegMod += value;
    }
    @Override
    public void addToArmorMod(double value) {
        armorMod += value;
    }
    @Override
    public void addToResistanceMod(double value) {
        resistanceMod += value;
    }
    @Override
    public void addToMaxHpMod(double value) {
        maxHpMod += value;
    }
    @Override
    public void addToMaxMpMod(double value) {
        maxMpMod += value;
    }

*/
    public void equip(Equipable equipable) {
        this.equipment.put(equipable.getSlot(), equipable);
        updateEquipment();
    }

    public void updateEquipment() {
        this.equipmentDamage = 0;
        this.equipmentStamina= 0;
        this.equipmentSpellDamage= 0;
        this.equipmentCharisma= 0;
        this.equipmentEffectChance= 0;
        this.equipmentHpReg= 0;
        this.equipmentMpReg= 0;
        this.equipmentArmor= 0;
        this.equipmentResistance= 0;

        for(Equipable equipable : equipment.values()) {
            this.equipmentDamage += equipable.getDamage();
            this.equipmentStamina += equipable.getStamina();
            this.equipmentSpellDamage += equipable.getSpellDamage();
            this.equipmentCharisma += equipable.getCharisma();
            this.equipmentEffectChance += equipable.getEffectChance();
            this.equipmentHpReg += equipable.getHpReg();
            this.equipmentMpReg += equipable.getDamage();
            this.equipmentArmor += equipable.getArmor();
            this.equipmentResistance += equipable.getResistance();
        }
    }

//move somewhere else, utility class for abilities?
//ATTACK MOVES
    @Override
    public void attack(Team team1, Team team2) {
        skillbook.getRandom().aiUse(this, this.damage, team2);
    }

    //CAST SPELLS
    @Override
    public void cast(Team team1, Team team2) {
        spellBook.getRandom().aiUse(this, this.spellDamage, team2);
    }
    @Override
    public void item(Team team1, Team enemies) {
        boolean validAction = false;

        while (!validAction) {
            System.out.println("Which item do you want to use?");
            System.out.println(team.inventory().consumablesToString());
            String action = in.nextLine().toLowerCase();

            if (team.inventory().contains(action)) {//already uses getAbility ->simplify
                //  team.inventory().getItem(action).use(team1, enemies);
                validAction = true;
            }
            else {
                System.out.println("You can't do that");
                validAction = false;
            }
        }
    }

    public boolean escape(Team team1, Team team2) { //ToDo make escape chances dependent on attributes of you and enemies f.e. some intRandom of improvisation*endurance vs perception*endurance
        Random intRandom = new Random();
        int rand = intRandom.nextInt(10) + 1;
        if(rand < 5) {
            System.out.println("You managed to escape!");
            return true;
        }
        System.out.println("You got caught beforehand!");
        return false;
    }


    //PLAYER STATUS
    @Override
    public HashMap<Entity, Integer> receivePhysicalDamage(int damage, String actor) {
        int pureDamage = damage - baseArmor;
        if(pureDamage <= 0) pureDamage = 1;
        this.hp -= pureDamage;
        System.out.println("You dealt " + pureDamage + " damage to " + this.name + ".");
        checkLeathal();
        HashMap hashmap = new HashMap<Entity, Integer>();
        hashmap.put(this, pureDamage);
        return hashmap;
    }
    @Override
    public HashMap<Entity, Integer> receiveSpellDamage(int damage, String actor) {
        int pureDamage = damage - baseResistance;
        if(pureDamage <= 0) pureDamage = 1;
        this.hp-= pureDamage;
        System.out.println("You dealt " + pureDamage + " spell damage to " + this.name + ".");
        checkLeathal();
        HashMap hashmap = new HashMap<Entity, Integer>();
        hashmap.put(this, pureDamage);
        return hashmap;
    }
    @Override
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
        //printAttributes(baseStrength, baseStamina, baseKnowledge, basePerception, baseMentality, baseHardening);
        //continue
    }

    @Override
    public String toString() {
        return String.format("%s %s: %s (%s/%sHP %s/%sMP %Speed)\n",this.race, this.profession, this.name, this.hp, this.maxHp, this.mp, this.maxMp, this.getStatValue("speed"));
    }
}