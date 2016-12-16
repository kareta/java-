package kareta.hometask.ui.views;


import kareta.consoleui.Validator;
import kareta.consoleui.View;

import java.util.ArrayList;

public class CurrentPathView implements View {
    private String data;

    public CurrentPathView(String data) {
        this.data = data;
    }

    @Override
    public String getName() {
        return "Current path";
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
        return "Current path:\n" + data;
    }
}
