package Main.Game;

import Main.Game.Entity.Map.TileLists.Tile;
import Main.Game.Entity.Map.TileLists.Tiles.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TxtReader {

    public ArrayList<ArrayList<Tile>> generateMap() {
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
}
