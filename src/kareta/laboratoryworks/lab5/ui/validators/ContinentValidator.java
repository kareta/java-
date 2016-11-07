package kareta.laboratoryworks.lab5.ui.validators;

import kareta.consoleui.Validator;

import java.util.ArrayList;

/**
 * Created by vitya on 01.11.2016.
 */
public class ContinentValidator implements Validator {
    public static final int FIELDS_NUMBER = 1;
    public static final String NAME_PATTERN = "[A-Za-z]{2,50}";

    public ArrayList<String> dataIsCorrect(String data) {
        ArrayList<String> errors = new ArrayList<>();
        if (!data.matches(NAME_PATTERN)) {
            errors.add("name is incorrect");
        }
        return errors;
    }
}
