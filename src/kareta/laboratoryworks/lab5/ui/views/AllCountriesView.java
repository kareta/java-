package kareta.laboratoryworks.lab5.ui.views;

import kareta.consoleui.Validator;
import kareta.consoleui.View;

import java.util.ArrayList;

/**
 * Created by vitya on 16.11.16.
 */
public class AllCountriesView implements View {

    private String data;

    public AllCountriesView(String data) {
        this.data = data;
    }

    @Override
    public String getName() {
        return "All countries";
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
        return "All countries:\n" + data;
    }
}
