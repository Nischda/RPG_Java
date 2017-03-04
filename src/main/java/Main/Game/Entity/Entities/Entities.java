package Main.Game.Entity.Entities;


import Main.Game.Entity.Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Entities implements Iterable<Entity> {
    private ArrayList<Entity> entities;

    public Entities() {
        this.entities = new ArrayList<>();
    }
    public Entities(Entity entity) {
        this.entities = new ArrayList<>();
        this.entities.add(entity);
    }

    public void add(Entity entity) {
        this.entities.add(entity);
    }
    public Entity get(int index) {
        return entities.get(index);
    }

    public int size() {
        return entities.size();
    }
    public void rotate(int index) {
        Collections.rotate(entities, index);
    }

    @Override
    public Iterator<Entity> iterator() {
        return new Iterator<Entity>() {
            private final Iterator<Entity> iter = entities.iterator();

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public Entity next() {
                return iter.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("no changes allowed");
            }
        };
    }
    public void sortEntities() {
        Collections.sort(entities, new Comparator<Entity>() {
            public int compare(Entity e1, Entity e2) {
                return e1.getEndurance() - e2.getEndurance();
            }
        });
    }


    public void item() {
        System.out.println("Which item do you want to use?");
        System.out.println(this.entities.toString());
    }

    public void printEntities() {
        StringBuilder string = new StringBuilder();
        int count = 1;
        for (Entity entity : entities) {
            string.append(count + ". " + entity.toString());
            count++;
        }
        System.out.println(string.toString());
    }

}


