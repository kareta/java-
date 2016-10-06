package kareta.laboratoryworks.lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CourseMarksSheet {
    private Teacher teacher;
    private String courseTitle;
    private HashMap<Student, ArrayList<Mark>> marks;

    public CourseMarksSheet(Teacher teacher, String courseTitle) {
        this(teacher, courseTitle, new HashMap<Student, ArrayList<Mark>>());
    }

    public CourseMarksSheet(Teacher teacher, String courseTitle, HashMap<Student, ArrayList<Mark>> marks) {
        this.teacher = teacher;
        this.marks = marks;
        this.courseTitle = courseTitle;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public HashMap<Student, ArrayList<Mark>> getMarks() {
        return marks;
    }

    public void setMarks(HashMap<Student, ArrayList<Mark>> marks) {
        this.marks = marks;
    }

    public void setStudentMark(Student student, Mark mark) {
        getMarks().get(student).add(mark);
    }

    public void addStudent(Student student) {
        getMarks().put(student, new ArrayList<Mark>());
    }

    public ArrayList<Student> getStudents() {
        return new ArrayList<Student>(Arrays.asList((Student[])getMarks().keySet().toArray()));
    }

    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("Course title is " + getCourseTitle() + "\n");
        builder.append("Teacher is " + getTeacher().toString() + "\n");

        if (marks.size() == 0) {
            return builder.toString() + "There are no students in the course.";
        }

        for (Map.Entry<Student, ArrayList<Mark>> entry : marks.entrySet()) {
            Student student = entry.getKey();
            builder.append(student.toString() + " has following marks: ");
            builder.append(entry.getValue().toString() + "\n");
        }

        return builder.toString();
    }
}
