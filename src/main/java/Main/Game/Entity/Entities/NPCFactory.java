package Main.Game.Entity.Entities;


import Main.Game.Entity.Entity;
import Main.Game.TxtReader;

import java.io.File;
import java.util.ArrayList;

public final class NPCFactory {

    public static Entities createNPCs(File file, int npcCount, int traitCount) {

            Entities npcList = new Entities("EnemyTeam");
            for(int i = 0; i < npcCount; i++) {
                Entity npc = TxtReader.generateNPC(file, traitCount);
                npcList.add(npc);
            }
            return npcList;
        }
}