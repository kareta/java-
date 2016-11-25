package kareta.laboratoryworks.lab6.ui.views;

import kareta.consoleui.Validator;
import kareta.consoleui.View;
import kareta.laboratoryworks.lab5.ui.validators.MainViewValidator;

/**
 * Created by vitya on 24.11.16.
 */
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
        builder.append("1. Add Point\n");
        builder.append("2. All Points\n");
        builder.append("3. Biggest triangle\n");
        builder.append("4. Exit\n");
        builder.append("Type choice:\n");
        return builder.toString();
    }
}
