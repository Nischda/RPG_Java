package Main.Game.Entity.Entities.Books.StatBooks;


import Main.Game.Entity.Entities.Books.StatBooks.Stat;

public class baseStat extends Stat {

    private String name;
    private int baseValue;
    private double mod = 1;
    private int value;

    private int equipmentValue;

    public baseStat(String name, int value, Double mod) {
        this.name = name;
        this.baseValue = value;
        this.mod += mod;
        update();
    }

    @Override
    public int get() {
        return value;
    }
    @Override
    public String getString() {
        return Integer.toString(value);
    }

    @Override
    public void add( int value) {
        baseValue += value;
        update();
    }

    @Override
    public void addMod( double value) {
        mod += value;
        update();
    }

    @Override
    public void addEquipment(int value) {
        equipmentValue += value;
    }

    @Override
    public void resetEquipment() {
        equipmentValue = 0;
    }

    @Override
    public String toString() {
        return name;
    }

    private void update() {
        value = (int)(baseValue * mod) + equipmentValue;
    }
}
