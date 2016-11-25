package kareta.laboratoryworks.lab6;

import java.awt.*;
import java.util.ArrayList;
import java.util.Set;

public class TriangleFinder {
    public double vectorLength(Point firstPoint, Point secondPoint) {
        return Math.sqrt(
            Math.pow(firstPoint.getX() - secondPoint.getX(), 2) +
            Math.pow(firstPoint.getY() - secondPoint.getY(), 2)
        );
    }

    public double getPerimeter(Point firstPoint, Point secondPoint, Point thirdPoint) {
        return vectorLength(firstPoint, secondPoint) +
            vectorLength(secondPoint, thirdPoint) +
            vectorLength(thirdPoint, firstPoint);
    }

    public double getPerimeter(ArrayList<Point> points) {
        if (points.size() != 3) {
            return -1;
        }

        return getPerimeter(points.get(0), points.get(1), points.get(2));
    }

    public ArrayList<Point> findBiggest(Set<Point> pointSet) {
        ArrayList<Point> biggestPoints = new ArrayList<>();
        double biggestPerimeter = -1;

        for (Point firstPoint : pointSet) {
            for (Point secondPoint : pointSet) {

                if (secondPoint == firstPoint) {
                    continue;
                }

                for (Point thirdPoint : pointSet) {
                    if (firstPoint == thirdPoint || secondPoint == thirdPoint) {
                        continue;
                    }

                    double perimeter = getPerimeter(firstPoint, secondPoint, thirdPoint);
                    if (perimeter > biggestPerimeter) {
                        biggestPerimeter = perimeter;

                        biggestPoints.clear();
                        biggestPoints.add(firstPoint);
                        biggestPoints.add(secondPoint);
                        biggestPoints.add(thirdPoint);
                    }
                }
            }
        }
        return biggestPoints;
    }
}
