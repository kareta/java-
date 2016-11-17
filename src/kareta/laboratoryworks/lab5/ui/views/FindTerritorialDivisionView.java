package kareta.laboratoryworks.lab5.ui.views;

import kareta.consoleui.Validator;
import kareta.consoleui.View;
import kareta.laboratoryworks.lab5.ui.validators.CountryValidator;

/**
 * Created by vitya on 16.11.16.
 */
public class FindTerritorialDivisionView implements View {

    @Override
    public String getName() {
        return "Find Territorial Division View";
    }

    @Override
    public Validator getValidator() {
        return new CountryValidator();
    }

    @Override
    public String getOutput() {
        return "Type country name:\n";
    }
}
