package kareta.hometask.models;

import java.util.ArrayList;

public class Airport {
    private ArrayList<Flight> flights = new ArrayList<>();

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }
}
