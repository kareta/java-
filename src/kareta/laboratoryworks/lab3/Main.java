package kareta.laboratoryworks.lab3;


public class Main {
    public static void main(String[] args) {
        Archive collegeArchive = new Archive();

        Teacher vasiliy = new Teacher("Vasiliy", "Ivanov");
        Teacher oleg = new Teacher("Oleg", "Petrov");
        Student masha = new Student("Masha", "Sidorova");
        Student tanya = new Student("Tanya", "Ivanova");

        Course mathematics = new Course(vasiliy, "mathematics", collegeArchive);
        vasiliy.announce(mathematics);
        tanya.registerInCourse(mathematics);
        masha.registerInCourse(mathematics);

        oleg.evaluate(mathematics, masha, Mark.EXCELLENT);
        vasiliy.evaluate(mathematics, tanya, Mark.SATISFACTORY);
        System.out.println(mathematics.toString());
    }
}
