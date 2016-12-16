package kareta.hometask.controllers;

import kareta.consoleui.Controller;
import kareta.consoleui.ViewRenderer;
import kareta.hometask.models.Airport;
import kareta.hometask.models.Day;
import kareta.hometask.models.Flight;
import kareta.hometask.storage.CustomDeserializer;
import kareta.hometask.storage.CustomSerializer;
import kareta.hometask.storage.Deserializer;
import kareta.hometask.ui.views.AddFlightView;
import kareta.hometask.ui.views.CurrentPathView;
import kareta.hometask.ui.views.MainView;
import kareta.hometask.ui.views.SetPathView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainController extends Controller {

    private String path = "No path yet";
    private Airport airport = new Airport();
    private ViewRenderer viewRenderer = new ViewRenderer();


    public MainController() {
        super(new MainView());
    }

    @Override
    public boolean runChoice(String choice) {
        boolean exit = false;
        switch (choice)
        {
            case "1":
                setPath();
                break;
            case "2":
                currentPath();
                break;
            case "3":
                addFlight();
                break;
            case "4":
                allFlights();
                break;
            case "5":
                exit = true;
                break;
        }
        return exit;
    }

    private void currentPath() {
        try {
            viewRenderer.run(new CurrentPathView(path));
        } catch (Exception e) {
            //write to logger
            //e.printStackTrace();
        }
    }

    private void allFlights() {
    }

    private void addFlight() {
        Airport airport = new Airport();
        CustomDeserializer deserializer = new CustomDeserializer(path);
        Thread thread = new Thread(deserializer);
        if (Files.exists(Paths.get(path))) {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            airport = (Airport) deserializer.getResult();
        }

        try {
            String flightString = viewRenderer.run(new AddFlightView());
            String[] splittedData = flightString.split(" ");
            ArrayList<String> errors = new ArrayList<>();


            String destination = splittedData[0];

            try {
                int raceNumber = Integer.parseInt(splittedData[1]);
            } catch (Exception e) {
                errors.add("Race number is incorrect");
            }

            String planeType = splittedData[2];

            DateFormat format = new SimpleDateFormat("yyyy/mm/dd");

            Date date = format.parse(splittedData[3]);

            Day day = Day.fromString(splittedData[4]);

            Flight flight = new Flight();
            flight.setDate(date);
            flight.setDay(day);
            flight.setDestination(destination);
            flight.setPlaneNumber(raceNumber);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void setPath() {
        try {
            path = viewRenderer.run(new SetPathView());
        } catch (Exception e) {
            //write to logger
            //e.printStackTrace();
        }
    }


}
