package Main.Game.Team.Entity.Components.Books.ProfessionBooks;


import java.util.ArrayList;
import java.util.Arrays;

public class BaseProfession extends Profession {

    private String name;
    private String article;
    private ArrayList<Double> modList;
    private String perkName;
    private String description;

    public BaseProfession(String name, String article, Double strengthMod, Double enduranceMod, Double knowledgeMod, Double perceptionMod, Double mentalityMod, Double hardeningMod, Double improvisationMod, String perkName, String description) {
        modList = new ArrayList<>(Arrays.asList(strengthMod, enduranceMod, knowledgeMod, perceptionMod, mentalityMod, hardeningMod, improvisationMod));
        this.name = name;
        this.article = article;
        this.perkName = perkName;
        this.description = description;
    }

    @Override
    public ArrayList<Double> getMods() {
        return modList;
    }
    @Override
    public String getPerkName() {
        return perkName;
    }

    @Override
    public void printDescription() {
        System.out.println(this.description);
    }

    @Override
    public String toString() {
        return name;
    }
}
