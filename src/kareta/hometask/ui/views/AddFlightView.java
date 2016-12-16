package kareta.hometask.ui.views;

import kareta.consoleui.Validator;
import kareta.consoleui.View;
import kareta.hometask.ui.validators.AddFlightValidator;

public class AddFlightView implements View {
    @Override
    public String getName() {
        return "Add country view";
    }

    @Override
    public Validator getValidator() {
        return new AddFlightValidator();
    }

    @Override
    public String getOutput() {
        StringBuilder builder = new StringBuilder();
        builder.append("Input country flight:");
        builder.append("<Country-name>");
        return builder.toString();
    }
}
