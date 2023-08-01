package attendance;

import java.util.ArrayList;
import java.util.List;

public class School {
    private String schoolName;
    private List<Student> students;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    // Getters and setters for attributes

    public String getSchoolName() {
        return schoolName;
    }

    public List<Student> getStudents() {
        return students;
    }

    // Method to add a new student to the school
    public void addStudent(Student student) {
        students.add(student);
    }
}
