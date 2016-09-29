package kareta.laboratoryworks.lab3;

import java.util.ArrayList;

public class Archive {
    private ArrayList<CourseMarksSheet> courseMarksSheets;

    public Archive() {
        courseMarksSheets = new ArrayList<CourseMarksSheet>();
    }

    public Archive(ArrayList<CourseMarksSheet> courseMarksSheets) {
        this.courseMarksSheets = courseMarksSheets;
    }

    public ArrayList<CourseMarksSheet> getCourseMarksSheets() {
        return courseMarksSheets;
    }

    public void setCourseMarksSheets(ArrayList<CourseMarksSheet> courseMarksSheets) {
        this.courseMarksSheets = courseMarksSheets;
    }

    public void addMarksSheet(CourseMarksSheet sheet) {
        courseMarksSheets.add(sheet);
    }
}
