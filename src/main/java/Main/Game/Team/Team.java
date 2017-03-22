package Main.Game.Team;


import Main.Game.Team.Item.Consumable;
import Main.Game.Team.Item.Equipable;
import Main.Game.Team.Item.Inventory;
import Main.Game.Team.Item.Item;
import Main.Game.Team.Entity.Entity;
import Main.Game.Utility.Input.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Team implements Iterable<Entity> {
    private ArrayList<Entity> team;
    private Inventory inventory;
    private String name;

    public Team(String name) {
        this.name = name;
        this.team = new ArrayList<>();
        this.inventory = new Inventory();
    }

    public String getName() {
        return this.name;
    }
    public Inventory getInventory() {
        return this.inventory;
    }

    public Entity get(int index) {
        return team.get(index);
    }


    public void add(Entity entity) {
        this.team.add(entity);
        entity.addTeam(this);
    }

    public int size() {
        return team.size();
    }

    public void rotate(int index) {
        Collections.rotate(team, index);
    }

    public void sortTeam() {
        Collections.sort(team, new Comparator<Entity>() {
            public int compare(Entity e1, Entity e2) {
                return e1.getStatValue("endurance") - e2.getStatValue("endurance");
            }
        });
    }

    @Override
    public Iterator<Entity> iterator() {
        return new Iterator<Entity>() {
            private final Iterator<Entity> iter = team.iterator();

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


    public void useItem() { //Todo Check if items exist and add step back
        boolean validAction = false;

        while (!validAction) {
            System.out.println("Which item do you want to use?");
            System.out.println(this.inventory.consumablesToString());
            String itemName = Console.getStringInput();

            if (inventory.contains(itemName)) {
                Consumable consumable = getInventory().getConsumables(itemName);
                consumable.use(selectEntity());
                getInventory().remove((Item)consumable); // Todo Garbagecollector?
                validAction = true;
            }
            else {
                System.out.println("You can't do that");
                validAction = false;
            }
        }
    }

    public void equipItem() {
        boolean validAction = false;

        while (!validAction) {
            System.out.println("Which item do you want to equip? (name/none)");
            System.out.println(this.inventory.equipablesToString());
            String input = Console.getStringInput();

            if (inventory.contains(input)) {
               Equipable equipable = getInventory().getEquipables(input);
                equipable.equip(selectEntity());
                getInventory().remove((Item)equipable); // Todo Garbagecollector? readd to inventory on unequip
                validAction = true;
            }
            else if(input.equals("none")) {
                System.out.println("Nothing has been equiped");
            }
            else {
                System.out.println("You can't do that");
                validAction = false;
            }
        }
    }

    public Entity selectEntity() {
        boolean validInput = false;

        while (!validInput) {//Todo simplify
            System.out.println("Select a target");
            printTeam();
            int target = Console.getIntegerInput()-1;

            if (target > 0 && target < team.size()) {
                return team.get(target);
            }
            else {
                System.out.println("Try again");
            }
        }
        System.out.println("Valid entity has not been selected");
        return null;
    }

    public void printTeam() {
        StringBuilder string = new StringBuilder();
        int count = 1;
        for (Entity entity : team) {
            string.append(count + ". " + entity.toString());
            count++;
        }
        System.out.println(string.toString());
    }

    @Override
    public String toString() {
        String string = "";
        int index = 1;
        for(Entity entity : team) {
            string += index + ". " + entity.toString() + "\n";
            index++;
        }
        return string;
    }

}


