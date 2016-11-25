package kareta.laboratoryworks.lab6.ui.validators;

import kareta.consoleui.Validator;

import java.util.ArrayList;

public class AddPointValidator implements Validator {
    public static final String POINTS_PATTERN = ".?\\d+ .?\\d+";

    public ArrayList<String> dataIsCorrect(String data) {
        ArrayList<String> errors = new ArrayList<>();

        String[] parts = data.split(",");

        for (String part : parts) {
            if (!part.trim().matches(POINTS_PATTERN)) {
                errors.add("coordinates are incorrect");
                return errors;
            }
        }

        return errors;
    }
}
