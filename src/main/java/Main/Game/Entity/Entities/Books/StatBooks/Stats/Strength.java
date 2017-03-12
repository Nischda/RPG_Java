package Main.Game.Entity.Entities.Books.StatBooks.Stats;


import Main.Game.Entity.Entities.Books.StatBooks.Stat;

public class Strength extends Stat {

    private int baseStrength;
    private int strength;
    private double strengthMod = 1;

    private int equipmentStrength;

    public Strength (int value) {
        this.baseStrength = value;
        update();
    }

    @Override
    public int get() {
        return strength;
    }

    @Override
    public void add( int value) {
        baseStrength += value;
        update();
    }

    @Override
    public void addMod( double value) {
        strengthMod += value;
        update();
    }

    @Override
    public void addEquipment(int value) {
        equipmentStrength += value;
    }

    @Override
    public void resetEquipment() {
        equipmentStrength = 0;
    }

    @Override
    public String toString() {
        return Integer.toString(strength);
    }

    private void update() {
        strength = (int)(baseStrength * strengthMod) + equipmentStrength;
    }
}
