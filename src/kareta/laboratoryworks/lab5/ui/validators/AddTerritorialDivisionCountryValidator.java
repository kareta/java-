package kareta.laboratoryworks.lab5.ui.validators;

import kareta.consoleui.Validator;

import java.util.ArrayList;

public class AddTerritorialDivisionCountryValidator implements Validator {
    public static final String PATTERN = "[A-Za-z0-9]{2,50} [A-Za-z0-9]{2,50} [A-Za-z0-9]{2,50}";

    public ArrayList<String> dataIsCorrect(String data) {
        ArrayList<String> errors = new ArrayList<>();
        if (!data.matches(PATTERN)) {
            errors.add("data is incorrect");
        }
        return errors;
    }
}
