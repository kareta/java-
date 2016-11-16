package kareta.laboratoryworks.lab5;

import kareta.consoleui.Controller;
import kareta.consoleui.ViewRenderer;
import kareta.laboratoryworks.lab5.ui.views.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class MainController extends Controller {

    private ViewRenderer viewRenderer = new ViewRenderer();
    private HashMap<String, Continent> continents = new HashMap<>();
    private HashMap<String, Country> countries = new HashMap<>();

    public MainController() {
        super(new MainView());
    }

    @Override
    public boolean runChoice(String choice) {
        boolean exit = false;
        switch (choice)
        {
            case "1":
                addContinent();
                break;
            case "2":
                addCountry();
                break;
            case "3":
                addDivision();
                break;
            case "4":
                allContinents();
                break;
            case "5":
                addTerritorialDivisionCountry();
                break;
            case "6":
                //allDivisions();
                break;
            case "7":
                exit = true;
                break;
        }
        return exit;
    }

    public void addContinent() {
        try {
            String continentName = viewRenderer.run(new AddContinentView());
            continents.put(continentName, new Continent(continentName));
        } catch (Exception e) {

        }

    }

    public void addCountry() {
        try {
            String countryName = viewRenderer.run(new AddCountryView());
            countries.put(countryName, new Country(countryName));
        } catch (Exception e) {

        }
    }

    public void addDivision() {
        try {
            String result = viewRenderer.run(new AddDivisionView());
            String[] splittedResult = result.split(" ");
            if (splittedResult.length == 4) {
                String continentName = splittedResult[0];
                Continent continent = continents.get(continentName);
                String divisionName = splittedResult[1];
                Date beginDate = new Date(splittedResult[2]);
                Date endDate = new Date(splittedResult[3]);
                continent.addTeritorialDivision(divisionName, beginDate, endDate);
            }
        } catch (Exception e) {

        }
    }

    public void allContinents() {
        StringBuilder builder = new StringBuilder();
        for (Continent continent : continents.values()) {
            builder.append("\n" + continent.toString());
        }

        try {
            viewRenderer.run(new AllContinentsView(builder.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addTerritorialDivisionCountry() {
        try {
            String result = viewRenderer.run(new AddTerritorialDivisionCountryView());
            String[] splittedResult = result.split(" ");
            if (splittedResult.length == 3) {
                String continentName = splittedResult[0];
                Continent continent = continents.get(continentName);
                String divisionName = splittedResult[1];
                Continent.TerritorialDivision division = continent.getDivision(divisionName);
                String countryName = splittedResult[2];
                Country country = countries.get(countryName);
                division.addCountry(country);
            }

        } catch (Exception e) {

        }
    }
}
