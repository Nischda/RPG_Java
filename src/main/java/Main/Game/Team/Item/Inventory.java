package Main.Game.Team.Item;


import Main.Game.Team.Entity.Components.Books.AttributeBooks.AttributeBook;
import Main.Game.Team.Item.Items.Food;
import Main.Game.Team.Item.Items.Weapon;
import Main.Game.Utility.FileHandler.TxtReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Inventory {

    private ArrayList<Item> inventory;
    private ArrayList<Equipable> equipList;

    public Inventory() {
        this.inventory = new ArrayList<>();
        this.equipList = new ArrayList<>();
        Weapon weapon = TxtReader.generateWeapon(new File("D:/RPG_Java/src/main/resources/Items/swords.txt"), 1.0, 1.0);
        this.inventory.add(weapon);
        this.equipList.add(weapon);
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

    public Item getItem(int index){
        if(index >= 0 && index < inventory.size())
        return inventory.get(index);
        else {
            return null;
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

    public  String equipablesToString() {
        String string = "";
        int index = 1;
        for(Equipable equip: equipList) {
                string += String.format("%s: %s",index, equip.toString());
                        index++;
        }
        return string;
    }

    public  Equipable getEquipable(int index) {
            return equipList.get(index);
    }

    public void removeEquipable(int index) {
        equipList.remove(index);
        inventory.remove(index);
    }

    public int equipSize() {
        return equipList.size();
    }


    public String consumablesToString() {
        String string = "";
        int index = 1;
        for(Item item : inventory) {
            if(item instanceof Consumable) {
                string += index + ". " + item.toString() + "\n";
                index++;
            }
            else {
                index += 1;
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
