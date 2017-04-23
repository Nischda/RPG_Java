package Main.Game.Utility.FileHandler;

import Main.Game.Team.Entity.Components.Books.AttributeBooks.Attribute;
import Main.Game.Team.Entity.Components.Books.AttributeBooks.AttributeBook;
import Main.Game.Team.Entity.Components.Books.AttributeBooks.BaseAttribute;
import Main.Game.Team.Entity.Components.Books.PassiveBooks.TraitBook.Trait;
import Main.Game.Team.Entity.Components.Books.PassiveBooks.TraitBook.TraitBook;
import Main.Game.Team.Entity.Components.Books.PassiveBooks.TraitBook.BaseTrait;
import Main.Game.Team.Entity.Components.Books.ProfessionBooks.BaseProfession;
import Main.Game.Team.Entity.Components.Books.ProfessionBooks.Profession;
import Main.Game.Team.Entity.Entities.NPC;
import Main.Game.Team.Entity.Components.Books.RaceBooks.Race;
import Main.Game.Team.Entity.Components.Books.RaceBooks.BaseRace;
import Main.Game.Team.Entity.Entity;
import Main.Game.Team.Entity.Components.Map.TileLists.Tile;
import Main.Game.Team.Entity.Components.Map.TileLists.Tiles.*;
import Main.Game.Team.Item.Items.Weapon;
import Main.Game.Utility.Library;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TxtReader {

    public static ArrayList<ArrayList<Tile>> generateMap() {
        ArrayList<ArrayList<Tile>> map = new ArrayList<>();

        try  {
            Scanner s = new Scanner(new File("D:/RPG_Java/src/main/resources/map.txt"));
            while (s.hasNextLine()) {
                String line = s.next();
                ArrayList<Tile> mapLine = new ArrayList();

                for(int i = 0; i < line.length(); i++) {
                    switch (line.charAt(i)) {
                        case 'M':
                            mapLine.add(new Mountain());
                            break;
                        case 'O':
                            mapLine.add(new Ocean());
                            break;
                        case 'F':
                            mapLine.add(new Forest());
                            break;
                        case 'P':
                            mapLine.add(new Plain());
                            break;
                        case 'R':
                            mapLine.add(new Road());
                            break;
                    }
                }
                map.add(mapLine);
            }
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        return map;
    }

    public static Entity generateNPC(File file, TraitBook traits) {

        try  {
            Scanner s = new Scanner(file);
            int creaturesInFile = Integer.parseInt(s.nextLine());
            Random intRandom = new Random();
            int skipLines = intRandom.nextInt(creaturesInFile)*5;
            for(int i = 0; i < skipLines; i++) {
                s.nextLine();
            }

            String name = s.nextLine();
            Profession profession = Profession.getProfession(s.nextLine());
            Race race = Race.getRace(s.nextLine());
            return new NPC(name, profession, race, traits);
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        System.out.println("Failed to read and create NPC in txtReader");
        return null;
    }

    public static Weapon generateWeapon(File file, Double statMod, Double matMod) {

        try  {
            Scanner s = new Scanner(file);
            ArrayList<String> slots = new ArrayList<>();
            AttributeBook attributeBook = new AttributeBook();

            boolean slotsCompleted = false;
            boolean attributeBookCompleted = false;

            int weaponsInFile = Integer.parseInt(s.nextLine());
            Random intRandom = new Random();
            int skipLines = intRandom.nextInt(weaponsInFile);
            for(int i = 0; i < skipLines; i++) {
                s.nextLine();
            }

            String name = s.next();

            while(!slotsCompleted) {
                String next = s.next();
                if (!next.equals(",")) {
                    slots.add(next);

                } else {
                    slotsCompleted = true;
                }
            }
            while(!attributeBookCompleted) {
                String next = s.next();
                if (!next.equals(",")) {
                    attributeBook.add(new BaseAttribute(1, next, Integer.parseInt(s.next()), 1.0));

                } else {
                    attributeBookCompleted = true;
                }
            }
            String description = s.nextLine();

            return new Weapon(statMod, matMod, name, slots, attributeBook, description);
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        System.out.println("Failed to read and create Weapon in txtReader");
        return null;
    }

    //String prefix, String name, Double multiplier, String slot, int price, int weight, int speed, int damage, int stamina, int spellDamage, int charisma, int effectChance, int hpReg, int mpReg, int armor, int resistance, int maxHp, int maxMp) {




    public static HashMap<String, Trait> generateTraitRegister(File file) {

        HashMap<String,Trait> traitMap= new HashMap<>();
        try  {
           // private static Pattern p = Pattern.compile("(\\w*)\\s*(\\w*)\\s*(-?\\d*.\\d*)");
            Scanner s = new Scanner(file);
            int traitsInFile = Integer.parseInt(s.nextLine());

            for(int i = 0; i < traitsInFile; i++) {
                String name = s.next();
                String attrName1 = s.next();
                Double mod1 = Double.parseDouble(s.next());
                String attrName2 = s.next();
                Double mod2 = Double.parseDouble(s.next());
                String description = s.nextLine();
                traitMap.put(name, new BaseTrait(name, attrName1, mod1, attrName2, mod2, description));
                Library.put(name, description);
            }
            return traitMap;
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        System.out.println("Failed to read and crate traitMap in txtReader");
        return null;
    }

    public static HashMap<String, Race> generateRaceRegister(File file) {

        HashMap<String,Race> raceMap= new HashMap<>();
        try  {
            Scanner s = new Scanner(file);
            int racesInFile = Integer.parseInt(s.nextLine());

            for(int i = 0; i < racesInFile; i++) {
                String name = s.next();
                String article = s.next();
                int strength = Integer.parseInt(s.next());
                int endurance = Integer.parseInt(s.next());
                int knowledge = Integer.parseInt(s.next());
                int perception = Integer.parseInt(s.next());
                int mentality = Integer.parseInt(s.next());
                int hardening = Integer.parseInt(s.next());
                int improvisation = Integer.parseInt(s.next());
                String description = s.nextLine();
                raceMap.put(name, new BaseRace(name, article, strength, endurance, knowledge, perception, mentality, hardening, improvisation, description));
                Library.put(name, description);
           }
            return raceMap;
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        System.out.println("Failed to read and crate raceMap in txtReader");
        return null;
    }

    public static HashMap<String, Profession> generateProfessionRegister(File file) {

        HashMap<String,Profession> professionMap= new HashMap<>();
        try  {
            Scanner s = new Scanner(file);
            int professionsInFile = Integer.parseInt(s.nextLine());

            for(int i = 0; i < professionsInFile; i++) {
                String name = s.next();
                String article = s.next();
                Double strength = Double.parseDouble(s.next());
                Double endurance = Double.parseDouble(s.next());
                Double knowledge = Double.parseDouble(s.next());
                Double perception = Double.parseDouble(s.next());
                Double mentality = Double.parseDouble(s.next());
                Double hardening = Double.parseDouble(s.next());
                Double improvisation = Double.parseDouble(s.next());
                String perkName = s.next();
                String description = s.nextLine();
                professionMap.put(name, new BaseProfession(name, article, strength, endurance, knowledge, perception, mentality, hardening, improvisation, perkName, description));
                Library.put(name, description);
            }
            return professionMap;
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        System.out.println("Failed to read and crate professionMap in txtReader");
        return null;
    }



}
