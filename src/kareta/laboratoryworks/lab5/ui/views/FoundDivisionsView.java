package kareta.laboratoryworks.lab5.ui.views;

import kareta.consoleui.Validator;
import kareta.consoleui.View;

import java.util.ArrayList;

public class FoundDivisionsView implements View {

    private String data;

    public FoundDivisionsView(String data) {
        this.data = data;
    }

    @Override
    public String getName() {
        return "Found divisions view";
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
        return "Found divisions:\n" + data;
    }
}
