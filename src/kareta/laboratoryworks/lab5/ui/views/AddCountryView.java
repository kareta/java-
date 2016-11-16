package kareta.laboratoryworks.lab5.ui.views;

import kareta.consoleui.Validator;
import kareta.consoleui.View;
import kareta.laboratoryworks.lab5.ui.validators.CountryValidator;

/**
 * Created by vitya on 16.11.2016.
 */
public class AddCountryView implements View {
    @Override
    public String getName() {
        return "Add country view";
    }

    @Override
    public Validator getValidator() {
        return new CountryValidator();
    }

    @Override
    public String getOutput() {
        StringBuilder builder = new StringBuilder();
        builder.append("Input country in the format:");
        builder.append("<Country-name>");
        return builder.toString();
    }
}
