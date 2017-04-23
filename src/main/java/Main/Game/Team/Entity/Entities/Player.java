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
import Main.Game.Team.Item.Consumable;
import Main.Game.Team.Item.Equipable;
import Main.Game.Team.Item.Item;
import Main.Game.Team.Entity.Components.Books.RaceBooks.Race;
import Main.Game.Utility.Input.Console;

import java.util.*;

public class Player extends Entity implements Comparable<Player>, Comparator<Player>{

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

    private int equipmentDamage;
    private int equipmentAgility;
    private int equipmentSpellDamage;
    private int equipmentCharisma;
    private int equipmentEffectChance;
    private int equipmentHpReg;
    private int equipmentMpReg;
    private int equipmentArmor;
    private int equipmentResistance;
    private int equipmentMaxHp;
    private int equipmentMaxMp;

    public Player(String name, Profession profession, Race race, TraitBook traitBook) {
        this.name = name;
        this.profession = profession;
        this.race = race;
        this.traitBook = traitBook;
        this.skillbook = new Skillbook();
        this.spellBook = new SpellBook();
        this.equipment = new HashMap<>();

        this.attributeBook = new AttributeBook(race.getStats(), profession.getMods());
        this.perkBook = new PerkBook();
        this.perkBook.add(perkBook.get(profession.getPerkName()));


      //  updatePlayer();
        this.hp = attributeBook.getValue("maxHp");
        this.mp = attributeBook.getValue("maxMp");
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
        return "you";
    } //ToDo differentiate with real name


    public void equip(Equipable equipable) { //Todo Remove equiped item from getInventory list or mark them as used
        ArrayList<String> slotList = equipable.getSlots();
        if(slotList.size() > 1) {
            boolean validInput = false;
            while(!validInput) {
                System.out.println("On which slot do you want to equip it? (index)");
                System.out.println(Console.toString(slotList));
                int index = Integer.parseInt(in.nextLine())-1;
                if(index >=0 && index < slotList.size()) {
                    this.equipment.put(slotList.get(index), equipable);
                    validInput = true;
                }
                else{
                    System.out.println("Try again");
                }
            }
        }
        else {
            this.equipment.put(slotList.get(0), equipable);
        }
        System.out.println("You equipped " + equipable.toString() + ".");
        updateEquipment();
        //updatePlayer();
    }

    public void updateEquipment() {
        this.equipmentDamage = 0;
        this.equipmentAgility= 0;
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
            this.equipmentDamage += equipable.getStatValue("damage");
            this.equipmentAgility += equipable.getStatValue("agility");
            this.equipmentSpellDamage += equipable.getStatValue("spellDamage");
            this.equipmentCharisma += equipable.getStatValue("charisma");
            this.equipmentEffectChance += equipable.getStatValue("effectChance");
            this.equipmentHpReg += equipable.getStatValue("hpReg");
            this.equipmentMpReg += equipable.getStatValue("mpReg");
            this.equipmentArmor += equipable.getStatValue("armor");
            this.equipmentResistance += equipable.getStatValue("resistance");
            this.equipmentMaxHp += equipable.getStatValue("maxHp");
            this.equipmentMaxMp += equipable.getStatValue("maxMp");
        }
    }

    //ATTACK MOVES
    @Override
    public void attack(Team team1, Team enemies) {
        boolean validAction = false;
      while (!validAction) {
            System.out.println("Choose your attack move. (" + skillbook.toString() + ")");
            Console.input();
            if(Console.gotBuffer()) {
                String action = Console.getBuffer();

                if (skillbook.contains(action)) {//ToDo already uses getAbility ->simplify
                    ArrayList<HashMap<Entity, Integer>> actions = skillbook.get(action).use(this, attributeBook.getValue("damage"), enemies);
                    perkBook.use(this, actions);
                    validAction = true;
                } else {
                    System.out.println("You can't do that");
                    validAction = false;
                }
            }
        }
    }

    //CAST SPELLS
    @Override
    public void cast(Team team1, Team enemies) {
        boolean validAction = false;

        while (!validAction) {
            System.out.println("Choose your spell. (" + spellBook.toString() + ")");
            Console.input();
            if(Console.gotBuffer()) {
                String action = Console.getBuffer();

                if (spellBook.contains(action)) {//already uses getAbility ->simplify
                    spellBook.get(action).use(this, attributeBook.getValue("spellDamage"), enemies);
                    validAction = true;
                } else {
                    System.out.println("You can't do that");
                    validAction = false;
                }
            }
        }
    }

    //USE ITEMS
    @Override
    public void item(Team team1, Team enemies) {
        boolean validAction = false;

        while (!validAction) {
            System.out.println("Which item do you want to use?(type name)");
            System.out.println(team.getInventory().consumablesToString());
            Console.input();
            if(Console.gotBuffer()) {
                String itemName = Console.getBuffer();

                if (team.getInventory().contains(itemName)) {//ToDo already uses getAbility ->simplify
                    Consumable consumable = team.getInventory().getConsumables(itemName);
                    consumable.use(team1, enemies);
                    team.getInventory().remove((Item) consumable);
                    validAction = true;
                } else {
                    System.out.println("You can't do that");
                    validAction = false;
                }
            }
        }
    }

    @Override
    public boolean escape(Team team, Team enemies) {
        int teamImprovisation = 0;
        int enemyPerception = 0;

        for(Entity entity : enemies) {
            enemyPerception += entity.getStatValue("improvisation");
        }
        for(Entity entity : enemies) {
            enemyPerception += entity.getStatValue("perception");
        }

        Random intRandom = new Random();
        int rand = intRandom.nextInt(teamImprovisation) + 1;
        if(rand > enemyPerception / 2) {
            System.out.println("You managed to escape!");
            return true;
        }
        System.out.println("You got caught beforehand!");
        return false;
    }

    //PLAYER STATUS
    @Override
    public HashMap<Entity, Integer> receivePhysicalDamage(int damage, String actor) {
        int pureDamage = damage - attributeBook.getValue("armor");
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
        int pureDamage = damage - attributeBook.getValue("resistance");
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
        //Todo implement
    }
    @Override
    public String toString() {
        return String.format(name + ": (%s/%sHP %s/%sMP %sEnd)\n ", hp, attributeBook.getValue("maxHp"),mp, attributeBook.getValue("maxHp"), attributeBook.getValue("speed"));
    }

    public void printCharacter() {
   /*
        System.out.println("name: " + name);
        System.out.println("profession: " + profession);
        System.out.println("race: " + race);
        System.out.println("traitList: " + traitList.toString());
        System.out.println("skillbook: " + skillbook.toString());
        System.out.println("spellBook: " + spellBook.toString());

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
        System.out.println("baseAgility: " + baseAgility);
        System.out.println("baseSpellDamage: " + baseSpellDamage);
        System.out.println("baseCharisma: " + baseCharisma);
        System.out.println("baseEffectChance: " + baseEffectChance);
        System.out.println("baseHpReg: " + baseHpReg);
        System.out.println("baseMpReg: " + baseMpReg);
        System.out.println("baseArmor: " + baseArmor);
        System.out.println("baseResistance: " + baseResistance);

        System.out.println("damage: " + damage);
        System.out.println("agility: " + agility);
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
        return this.getStatValue("speed") - o.getStatValue("speed");
    }

    @Override
    public int compare(Player o1, Player o2) {
        return o1.getStatValue("speed") - o2.getStatValue("speed");
    }
}
