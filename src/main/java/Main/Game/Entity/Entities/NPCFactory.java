package Main.Game.Entity.Entities;


import Main.Game.Entity.Entities.RaceLists.Race;
import Main.Game.Entity.Entities.TraitLists.CustomTraitList;
import Main.Game.Entity.Entities.TraitLists.Trait;
import Main.Game.Entity.Entities.ProfessionLists.Profession;
import Main.Game.Entity.Entity;
import Main.Game.TxtReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public final class NPCFactory {

    public static ArrayList<Entity> createNPCs(File file, int npcCount, int traitCount) {

            ArrayList<Entity> npcList = new ArrayList<>();
            for(int i = 0; i < npcCount; i++) {
                Entity npc = TxtReader.generateNPC(file, traitCount);
                npcList.add(npc);
            }
            return npcList;
        }
}