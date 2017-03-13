package Main.Game.Entity.Entities;

import Main.Game.Entity.Entities.Books.AbilityBooks.Ability;
import Main.Game.Entity.Entities.Books.AbilityBooks.Skillbook;
import Main.Game.Entity.Entities.Books.AbilityBooks.Spellbook;
import Main.Game.Entity.Entities.Books.PassiveBooks.Perk;
import Main.Game.Entity.Entities.Books.PassiveBooks.PerkBook;
import Main.Game.Entity.Entities.Books.Book;
import Main.Game.Entity.Entities.Books.StatBooks.StatBook;
import Main.Game.Entity.Entities.Item.Consumable;
import Main.Game.Entity.Entities.Item.Equipable;
import Main.Game.Entity.Entities.Item.Item;
import Main.Game.Entity.Entities.RaceLists.Race;
import Main.Game.Entity.Entities.TraitLists.TraitList;
import Main.Game.Entity.Entity;
import Main.Game.Entity.Entities.ProfessionLists.Profession;

import java.util.*;

public class Player extends Entity implements Comparable<Player>, Comparator<Player>{

    private String name;
    private StatBook statBook;
    private Profession profession;
    private Race race;
    private TraitList traitList;
    private Skillbook skillbook;
    private Spellbook spellbook;
    private PerkBook perkBook;
    private Entities team;
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

    public Player(String name, Profession profession, Race race, TraitList traitList) {
        this.name = name;
        this.profession = profession;
        this.race = race;
        this.traitList = traitList;
        this.skillbook = new Skillbook();
        this.spellbook = new Spellbook();
        this.perkBook = new PerkBook();
        this.equipment = new HashMap<>();

        this.statBook = new StatBook(race.getStats(), profession.getMods());

        traitList.initializeAllTraits(this);

        updatePlayer();
        this.hp = maxHp;
        this.mp = maxMp;
    }

    public void updatePlayer() {
        calculateBaseValues();
        calculateValues();
    }


    private void calculateBaseValues() {
        System.out.println(statBook.get("strength"));
        System.out.println(statBook.get("strength").toString());
        this.baseDamage = calculateBaseDamage(statBook.get("strength").get());
        this.baseStamina = calculateBaseStamina(statBook.get("endurance").get());
        this.baseSpellDamage = calculateBaseSpellDamage(statBook.get("knowledge").get());
        this.baseCharisma = calculateBaseCharisma(statBook.get("perception").get());
        this.baseEffectChance = calculateBaseEffectChance(statBook.get("perception").get());
        this.baseHpReg = calculateBaseHpReg(statBook.get("mentality").get());
        this.baseMpReg = calculateBaseMpReg (statBook.get("mentality").get());
        this.baseArmor = calculateBaseArmor(statBook.get("hardening").get());
        this.baseResistance = calculateBaseResistance(statBook.get("hardening").get());
        this.baseMaxHp = calculateBaseMaxHp(statBook.get("strength").get());
        this.baseMaxMp = calculateBaseMaxMp(statBook.get("knowledge").get());
    }

    private void calculateValues() { //ToDo Add Clothes/Status effects
        this.damage = calculateDamage(damageMod, baseDamage) + equipmentDamage;
        this.stamina = calculateStamina(staminaMod, baseStamina) + equipmentStamina;
        this.spellDamage = calculateSpellDamage(spellDamageMod, baseSpellDamage) + equipmentSpellDamage;
        this.charisma = calculateCharisma(charismaMod, baseCharisma) + equipmentCharisma;
        this.effectChance = calculateEffectChance(effectChanceMod, baseEffectChance) + equipmentEffectChance;
        this.hpReg = calculateHpReg(hpRegMod, baseHpReg) + equipmentHpReg;
        this.mpReg = calculateMpReg(mpRegMod, baseMpReg) + equipmentMpReg;
        this.armor = calculateArmor(armorMod, baseArmor) + equipmentArmor;
        this.resistance = calculateResistance(resistanceMod, baseResistance) + equipmentResistance;
        this.maxHp = calculateMaxHp(maxHpMod, baseMaxHp) + equipmentMaxHp;
        this.maxMp = calculateMaxMp(maxMpMod, baseMaxMp) + equipmentMaxMp;
    }

    public String name() {
        return this.name;
    }
    // AddTo Stats
    @Override
    public void addToHp(double value) {
        this.hp += value;
        System.out.println(this.toString() + " was healed for " + value + ".");
    }
    @Override
    public void addToMp(double value) {
        this.mp += value;
        System.out.println(this.toString() + " gained " + value + "mp.");
    }
    @Override
    public void addToXp(double value) {
        this.xp += value;
        System.out.println(this.toString() + " gained " + value + "xp.");
    }

    //add to books
    @Override
    public void addToSkillbook(Ability ability) {
        this.skillbook.add(ability);
    }
    @Override
    public void addToSpellbook(Ability ability) {
        this.spellbook.add(ability);
    }
    @Override
    public void addToPerkbook(Perk perk) {
        this.perkBook.add(perk);
    }


    @Override
    public void addToStatMod(String name, double value) {
        statBook.get(name).addMod(value);
    }
    @Override
    public void addTeam(Entities team) {
        this.team = team;
    }
    @Override
    public int getStatValue(String name) {
        return statBook.get(name).get();
    }
    @Override
    public String getName(){
        return "you";
    } //ToDo differentiate with real name

    // AddTo Stat MODIFIER
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


    public void equip(Equipable equipable) { //Todo Remove equiped item from inventory list or mark them as used
        this.equipment.put(equipable.getSlot(), equipable);
        updateEquipment();
        updatePlayer();
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
        this.equipmentMaxHp = 0;
        this.equipmentMaxMp = 0;

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
            this.equipmentMaxHp += equipable.getArmor();
            this.equipmentMaxMp += equipable.getResistance();
        }
    }

    //ATTACK MOVES
    @Override
    public void attack(Entities entities1, Entities enemies) {
        boolean validAction = false;
      while (!validAction) {
            System.out.println("Choose your attack move. (" + skillbook.toString() + ")");
            String action = Console.getStringInput();

            if (skillbook.contains(action)) {//already uses getAbility ->simplify
                ArrayList<HashMap<Entity, Integer>> actions = skillbook.get(action).use(this, this.damage, enemies);
                perkBook.use(this, actions);
                validAction = true;
            }
            else {
                    System.out.println("You can't do that");
                    validAction = false;
            }
        }
    }
    //CAST SPELLS
    @Override
    public void cast(Entities entities1, Entities enemies) {
        boolean validAction = false;

        while (!validAction) {
            System.out.println("Choose your spell. (" + spellbook.toString() + ")");
            String action = Console.getStringInput();

            if (spellbook.contains(action)) {//already uses getAbility ->simplify
                spellbook.get(action).use(this, this.spellDamage, enemies);
                validAction = true;
            }
            else {
                System.out.println("You can't do that");
                validAction = false;
            }
        }
    }

    //USE ITEMS
    @Override
    public void item(Entities entities1, Entities enemies) {
        boolean validAction = false;

        while (!validAction) {
            System.out.println("Which item do you want to use?(type name)");
            System.out.println(team.inventory().consumablesToString());
            String itemName = Console.getStringInput();

            if (team.inventory().contains(itemName)) {//already uses getAbility ->simplify
                Consumable consumable = team.inventory().getConsumables(itemName);
                consumable.use(entities1, enemies);
                team.inventory().remove((Item)consumable);
                validAction = true;
            }
            else {
                System.out.println("You can't do that");
                validAction = false;
            }
        }
    }

    @Override
    public boolean escape(Entities entities1, Entities enemies) { //ToDo make escape chances dependent on attributes of you and enemies f.e. some intRandom of improvisation*endurance vs perception*endurance
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
        this.hp-= pureDamage;
        System.out.println("You received " + pureDamage + " damage from " + actor + ".");
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
        System.out.println("You  received " + pureDamage + " spell damage from " + actor + ".");
        checkLeathal();
        HashMap hashmap = new HashMap<Entity, Integer>();
        hashmap.put(this, pureDamage);
        return hashmap;
    }
    @Override
    public void checkLeathal() {
        if(this.hp < 0) {
            System.out.println("You died.");
        }
    }

    public void printStatus() {
        System.out.println("HP: " + hp + "/" + maxHp);
        System.out.println("MP: " + mp + "/" + maxMp);
        System.out.println("XP: " + xp + "/" + xpToNextLevel);
        System.out.println("Status effects: \n");
    }

    public void spendAttributePoints() {
        System.out.println("What do you want to spend your " + this.attributePoints + "points on?");
        //printAttributes(baseStrength, baseStamina, baseKnowledge, basePerception, baseMentality, baseHardening);
        //continue
    }
    @Override
    public String toString() {
        return String.format(name + ": (%s/%sHP %s/%sMP %sEnd)\n ", hp, maxHp,mp, maxMp, statBook.get("endurance").get());
    }

    public void printCharacter() {
   /*
        System.out.println("name: " + name);
        System.out.println("profession: " + profession);
        System.out.println("race: " + race);
        System.out.println("traitList: " + traitList.toString());
        System.out.println("skillbook: " + skillbook.toString());
        System.out.println("spellbook: " + spellbook.toString());

        System.out.println("xp: " + xp);
        System.out.println("level: " + level);
        System.out.println("xpToNextLevel: " + xpToNextLevel);
        System.out.println("attributePoints: " + attributePoints);

        System.out.println("maxHp: " + maxHp);
        System.out.println("hp: " + hp);
        System.out.println("maxMp: " + maxMp);
        System.out.println("mp: " + mp);

        System.out.println("baseStrength: " + baseStrength);
        System.out.println("baseEndurance: " + baseEndurance);
        System.out.println("baseKnowledge: " + baseKnowledge);
        System.out.println("basePerception: " + basePerception);
        System.out.println("baseMentality: " + baseMentality);
        System.out.println("baseHardening: " + baseHardening);
        System.out.println("baseImprovisation: " + baseImprovisation);

        System.out.println("strengthMod: " + strengthMod);
        System.out.println("enduranceMod: " + enduranceMod);
        System.out.println("knowledgeMod: " + knowledgeMod);
        System.out.println("perceptionMod: " + perceptionMod);
        System.out.println("mentalityMod: " + mentalityMod);
        System.out.println("hardeningMod: " + hardeningMod);
        System.out.println("improvisationMod: " + improvisationMod);

        System.out.println("strength: " + strength);
        System.out.println("endurance: " + endurance);
        System.out.println("knowledge: " + knowledge);
        System.out.println("perception: " + perception);
        System.out.println("mentality: " + mentality);
        System.out.println("hardening: " + hardening);
        System.out.println("improvisation: " + improvisation);

        System.out.println("baseDamage: " + baseDamage);
        System.out.println("baseStamina: " + baseStamina);
        System.out.println("baseSpellDamage: " + baseSpellDamage);
        System.out.println("baseCharisma: " + baseCharisma);
        System.out.println("baseEffectChance: " + baseEffectChance);
        System.out.println("baseHpReg: " + baseHpReg);
        System.out.println("baseMpReg: " + baseMpReg);
        System.out.println("baseArmor: " + baseArmor);
        System.out.println("baseResistance: " + baseResistance);

        System.out.println("damage: " + damage);
        System.out.println("stamina: " + stamina);
        System.out.println("spellDamage: " + spellDamage);
        System.out.println("charisma: " + charisma);
        System.out.println("effectChance: " + effectChance);
        System.out.println("hpReg: " + hpReg);
        System.out.println("mpReg: " + mpReg);
        System.out.println("armor: : " + armor);
        System.out.println("resistance: : " + resistance);
        System.out.println();
        */
    }

    @Override
    public int compareTo(Player o) {
        return this.getStatValue("endurance") - o.getStatValue("endurance");
    }

    @Override
    public int compare(Player o1, Player o2) {
        return o1.getStatValue("endurance") - o2.getStatValue("endurance");
    }
}
