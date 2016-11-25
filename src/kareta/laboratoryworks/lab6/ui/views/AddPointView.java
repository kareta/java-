package kareta.laboratoryworks.lab6.ui.views;

import kareta.consoleui.Validator;
import kareta.consoleui.View;
import kareta.laboratoryworks.lab6.ui.validators.AddPointValidator;


public class AddPointView implements View {
    private Validator validator = new AddPointValidator();

    @Override
    public String getName() {
        return "Add point";
    }

    @Override
    public Validator getValidator() {
        return validator;
    }

    @Override
    public String getOutput() {
        StringBuilder builder = new StringBuilder();
        builder.append("Input point in the format:");
        builder.append("x-coordinate y-coordinate\n");
        return builder.toString();
    }
}
