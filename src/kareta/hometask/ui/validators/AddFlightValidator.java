package kareta.hometask.ui.validators;

import kareta.consoleui.Validator;
import kareta.hometask.models.Day;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//private String destination;
//private int raceNumber;
//private String planeType;
//private int planeNumber;
//private Date date;
//private String day;
public class AddFlightValidator implements Validator {
    public static final int FIELDS_NUMBER = 6;
    public static final String DESTINATION_PATTERN = "[A-Za-z]";
    public static final String PLANE_TYPE_PATTERN = "[A-Za-z]";

    public ArrayList<String> dataIsCorrect(String data) {
        String[] splittedData = data.split(" ");
        ArrayList<String> errors = new ArrayList<>();

        if (splittedData.length != FIELDS_NUMBER) {
            errors.add("Inputted data is in incorrect format.");
            return errors;
        }

        String destination = splittedData[0];
        if (!destination.matches(DESTINATION_PATTERN)) {
            errors.add("Destination is incorrect");
        }

        try {
            int raceNumber = Integer.parseInt(splittedData[1]);
        } catch (Exception e) {
            errors.add("Race number is incorrect");
        }

        String planeType = splittedData[2];
        if (!planeType.matches(PLANE_TYPE_PATTERN)) {
            errors.add("Plane type is incorrect");
        }

        try {
            int planeNumber = Integer.parseInt(splittedData[3]);
        } catch (Exception e) {
            errors.add("Plane number is incorrect");
        }

        DateFormat format =
                new SimpleDateFormat("yyyy/mm/dd");

        Date date = null;
        try {
            date = format.parse(splittedData[3]);
        } catch (Exception e) {
            errors.add("Date is incorrect");
        }

        Day day = Day.fromString(splittedData[4]);
        if (day != Day.NODAY) {
            errors.add("Day is incorrect");
        }

        return errors;
    }
}
