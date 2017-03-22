package Main.Game.Team.Item;


import Main.Game.Team.Item.Items.Food;
import Main.Game.Team.Item.Items.Weapon;
import Main.Game.Utility.FileHandler.TxtReader;

import java.io.File;
import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> inventory;

    public Inventory() {
        this.inventory = new ArrayList<>();
        this.inventory.add(TxtReader.generateWeapon(new File("D:/RPG_Java/src/main/resources/Items/swords.txt"), 1.0, 1.0));
        //Todo add consumable
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
            System.out.println("Item:" + item + " has not been removed because it is not in this getInventory");
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

    public  Consumable getConsumables(String name) {
        for(Item item: inventory) {
            if(item instanceof Consumable) {
                if (item.toString().equals(name)) {
                    return (Consumable)item;
                }
            }
        }
        return null;
    }

    public  Equipable getEquipables(String name) {
        for(Item item: inventory) {
            if(item instanceof Equipable) {
                if (item.toString().equals(name)) {
                    return (Equipable)item;
                }
            }
        }
        return null;
    }


    public String consumablesToString() {
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

    public String equipablesToString() {
        String string = "";
        int index = 1;
        for(Item item : inventory) {
            if(item instanceof Equipable) {
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
