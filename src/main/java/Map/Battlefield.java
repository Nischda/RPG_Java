package Map;

import Entities.Entity;

import java.util.*;


public class Battlefield{
    private Scanner in = new Scanner(System.in);
    private ArrayList<Entity> entities1;
    private ArrayList<Entity> entities2;

    public Battlefield(ArrayList<Entity> entities1, ArrayList<Entity> entities2) {
        this.entities1 = entities1;
        this.entities2 = entities2;

        executeRound();
    }

    public void executeRound() {
        boolean battleEnd = false;
        while(!battleEnd) {
            sortEntities(entities1);
            sortEntities(entities2);
            if(entities1.get(0).getEndurance() >= entities2.get(0).getEndurance()) {
                executePlayerTurn(entities1.get(0));
                Collections.rotate(entities1, -1);
            }
            else {
                executeNPCTurn(entities2.get(1));
                Collections.rotate(entities2, -1);
            }
        }
    }

    public void executePlayerTurn(Entity entity) {
        System.out.println("Your turn: " + entity.toString());
        System.out.println("What do you want to do?");
        String input = in.nextLine().toUpperCase();
        System.out.println("Nothing has been done");
    }

    public void executeNPCTurn(Entity entity) {
        System.out.println("Turn of: " + entity.toString());
    }

    private void sortEntities(ArrayList<Entity> entities) {
        Collections.sort(entities, new Comparator<Entity>() {
            @Override public int compare(Entity e1, Entity e2) {
                return e1.getEndurance()- e2.getEndurance();
            }
        });
    }


}
