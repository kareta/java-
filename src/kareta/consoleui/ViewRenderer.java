package kareta.consoleui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewRenderer {
    public String run(View view) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> errorList;
        String inputLine;
        do
        {
            System.out.println(view.getOutput());
            inputLine = scanner.nextLine();
            Validator validator = view.getValidator();
            errorList = validator.dataIsCorrect(inputLine);
            Runtime.getRuntime().exec("cls");
            outputErrors(errorList);
            if (errorList.size() != 0 && view.getName() == "Try again")
            {
                return "2";
            }

        } while (errorList.size() != 0 && tryAgain());

        boolean tryAgainDenied = errorList.size() != 0;

        //Inputted data is incorrect
        if (tryAgainDenied)
        {
            return null;
        }

        return inputLine;
    }

    public void outputErrors(ArrayList<String> errors) {
        for (String error : errors) {
            System.out.println(error);
        }
    }

    public boolean tryAgain() {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine().trim();
        String outputLine = "Try";

        switch (choice)
        {
            case "1":
                return false;
            case "2":
                return true;
        }
        return true;
    }
}
