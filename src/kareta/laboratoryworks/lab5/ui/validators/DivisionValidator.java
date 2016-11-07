package kareta.laboratoryworks.lab5.ui.validators;

import kareta.consoleui.Validator;

import java.util.ArrayList;
import java.util.Date;

public class DivisionValidator implements Validator {
    public static final int FIELDS_NUMBER = 3;
    public static final String NAME_PATTERN = "[A-Za-z]{2,50}";

    public ArrayList<String> dataIsCorrect(String data) {
        String[] splittedData = data.split(" ");
        ArrayList<String> errors = new ArrayList<>();

        if (splittedData.length != FIELDS_NUMBER) {
            errors.add("Inputted data is in incorrect format.");
            return errors;
        }

        String name = splittedData[0];
        if (!name.matches(NAME_PATTERN)) {
            errors.add("Name is incorrect");
        }

        Date begin = null;
        try {
            begin = new Date(splittedData[1]);
        } catch (Exception e) {
            errors.add("Begin date is incorrect");
        }

        Date end = null;
        try {
            end = new Date(splittedData[2]);
        } catch (Exception e) {
            errors.add("End date is incorrect");
        }

        if (begin != null && end != null && begin.getTime() > end.getTime()) {
            errors.add("Begin date is after end date.");
        }

        return errors;
    }
}
