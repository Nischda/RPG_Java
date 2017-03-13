package Main.Game.Entity.Entities.Books.AttributeBooks;


import Main.Game.Entity.Entities.Books.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class AttributeBook extends Book<Attribute> implements Calculateable{ //Todo not yet adjusted in any kind of way

    private HashMap<String, Attribute> attributeMap;

    public AttributeBook(ArrayList<Integer> attributes, ArrayList<Double> mods) {
        attributeMap = new HashMap<>();

        attributeMap.put("strength", new BaseAttribute(1, "strength", attributes.get(0), mods.get(0)));
        attributeMap.put("endurance", new BaseAttribute(1, "endurance", attributes.get(1), mods.get(1)));
        attributeMap.put("knowledge", new BaseAttribute(1, "knowledge", attributes.get(2), mods.get(2)));
        attributeMap.put("perception", new BaseAttribute(1, "perception", attributes.get(3), mods.get(3)));
        attributeMap.put("mentality", new BaseAttribute(1, "mentality", attributes.get(4), mods.get(4)));
        attributeMap.put("hardening", new BaseAttribute(1, "hardening", attributes.get(5), mods.get(5)));
        attributeMap.put("improvisation", new BaseAttribute(1, "improvisation", attributes.get(6), mods.get(6)));

        attributeMap.put("damage", new BaseAttribute(1, "damage", this.getValue("strength"), 1.0));
        attributeMap.put("spellDamage", new BaseAttribute(1, "spellDamage", this.getValue("knowledge"), 1.0));
        attributeMap.put("speed", new BaseAttribute(1, "speed", this.getValue("endurance"), 1.0));
        attributeMap.put("agility", new BaseAttribute(1, "agility", this.getValue("endurance"), 1.0));
        attributeMap.put("charisma", new BaseAttribute(1, "charisma", this.getValue("perception"), 1.0));
        attributeMap.put("effectChance", new BaseAttribute(1, "effectChance", this.getValue("perception"), 1.0));
        attributeMap.put("hpReg", new BaseAttribute(1, "hpReg", this.getValue("mentality"), 1.0));
        attributeMap.put("mpReg", new BaseAttribute(1, "mpReg", this.getValue("mentality"), 1.0));
        attributeMap.put("armor", new BaseAttribute(1, "armor", this.getValue("hardening"), 1.0));
        attributeMap.put("resistance", new BaseAttribute(1, "resistance", this.getValue("hardening"), 1.0));
        attributeMap.put("maxHp", new BaseAttribute(1, "maxHp", this.getValue("strength"), 1.0));
        attributeMap.put("maxMp", new BaseAttribute(1, "maxMp", this.getValue("knowledge"), 1.0));
    }

    @Override
    public void add(Attribute attribute) {
        attributeMap.put(attribute.toString(), attribute);
    }

    @Override
    public void remove(Attribute attribute) {
        if(attributeMap.containsKey(attribute.toString())) {
            attributeMap.remove(attribute.toString());
        }
    }

    @Override
    public boolean include(Attribute attribute) {
        return attributeMap.containsKey(attribute.toString());
    }

    @Override
    public boolean contains(String name) { //ToDo simplify this and getAttribute/include
            return attributeMap.containsKey(name);
    }

    @Override
    public Attribute get(String name) {
        if (this.contains(name)) {
            return attributeMap.get(name);
        }
        return null;
    }

    @Override
    public int getValue(String name) {
        return this.get(name).get();
    }

    @Override
    public Attribute getRandom() {
        Random intRandom = new Random();
        return attributeMap.get(intRandom.nextInt(attributeMap.size()));
    }

    @Override
    public void printBook() {
        System.out.println(attributeMap.toString());
    }

    @Override
    public String toString() {
        String string = "";
        for(Attribute attribute : attributeMap.values()) {
            string += attribute.toString() + ": " + attribute.getString() + ",";
        }
        return string.substring(0, string.length()-2);
    }
}
