package kareta.hometask.ui.validators;

import kareta.consoleui.Validator;

import java.util.ArrayList;

public class MainViewValidator implements Validator {
    public static final String CHOICE_PATTERN = "^[1-4]$";

    @Override
    public ArrayList<String> dataIsCorrect(String data) {
        ArrayList<String> errors = new ArrayList<>();
        if (!data.matches(CHOICE_PATTERN)) {
            errors.add("choice is incorrect");
        }
        return errors;
    }
}
