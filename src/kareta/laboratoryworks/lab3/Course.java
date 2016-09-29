package kareta.laboratoryworks.lab3;

import java.util.ArrayList;

public class Course {
    private Teacher teacher;
    private String title;
    private CourseMarksSheet sheet;

    public Course(Teacher teacher, String title, Archive archive) {
        this.teacher = teacher;
        this.teacher.addCourse(this);
        this.sheet = new CourseMarksSheet(teacher, title);
        archive.addMarksSheet(sheet);
    }

    public void addStudent(Student student) {
        sheet.addStudent(student);
    }

    public ArrayList<Student> getStudents() {
        return sheet.getStudents();
    }

    public void setStudentMark(Student student, Mark mark) {
        sheet.setStudentMark(student, mark);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        sheet.setCourseTitle(title);
        this.title = title;
    }

    public String toString() {
        return sheet.toString();
    }
}
