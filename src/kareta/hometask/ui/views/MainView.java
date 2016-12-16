package kareta.hometask.ui.views;

import kareta.consoleui.Validator;
import kareta.consoleui.View;
import kareta.hometask.ui.validators.MainViewValidator;


public class MainView implements View {

    private Validator validator = new MainViewValidator();

    @Override
    public String getName() {
        return "Main View";
    }

    @Override
    public Validator getValidator() {
        return validator;
    }

    @Override
    public String getOutput() {
        StringBuilder builder = new StringBuilder();
        builder.append("1. Set path\n");
        builder.append("2. Current path\n");
        builder.append("3. Add flight\n");
        builder.append("4. All flights\n");
        builder.append("5. Exit\n");
        builder.append("Type choice:\n");
        return builder.toString();
    }
}