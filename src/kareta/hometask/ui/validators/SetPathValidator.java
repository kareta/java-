package kareta.hometask.ui.validators;


import kareta.consoleui.Validator;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SetPathValidator implements Validator {

    @Override
    public ArrayList<String> dataIsCorrect(String data) {
        ArrayList<String> errors = new ArrayList<>();

//        if (!Files.exists(Paths.get(data)) {
//            errors.add("Fie")
//        }

        return errors;
    }
}
