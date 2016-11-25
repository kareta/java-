package kareta.laboratoryworks.lab6.ui.views;


import kareta.consoleui.Validator;
import kareta.consoleui.View;

import java.util.ArrayList;

public class BiggestTriangleView implements View {
    private String data;

    public BiggestTriangleView(String data) {
        this.data = data;
    }

    @Override
    public String getName() {
        return "Biggest triangle";
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
        return "Biggest triangle:\n" + data;
    }
}
