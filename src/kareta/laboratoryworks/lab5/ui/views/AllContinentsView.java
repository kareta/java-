package kareta.laboratoryworks.lab5.ui.views;

import kareta.consoleui.Validator;
import kareta.consoleui.View;
import kareta.laboratoryworks.lab5.ui.validators.ContinentValidator;

import java.util.ArrayList;


public class AllContinentsView implements View {

    private String data;

    public AllContinentsView(String data) {
        this.data = data;
    }

    @Override
    public String getName() {
        return "All continents";
    }

    @Override
    public Validator getValidator() {
        return new Validator() {
            @Override
            public ArrayList<String> dataIsCorrect(String data) {
                return new ArrayList<>();
            }
        };
    }

    @Override
    public String getOutput() {
        StringBuilder builder = new StringBuilder();
        builder.append("All continents:");
        builder.append(data);
        return builder.toString();
    }
}
