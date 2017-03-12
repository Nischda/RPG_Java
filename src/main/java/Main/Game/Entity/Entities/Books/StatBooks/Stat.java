package Main.Game.Entity.Entities.Books.StatBooks;


public abstract class Stat {

    public abstract int get();
    public abstract void addMod( double value);
    public abstract void add( int value);
    public abstract void addEquipment(int value);
    public abstract void resetEquipment();
    public abstract String toString();

}
