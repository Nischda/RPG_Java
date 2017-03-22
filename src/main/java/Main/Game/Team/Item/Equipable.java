package Main.Game.Team.Item;

import Main.Game.Team.Entity.Entity;

import java.util.ArrayList;

public interface Equipable {

    public void equip(Entity entity);

    public int getStatValue(String name);
    public ArrayList<String> getSlots();
}