package Main.Game.Entity.Entities;


import Main.Game.Entity.Entities.RaceLists.Race;
import Main.Game.Entity.Entities.TraitLists.CustomTraitList;
import Main.Game.Entity.Entities.TraitLists.Trait;
import Main.Game.Entity.Entities.ProfessionLists.Profession;
import Main.Game.Entity.Entity;

import java.util.ArrayList;
import java.util.Random;

public final class NPCFactory {
    private static String[] names = {"Karl","Günther","Johann","Steve","Pete","Jeff","Glumbar","Kniggara","Gilber,","Brick"};

    public static ArrayList<Entity> createNPCs(int npcCount, int traitCount) {

            ArrayList<Entity> npcList = new ArrayList<>();
            for(int i = 0; i < npcCount; i++) {
                Entity npc = createNPC(traitCount);
                npcList.add(npc);
            }
            return npcList;
        }

    public static Entity createNPC(int traitCount) {
        String name = chooseName();
        Profession profession = chooseProfession();
        Race race = chooseRace();
        CustomTraitList traitList = chooseTraits(traitCount);

        Entity npc = new NPC( name, profession, race, traitList);
        return npc;
    }

    public static String chooseName() {
        Random intRandom = new Random();
        int rand = intRandom.nextInt(names.length -1);
        return names[rand];
    }
    public static Profession chooseProfession() {
        Profession profession = Profession.getProfession("duelist");
        return profession;
    }
    public static Race chooseRace() {
        Race race = Race.getRace("dwarf");
        return race;
    }
    public static CustomTraitList chooseTraits(int traitCount) {
        CustomTraitList customTraitList = new CustomTraitList();
        for(int i = 0; i <traitCount; i++) {
            Trait trait = chooseTrait();
            customTraitList.addToList(trait);
        }
        return customTraitList;
    }

    public static Trait chooseTrait() {
        Trait trait = Trait.getTrait("cursed");
        return trait;
    }

}