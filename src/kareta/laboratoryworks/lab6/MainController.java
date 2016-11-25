package kareta.laboratoryworks.lab6;

import kareta.consoleui.Controller;
import kareta.consoleui.ViewRenderer;
import kareta.laboratoryworks.lab6.ui.views.AddPointView;
import kareta.laboratoryworks.lab6.ui.views.BiggestTriangleView;
import kareta.laboratoryworks.lab6.ui.views.MainView;
import kareta.laboratoryworks.lab6.ui.views.AllPointsView;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class MainController extends Controller {
    private ViewRenderer viewRenderer = new ViewRenderer();
    private Set<Point> pointSet = new HashSet<Point>();

    public MainController() {
        super(new MainView());
    }

    @Override
    public boolean runChoice(String choice) {
        boolean exit = false;
        switch (choice)
        {
            case "1":
                addPoint();
                break;
            case "2":
                allPoints();
                break;
            case "3":
                findBiggestTriangle();
                break;
            case "4":
                exit = true;
                break;
        }
        return exit;
    }

    public void addPoint() {
        try {
            String pointsData = viewRenderer.run(new AddPointView());
            String[] parts = pointsData.trim().split(",");
            for (String part : parts) {
                if (!part.isEmpty()) {
                    String[] coordinates = part.trim().split(" ");
                    if (coordinates[0].isEmpty() || coordinates[0].isEmpty()) {
                         continue;
                    }

                    int x = Integer.parseInt(coordinates[0].trim());
                    int y = Integer.parseInt(coordinates[1].trim());

                    pointSet.add(new Point(x, y));
                }

            }
        } catch (Exception e) {
            //write to logger
        }
    }

    public void allPoints() {
        StringBuilder builder = new StringBuilder();
        for (Point point : pointSet) {
            builder.append("(" + (int)point.getX() + " " + (int)point.getY() + ") ");
        }

        try {
            viewRenderer.run(new AllPointsView(builder.toString()));
        } catch (IOException e) {
            //write to logger
        }
    }

    public void findBiggestTriangle() {
        TriangleFinder triangleFinder = new TriangleFinder();
        ArrayList<Point> biggestPoints = triangleFinder.findBiggest(pointSet);
        double biggestPerimeter = triangleFinder.getPerimeter(biggestPoints);

        StringBuilder builder = new StringBuilder();
        builder.append("Points: ");
        for (Point point : biggestPoints) {
            builder.append("(" + (int)point.getX() + " " + (int)point.getY() + ") ");
        }
        builder.append(String.format(" Perimeter is %.2f", biggestPerimeter));

        try {
            viewRenderer.run(new BiggestTriangleView(builder.toString()));
        } catch (IOException e) {
            //write to logger
        }
    }
}
