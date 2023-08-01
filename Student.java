package attendance;

public class Student {
    private int studentId;
    private String name;
    private boolean[] attendance;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.attendance = new boolean[30];
    }

    // Getters and setters for attributes

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public boolean[] getAttendance() {
        return attendance;
    }

    // Method to mark attendance for a specific day
    public void markAttendance(int day) {
        if (day > 0 && day <= attendance.length) {
            attendance[day - 1] = true;
        }
    }
}
