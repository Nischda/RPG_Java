package Main.Game.Entity.Entities.Item;


import Main.Game.Entity.Entities.Book.Books.Ability;
import Main.Game.Entity.Entities.Item.Items.Fruit;
import Main.Game.Entity.Entities.Item.Items.Sword;

import java.util.ArrayList;
import java.util.Arrays;

public class Inventory {

    private ArrayList<Item> inventory;

    public Inventory() {
        this.inventory = new ArrayList<>();
        this.inventory.add(new Sword("rusty sword", 23, 4, 27, 8, new ArrayList<String>(Arrays.asList("weapon"))));
        this.inventory.add(new Fruit("apple", 1, 10, 5, 1, new ArrayList<String>(Arrays.asList("weapon"))));
    }

    public void add(Item item) {
        this.inventory.add(item);
    }

    public boolean include(Item item) {
            return inventory.contains(item);
    }

    public boolean contains(String string) { //ToDo simplify this and getAbility/include
        Item item = this.getItem(string);
        if(item != null) {
            return this.include(item);
        }
        return false;
    }

    public void remove(Item item) {
        if(this.include(item)) {
            this.inventory.remove(item);
        }
        else {
            System.out.println("Item:" + item + " has not been removed because it is not in this inventory");
        }
    }

    public  Item getItem(String name) {
        for(Item item: inventory) {
            if (item.toString().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public String ConsumablestoString() {
        String string = "";
        int index = 1;
        for(Item item : inventory) {
            if(item instanceof Consumable) {
                string += index + ". " + item.toString() + "\n";
                index++;
            }
        }
        return string;
    }

    @Override
    public String toString() {
        String string = "";
        int index = 1;
        for(Item item : inventory) {
            string += index + ". " + item.toString() + "\n";
            index++;
        }
        return string;
    }

}
