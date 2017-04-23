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
        Collections.sort(team, Comparator.comparingInt(e -> e.getStatValue("endurance")));
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
            System.out.println("Which item do you want to use? (index/none)");
            System.out.println(this.inventory.consumablesToString());
            Console.input();
            if(Console.gotBuffer()) {
                String input =Console.getBuffer(); //ToDo make safe

                if(input.equals("none")) {
                    System.out.println("Nothing has been used");
                    validAction = true;
                }
                else if(Console.isInteger(input)){
                    Item item = inventory.getItem(Integer.parseInt(input)-1);
                    if(item instanceof Consumable) {
                        Consumable consumable = (Consumable) item;
                        consumable.use(selectEntity());
                        getInventory().remove((Item) consumable); // Todo Garbagecollector? readd to inventory on unequip
                        validAction = true;
                    }
                }
                else {
                    System.out.println("You can't do that");
                }
            }
        }
    }

    public void equipItem() {
        boolean validAction = false;

        while (!validAction) {
            System.out.println("Which item do you want to equip? (index/none)");
            System.out.println(this.inventory.equipablesToString());
            Console.input();
            if(Console.gotBuffer()) {
                String input =Console.getBuffer(); //ToDo make safe

                if(input.equals("none")) {
                    System.out.println("Nothing has been equiped");
                    validAction = true;
                }
                else if(Console.isInteger(input)) {
                    int intInput = Integer.parseInt(input)-1;
                    if (intInput >= 0 && intInput < inventory.equipSize()){
                        Equipable equipable = inventory.getEquipable(intInput);
                        equipable.equip(selectEntity());
                        inventory.removeEquipable(intInput);
                        validAction = true;
                    }
                    else {
                        System.out.println("No Equipment on that slot.");
                    }
                }
                else {
                    System.out.println("You can't do that");
                }
            }
        }
    }

    public Entity selectEntity() {
        while (true) {
            System.out.println("Select a target");
            printTeam();
            int target = Console.intInput()-1;

            if (target >= 0 && target < team.size()) {
                return team.get(target);
            }
            else {
                System.out.println("Try again");
            }
        }
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


