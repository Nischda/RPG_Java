package Main.Game;

import Main.Game.Entity.Entities.Books.PassiveBooks.TraitBook.Trait;
import Main.Game.Entity.Entities.Books.PassiveBooks.TraitBook.TraitBook;
import Main.Game.Entity.Entities.NPC;
import Main.Game.Entity.Entities.ProfessionLists.Profession;
import Main.Game.Entity.Entities.RaceLists.Race;
import Main.Game.Entity.Entity;
import Main.Game.Entity.Map.TileLists.Tile;
import Main.Game.Entity.Map.TileLists.Tiles.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TxtReader {

    public static ArrayList<ArrayList<Tile>> generateMap() {
        ArrayList<ArrayList<Tile>> map = new ArrayList<>();

        try  {
            Scanner s = new Scanner(new File("D:/RPG_Java/src/main/java/Main/Resources/map.txt"));
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

    public static Entity generateNPC(File file, int traitCount) {

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
            TraitBook traits = chooseTraits(traitCount);
            //System.out.println(name + " " + profession + " " + race + " " + traits);
            return new NPC(name, profession, race, traits);
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        return new NPC("FailedToCreateNPC", Profession.getProfession("Duelist"), Race.getRace("Dwarf"), chooseTraits(traitCount));
    }

    public static TraitBook chooseTraits(int traitCount) {
        TraitBook traitBook = new TraitBook();
        for(int i = 0; i <traitCount; i++) {
            Trait trait = chooseTrait();
            traitBook.add(trait);
        }
        return traitBook;
    }

    public static Trait chooseTrait() {
        Trait trait = Trait.getTrait("cursed");
        return trait;
    }



}
