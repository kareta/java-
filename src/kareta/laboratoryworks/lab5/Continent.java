package kareta.laboratoryworks.lab5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class Continent {

    private ArrayList<TerritorialDivision> history;
    private String name;

    public Continent(String name) {
        history = new ArrayList<TerritorialDivision>();
        this.name = name;
    }

    private Comparator<TerritorialDivision> divisionComparator = new Comparator<TerritorialDivision>() {
        @Override
        public int compare(TerritorialDivision firstDivision, TerritorialDivision secondDivision) {
            return firstDivision.existencePeriod.compareTo(secondDivision.existencePeriod);
        }
    };

    public void addTeritorialDivision(String name, Date begin, Date end) {
        TerritorialDivision territorialDivision = new TerritorialDivision(name, begin, end);
        history.add(territorialDivision);
        history.sort(divisionComparator);
    }

    public TerritorialDivision getDivision(String name) {
        for (TerritorialDivision territorialDevision : history) {
            if (territorialDevision.getName().equals(name)) {
                return territorialDevision;
            }
        }
        return null;
    }

    public void addCountry(String name, Country country) {
        for (TerritorialDivision territorialDevision : history) {
            if (territorialDevision.getName().equals(name)) {
                territorialDevision.addCountry(country);
            }
        }
    }

    public class TerritorialDivision {
        private ArrayList<Country> countries = new ArrayList<Country>();
        private Period existencePeriod;
        private String name;

        public TerritorialDivision(String name, Period existencePeriod) {
            this.name = name;
            this.existencePeriod = existencePeriod;
        }

        public TerritorialDivision(String name, Date begin, Date end) {
            this.name = name;
            this.existencePeriod = new Period(begin, end);
        }

        public String getName() {
            return name;
        }

        public void addCountry(Country country){
            country.addTerritorialDivision(this);
            countries.add(country);
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();

            builder.append("Territorial division " + name + " " + existencePeriod + "\n");
            for (Country country : countries) {
                builder.append(country + ", ");
            }
            builder.append("\n");
            return builder.toString().trim();
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Continent " + name + "\n");
        for (TerritorialDivision division : history) {
            builder.append(division + "\n");
        }
        builder.append("\n");
        return builder.toString().trim();
    }
}
