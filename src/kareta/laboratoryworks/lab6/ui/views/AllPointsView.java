package kareta.laboratoryworks.lab6.ui.views;

import kareta.consoleui.Validator;
import kareta.consoleui.View;

import java.util.ArrayList;

public class AllPointsView implements View {
    private String data;

    public AllPointsView(String data) {
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
        return "All points:\n" + data;
    }
}
