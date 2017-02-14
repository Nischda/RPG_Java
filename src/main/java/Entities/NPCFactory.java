package Entities;


import Entities.ProfessionLists.Profession;
import Entities.RaceLists.Race;
import Entities.TraitLists.CustomTraitList;
import Entities.TraitLists.Trait;

import java.util.ArrayList;

public final class NPCFactory {

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
        String name = "Bob";
        return name;
    }
    public static Profession chooseProfession() {
        Profession profession = Profession.getProfession("DUELIST");
        return profession;
    }
    public static Race chooseRace() {
        Race race = Race.getRace("DWARF");
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
        Trait trait = Trait.getTrait("CURSED");
        return trait;
    }

}