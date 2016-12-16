package kareta.hometask.ui.views;

import kareta.consoleui.Validator;
import kareta.consoleui.View;
import kareta.hometask.ui.validators.SetPathValidator;

public class SetPathView implements View {
    private Validator validator = new SetPathValidator();

    @Override
    public String getName() {
        return "Set Path View";
    }

    @Override
    public Validator getValidator() {
        return validator;
    }

    @Override
    public String getOutput() {
        StringBuilder builder = new StringBuilder();
        builder.append("Type path:\n");
        return builder.toString();
    }
}
