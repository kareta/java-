package kareta.laboratoryworks.lab5.ui.views;

import kareta.consoleui.Validator;
import kareta.consoleui.View;
import kareta.laboratoryworks.lab5.ui.validators.AddTerritorialDivisionCountryValidator;


public class AddTerritorialDivisionCountryView implements View {
    @Override
    public String getName() {
        return "Add country to territorial division";
    }

    @Override
    public Validator getValidator() {
        return new AddTerritorialDivisionCountryValidator();
    }

    @Override
    public String getOutput() {
        StringBuilder builder = new StringBuilder();
        builder.append("Input <Continent-name> <Territorial-division-name> <Country-name>:\n");
        return builder.toString();
    }
}
