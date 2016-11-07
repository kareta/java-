package kareta.laboratoryworks.lab5;

import java.util.ArrayList;

public class Country {
    private String name;
    private ArrayList<Continent.TerritorialDivision> divisions;

    public Country(String name) {
        this.name = name;
    }

    public ArrayList<Continent.TerritorialDivision> getTerritorialDivisions() {
        return divisions;
    }

    public void addTerritorialDivision(Continent.TerritorialDivision division) {
        divisions.add(division);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
