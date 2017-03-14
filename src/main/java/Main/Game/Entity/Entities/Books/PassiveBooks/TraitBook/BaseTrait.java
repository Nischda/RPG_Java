package Main.Game.Entity.Entities.Books.PassiveBooks.TraitBook;

import Main.Game.Entity.Entities.Books.PassiveBooks.TraitBook.Trait;
import Main.Game.Entity.Entity;

import java.util.HashMap;

public class BaseTrait extends Trait {

    private String name;
    private String description;
    private String attrName1;
    private String attrName2;
    private Double mod1;
    private Double mod2;

    public BaseTrait(String name, String attrName1, Double mod1, String attrName2, Double mod2, String description) {
        this.name = name;
        this.attrName1 = attrName1;
        this.attrName2 = attrName2;
        this.mod1 = mod1;
        this.mod2 = mod2;
        this.description = description;
    }
    @Override
    public void printDescription() {
        System.out.println(description);
    }

    @Override
    public void initializeTrait(Entity entity) {
        entity.addToStatMod(attrName1, mod1);
        entity.addToStatMod(attrName2, mod2);
    }

    public String toString() {
        return name;
    }
}
