package Main.Game.Entity.Entities.Item;


import Main.Game.Entity.Entities.Item.Items.Fruit;

import java.util.ArrayList;
import java.util.Arrays;

public class Inventory {

    private ArrayList<Item> inventory;

    public Inventory() {
        this.inventory = new ArrayList<>();
        this.inventory.add(new Fruit("Apple", 1, 10, 5, 1, new ArrayList<String>(Arrays.asList("weapon"))));
    }

    public void add(Item item) {
        this.inventory.add(item);
    }

    public boolean includes(Item item) {
            if(inventory.contains(item)) return true;
            return false;
    }

    public void remove(Item item) {
        if(this.includes(item)) {
            this.inventory.remove(item);
        }
        else {
            System.out.println("Item:" + item + " has not been removed because it is not in this inventory");
        }
    }

    @Override
    public String toString() {
        String string = "";
        for(Item item : inventory) {
            string += item.toString() + ", ";
        }
        return string.substring(0, string.length()-2);
    }

}
