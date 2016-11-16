package kareta.laboratoryworks.lab5.ui.views;

import kareta.consoleui.Validator;
import kareta.consoleui.View;
import kareta.laboratoryworks.lab5.ui.validators.ContinentValidator;

public class AddContinentView implements View {

    private Validator validator = new ContinentValidator();

    @Override
    public String getName() {
        return "Add Continent";
    }

    @Override
    public Validator getValidator() {
        return validator;
    }

    @Override
    public String getOutput() {
        StringBuilder builder = new StringBuilder();
        builder.append("Input continent in the format:");
        builder.append("<Continent-name>\n");
        return builder.toString();
    }
}