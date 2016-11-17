package kareta.laboratoryworks.lab5.ui.validators;

import javafx.scene.input.DataFormat;
import kareta.consoleui.Validator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class DivisionValidator implements Validator {
    public static final int FIELDS_NUMBER = 4;
    public static final String NAME_PATTERN = "[A-Za-z]{2,50}";

    public ArrayList<String> dataIsCorrect(String data) {
        String[] splittedData = data.split(" ");
        ArrayList<String> errors = new ArrayList<>();

        if (splittedData.length != FIELDS_NUMBER) {
            errors.add("Inputted data is in incorrect format.");
            return errors;
        }

        String continentName = splittedData[0];
        if (!continentName.matches(NAME_PATTERN)) {
            errors.add("Continent is incorrect");
        }

        String divisionName = splittedData[1];
        if (!continentName.matches(NAME_PATTERN)) {
            errors.add("Division name is incorrect");
        }

        DateFormat format =
                new SimpleDateFormat("yyyy/mm/dd");

        Date begin = null;
        try {
            begin = format.parse(splittedData[2]);
        } catch (Exception e) {
            errors.add("Begin date is incorrect");
        }

        Date end = null;
        try {
            end = format.parse(splittedData[3]);
        } catch (Exception e) {
            errors.add("End date is incorrect");
        }

        if (begin != null && end != null && begin.getTime() > end.getTime()) {
            errors.add("Begin date is after end date.");
        }

        return errors;
    }
}
