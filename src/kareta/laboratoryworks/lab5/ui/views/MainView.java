package kareta.laboratoryworks.lab5.ui.views;


import kareta.consoleui.Validator;
import kareta.consoleui.View;
import kareta.laboratoryworks.lab5.ui.validators.MainViewValidator;

public class MainView implements View{

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
        builder.append("1. Add Continent\n");
        builder.append("2. Add Country\n");
        builder.append("3. Add Division\n");
        builder.append("4. All Continents\n");
        builder.append("5. All Countries\n");
        builder.append("6. All Divisions\n");
        builder.append("Type choice:\n");
        return builder.toString();
    }
}
