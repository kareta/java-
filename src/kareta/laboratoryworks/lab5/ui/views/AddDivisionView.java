package kareta.laboratoryworks.lab5.ui.views;

import kareta.consoleui.Validator;
import kareta.consoleui.View;
import kareta.laboratoryworks.lab5.ui.validators.DivisionValidator;

/**
 * Created by vitya on 16.11.2016.
 */
public class AddDivisionView implements View {
    @Override
    public String getName() {
        return "Add division view";
    }

    @Override
    public Validator getValidator() {
        return new DivisionValidator();
    }

    @Override
    public String getOutput() {
        StringBuilder builder = new StringBuilder();
        builder.append("Input division in the format:\n");
        builder.append("<Continent-name> <Division-name>");
        builder.append(" <Begin-date YYYY/MM/DD>");
        builder.append(" <End-date YYYY/MM/DD>\n");
        return builder.toString();
    }
}
