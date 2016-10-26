package kareta.laboratoryworks.lab5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class Continent {

    private ArrayList<TerritorialDivision> history;

    private Comparator<TerritorialDivision> divisionComparator = new Comparator<TerritorialDivision>() {
        @Override
        public int compare(TerritorialDivision firstDivision, TerritorialDivision secondDivision) {
            return firstDivision.existencePeriod.compareTo(secondDivision.existencePeriod);
        }
    };

    public void addTeritorialDivision(TerritorialDivision territorialDivision) {
        history.add(territorialDivision);
        history.sort(divisionComparator);
    }

    public class TerritorialDivision {
        private ArrayList<Country> countries = new ArrayList<Country>();
        private Period existencePeriod;

        public TerritorialDivision(Period existencePeriod) {
            this.existencePeriod = existencePeriod;
        }

        public TerritorialDivision(Date begin, Date end) {
            this.existencePeriod = new Period(begin, end);
        }
    }
}
