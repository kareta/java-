package kareta.laboratoryworks.lab5;

import kareta.consoleui.Controller;
import kareta.consoleui.ViewRenderer;
import kareta.laboratoryworks.lab5.ui.views.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;


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
                allCountries();
                break;
            case "6":
                addTerritorialDivisionCountry();
                break;
            case "7":
                findTerritorialDivisions();
                break;
            case "8":
                exit = true;
                break;
        }
        return exit;
    }

    private void findTerritorialDivisions() {

        try {
            String countryName = viewRenderer.run(new FindTerritorialDivisionView());
            Country country = countries.get(countryName);
            StringBuilder builder = new StringBuilder();
            if (country == null) {
                return;
            }
            for (Continent.TerritorialDivision division : country.getDivisions()) {
                if (division != null) {
                    builder.append(division.toString());
                }

            }
            builder.append("\n");
            viewRenderer.run(new FoundDivisionsView(builder.toString()));
        } catch (IOException e) {
            //write to logger
            e.printStackTrace();
        }
    }

    public void addContinent() {
        try {
            String continentName = viewRenderer.run(new AddContinentView());
            continents.put(continentName, new Continent(continentName));
        } catch (Exception e) {
            //write to logger
            e.printStackTrace();
        }

    }

    public void addCountry() {
        try {
            String countryName = viewRenderer.run(new AddCountryView());
            countries.put(countryName, new Country(countryName));
        } catch (Exception e) {
            //write to logger
            e.printStackTrace();
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

                DateFormat format =
                        new SimpleDateFormat("yyyy/mm/dd");

                Date begin = format.parse(splittedResult[2]);
                Date end = format.parse(splittedResult[3]);

                continent.addTeritorialDivision(divisionName, begin, end);
                continent.toString();
            }
        } catch (Exception e) {
            //write to logger
            e.printStackTrace();
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
            //write to logger
            e.printStackTrace();
        }
    }

    public void allCountries() {
        StringBuilder builder = new StringBuilder();
        for (Country country : countries.values()) {
            builder.append("\n" + country.toString());
        }

        try {
            viewRenderer.run(new AllCountriesView(builder.toString()));
        } catch (IOException e) {
            //write to logger
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
                String countryName = splittedResult[2];
                Country country = countries.get(countryName);
                continent.addCountry(divisionName, country);
            }

        } catch (Exception e) {
            //write to logger
            e.printStackTrace();
        }
    }
}
