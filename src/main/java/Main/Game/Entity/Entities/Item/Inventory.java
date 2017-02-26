package Main.Game.Entity.Entities.Item;


import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> inventory;

    public Inventory() {
        this.inventory = new ArrayList<>();
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

    public String toString() {
        return inventory.toString();
    }

}
