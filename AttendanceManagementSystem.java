package attendance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.sql.Connection;
////import java.sql.DriverManager;
////import java.sql.PreparedStatement;
//import java.sql.ResultSet;
////import java.sql.SQLException;
//import java.util.Scanner;
//
//public class AttendanceManagementSystem {
//    private School school;
//    private Scanner scanner;
//    private java.sql.Connection connection;
//
//   
//
//
//
//    public AttendanceManagementSystem() {
//        this.school = new School("Sample School");
//        this.scanner = new Scanner(System.in);
//        this.connection = createConnection();
//        createTable(); // Create the table if it doesn't exist
//    }
//
////     Method to create a connection to the database
//    private Connection createConnection() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/attendance";
//            String username = "root"; 
//            String password = "Kiran@Harsh2023"; // Replace with your MySQL password
//            return DriverManager.getConnection(url, username, password);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    // Method to create the 'students' table if it doesn't exist
// // Method to create the 'students' table if it doesn't exist
//    private void createTable() {
//        try {
//            String query = "CREATE TABLE IF NOT EXISTS students (" +
//                    "student_id INT PRIMARY KEY, " +
//                    "name VARCHAR(50) NOT NULL";
//
//            for (int i = 1; i <= 30; i++) {
//                query += ", day_" + i + " BOOLEAN DEFAULT false";
//            }
//
//            query += ");";
//
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    // Method to add a new student to the school and database
//    public void addStudent() {
//        System.out.println("Enter student ID:");
//        int studentId = scanner.nextInt();
//        scanner.nextLine(); // Consume the newline character
//        System.out.println("Enter student name:");
//        String name = scanner.nextLine();
//        Student student = new Student(studentId, name);
//        school.addStudent(student);
//        addStudentToDatabase(studentId, name); // Add student to the database
//        System.out.println("Student added successfully!");
//    }
//
//    // Method to add a new student to the database
//    private void addStudentToDatabase(int studentId, String name) {
//        try {
//            String query = "INSERT INTO students (student_id, name) VALUES (?, ?);";
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setInt(1, studentId);
//            statement.setString(2, name);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Method to mark attendance for a student
//    public void markAttendance() {
//        System.out.println("Enter student ID to mark attendance:");
//        int studentId = scanner.nextInt();
//        Student student = findStudent(studentId);
//        if (student != null) {
//            System.out.println("Enter the day to mark attendance (1-30):");
//            int day = scanner.nextInt();
//            student.markAttendance(day);
//            markAttendanceInDatabase(studentId, day); // Mark attendance in the database
//            System.out.println("Attendance marked successfully!");
//        } else {
//            System.out.println("Student not found!");
//        }
//    }
//
//    // Method to mark attendance for a student in the database
//    private void markAttendanceInDatabase(int studentId, int day) {
//        try {
//            String query = "UPDATE students SET day_" + day + " = ? WHERE student_id = ?;";
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setBoolean(1, true);
//            statement.setInt(2, studentId);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Method to display attendance for a student
//    public void displayAttendance() {
//        System.out.println("Enter student ID to display attendance:");
//        int studentId = scanner.nextInt();
//        Student student = findStudent(studentId);
//        if (student != null) {
//            System.out.println("Attendance for Student " + student.getName() + ":");
//            boolean[] attendance = student.getAttendance();
//            for (int i = 0; i < attendance.length; i++) {
//                System.out.println("Day " + (i + 1) + ": " + (attendance[i] ? "Present" : "Absent"));
//            }
//        } else {
//            System.out.println("Student not found!");
//        }
//    }
//
//    // Helper method to find a student by ID
//    private Student findStudent(int studentId) {
//        for (Student student : school.getStudents()) {
//            if (student.getStudentId() == studentId) {
//                return student;
//            }
//        }
//        return null;
//    }
//
//    // Method to start the attendance management system
//    public void start() {
//        boolean running = true;
//        while (running) {
//            System.out.println("\nAttendance Management System - Menu:");
//            System.out.println("1. Add Student");
//            System.out.println("2. Mark Attendance");
//            System.out.println("3. Display Attendance");
//            System.out.println("4. Exit");
//            System.out.println("Choose an option (1-4):");
//
//            int option = scanner.nextInt();
//            switch (option) {
//                case 1:
//                    addStudent();
//                    break;
//                case 2:
//                    markAttendance();
//                    break;
//                case 3:
//                    displayAttendance();
//                    break;
//                case 4:
//                    running = false;
//                    System.out.println("Exiting the Attendance Management System...");
//                    break;
//                default:
//                    System.out.println("Invalid option! Please choose a valid option.");
//            }
//        }
//        scanner.close();
//    }
//
//    public static void main(String[] args) {
//        AttendanceManagementSystem attendanceSystem = new AttendanceManagementSystem();
//        attendanceSystem.start();
//    }
//    
//} 
//



























import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AttendanceManagementSystem {
    public static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void displayRoleInfo() {
            System.out.println("Role: Person");
        }
    }

    public static class Student extends Person {
        private int studentId;
        private boolean[] attendance;

        public Student(int studentId, String name) {
            super(name);
            this.studentId = studentId;
            this.attendance = new boolean[30];
        }

        public int getStudentId() {
            return studentId;
        }

        public boolean[] getAttendance() {
            return attendance;
        }

        public void markAttendance(int day) {
            if (day > 0 && day <= attendance.length) {
                attendance[day - 1] = true;
            }
        }

        @Override
        public void displayRoleInfo() {
            System.out.println("Role: Student");
            System.out.println("Student ID: " + studentId);
        }

        @Override
        public String toString() {
            return "Student ID: " + studentId + ", Name: " + getName();
        }
    }

    public static class Teacher extends Person {
        private String subject;
        private String className;

        public Teacher(String name, String subject, String className) {
            super(name);
            this.subject = subject;
            this.className = className;
        }

        public String getSubject() {
            return subject;
        }

        public String getClassName() {
            return className;
        }

        @Override
        public void displayRoleInfo() {
            System.out.println("Role: Teacher");
            System.out.println("Subject: " + subject);
            System.out.println("Class: " + className);
        }
    }

    public static class School {
        private String schoolName;
        private List<Person> people;

        public School(String schoolName) {
            this.schoolName = schoolName;
            this.people = new ArrayList<>();
        }

        public String getSchoolName() {
            return schoolName;
        }

        public List<Person> getPeople() {
            return people;
        }

        public void addPerson(Person person) {
            people.add(person);
        }
    }

    private School school;
    private Scanner scanner;
    private Connection connection;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/attendance";

    public AttendanceManagementSystem() {
        this.school = new School("Sample School");
        this.scanner = new Scanner(System.in);
        this.connection = null;
        initializeDatabase1();
    }
    private Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/attendance"; // Replace with your MySQL connection URL
            String username = "root"; // Replace with your MySQL username
            String password = "Kiran@Harsh2023"; // Replace with your MySQL password
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    private void initializeDatabase1() {
        try {
            connection = DriverManager.getConnection(DB_URL);
            createAttendanceTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection createAttendanceTable() {
        String sql = "CREATE TABLE IF NOT EXISTS attendance (" +
                "student_id INTEGER PRIMARY KEY," +
                "student_name TEXT," +
                "day INTEGER," +
                "attendance_status INTEGER" +
                ")";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
		return connection;

    }
    private void initializeDatabase() {
        createAttendanceTable();
    }

    private void markAttendanceInDatabase(int studentId, int day, boolean attendanceStatus) {
        String sql = "INSERT INTO attendance (student_id, student_name, day, attendance_status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            Student student = findStudent(studentId);
            if (student != null) {
                stmt.setInt(1, studentId);
                stmt.setString(2, student.getName());
                stmt.setInt(3, day);
                stmt.setInt(4, attendanceStatus ? 1 : 0);
                stmt.executeUpdate();
                System.out.println("Attendance marked successfully!");
            } else {
                System.out.println("Student not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void markAttendance() {
        System.out.println("Enter student ID to mark attendance:");
        int studentId = scanner.nextInt();
        System.out.println("Enter the day to mark attendance (1-30):");
        int day = scanner.nextInt();
        System.out.println("Enter attendance status (1 for Present, 0 for Absent):");
        int attendanceStatus = scanner.nextInt();
        markAttendanceInDatabase(studentId, day, attendanceStatus == 1);
    }

    private void displayAttendanceFromDatabase(int studentId) {
        String sql = "SELECT * FROM attendance WHERE student_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            ResultSet resultSet = stmt.executeQuery();
            System.out.println("Attendance for Student (Student ID: " + studentId + "):");
            while (resultSet.next()) {
                int day = resultSet.getInt("day");
                int attendanceStatus = resultSet.getInt("attendance_status");
                System.out.println("Day " + day + ": " + (attendanceStatus == 1 ? "Present" : "Absent"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayAttendance() {
        System.out.println("Enter student ID to display attendance:");
        int studentId = scanner.nextInt();
        displayAttendanceFromDatabase(studentId);
    }

    private Student findStudent(int studentId) {
        for (Person person : school.getPeople()) {
            if (person instanceof Student) {
                Student student = (Student) person;
                if (student.getStudentId() == studentId) {
                    return student;
                }
            }
        }
        return null;
    }

    public void addPerson() {
        System.out.println("Enter person name:");
        scanner.nextLine(); // Consume the newline character
        String name = scanner.nextLine();
        System.out.println("Choose role: 1. Student, 2. Teacher");
        int roleOption = scanner.nextInt();
        if (roleOption == 1) {
            System.out.println("Enter student ID:");
            int studentId = scanner.nextInt();
            Student student = new Student(studentId, name);
            school.addPerson(student);
            System.out.println("Student added successfully!");
        } else if (roleOption == 2) {
            scanner.nextLine(); // Consume the newline character
            System.out.println("Enter teacher's subject:");
            String subject = scanner.nextLine();
            System.out.println("Enter teacher's class:");
            String className = scanner.nextLine();
            Teacher teacher = new Teacher(name, subject, className);
            school.addPerson(teacher);
            System.out.println("Teacher added successfully!");
        } else {
            System.out.println("Invalid role option! Please choose a valid role.");
        }
    }

    public void displayRoleInfo() {
        System.out.println("Enter person name to display role information:");
        scanner.nextLine(); // Consume the newline character
        String name = scanner.nextLine();
        for (Person person : school.getPeople()) {
            if (person.getName().equalsIgnoreCase(name)) {
                person.displayRoleInfo();
                return;
            }
        }
        System.out.println("Person not found!");
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nAttendance Management System");
            System.out.println("1. Add Person");
            System.out.println("2. Mark Attendance");
            System.out.println("3. Display Attendance");
            System.out.println("4. Display Role Information");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    markAttendance();
                    break;
                case 3:
                    displayAttendance();
                    break;
                case 4:
                    displayRoleInfo();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Thank you for using the Attendance Management System!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
        scanner.close();
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AttendanceManagementSystem attendanceSystem = new AttendanceManagementSystem();
        attendanceSystem.start();
    }
}





public class AttendanceManagementSystem {
	public static class Person {
      private String name;

      public Person(String name) {
          this.name = name;
      }

      public String getName() {
          return name;
      }

      public void displayRoleInfo() {
          System.out.println("Role: Person");
      }
  }

  public static class Student extends Person {
      private int studentId;
      private boolean[] attendance;

      public Student(int studentId, String name) {
          super(name);
          this.studentId = studentId;
          this.attendance = new boolean[30];
      }

      public int getStudentId() {
          return studentId;
      }

      public boolean[] getAttendance() {
          return attendance;
      }

      public void markAttendance(int day) {
          if (day > 0 && day <= attendance.length) {
              attendance[day - 1] = true;
          }
      }

      @Override
      public void displayRoleInfo() {
          System.out.println("Role: Student");
          System.out.println("Student ID: " + studentId);
      }

      @Override
      public String toString() {
          return "Student ID: " + studentId + ", Name: " + getName();
      }
  }

  public static class Teacher extends Person {
      private String subject;
      private String className;

      public Teacher(String name, String subject, String className) {
          super(name);
          this.subject = subject;
          this.className = className;
      }

      public String getSubject() {
          return subject;
      }

      public String getClassName() {
          return className;
      }

      @Override
      public void displayRoleInfo() {
          System.out.println("Role: Teacher");
          System.out.println("Subject: " + subject);
          System.out.println("Class: " + className);
      }
  }

  public static class School {
      private String schoolName;
      private List<Person> people;

      public School(String schoolName) {
          this.schoolName = schoolName;
          this.people = new ArrayList<>();
      }

      public String getSchoolName() {
          return schoolName;
      }

      public List<Person> getPeople() {
          return people;
      }

      public void addPerson(Person person) {
          people.add(person);
      }
  }

  private School school;
  private Scanner scanner;
  private Connection connection;
  private static final String DB_URL = "jdbc:mysql://localhost:3306/attendance";

private Connection createAttendanceTable() {
String sql = "CREATE TABLE IF NOT EXISTS attendance (" +
        "student_id INTEGER PRIMARY KEY," +
        "student_name TEXT," +
        "day INTEGER," +
        "attendance_status INTEGER" +
        ")";

return connection;

}
  private void initializeDatabase() {
    try {
        connection = DriverManager.getConnection(DB_URL);
        createAttendanceTable();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    public AttendanceManagementSystem() {
        this.school = new School("Sample School");
        this.scanner = new Scanner(System.in);
        this.connection = createConnection();
        initializeDatabase();
    }

    private Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/attendance"; // Replace with your MySQL connection URL
            String username = "kavya"; // Replace with your MySQL username
            String password = "Kiran@Harsh2023"; // Replace with your MySQL password
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to create the 'students' table if it doesn't exist
    private void createTable() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS students (" +
                    "student_id INT PRIMARY KEY, " +
                    "name VARCHAR(50) NOT NULL";

            for (int i = 1; i <= 30; i++) {
                query += ", day_" + i + " BOOLEAN DEFAULT false";
            }

            query += ");";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a new student to the database
    private void addStudentToDatabase(int studentId, String name) {
        try {
            String query = "INSERT INTO students (student_id, name) VALUES (?, ?);";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, studentId);
            statement.setString(2, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to mark attendance for a student in the database
    private void markAttendanceInDatabase(int studentId, int day, boolean attendanceStatus) {
        try {
            String query = "UPDATE students SET day_" + day + " = ? WHERE student_id = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setBoolean(1, attendanceStatus);
            statement.setInt(2, studentId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to display attendance for a student from the database
    private void displayAttendanceFromDatabase(int studentId) {
        try {
            String query = "SELECT * FROM students WHERE student_id = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, studentId);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Attendance for Student (Student ID: " + studentId + "):");
            while (resultSet.next()) {
                for (int i = 1; i <= 30; i++) {
                    boolean attendanceStatus = resultSet.getBoolean("day_" + i);
                    System.out.println("Day " + i + ": " + (attendanceStatus ? "Present" : "Absent"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
  public void start() {
  boolean exit = false;
  while (!exit) {
      System.out.println("\nAttendance Management System");
      System.out.println("1. Add Person");
      System.out.println("2. Mark Attendance");
      System.out.println("3. Display Attendance");
      System.out.println("4. Display Role Information");
      System.out.println("5. Exit");
      System.out.print("Enter your choice (1-5): ");
      int choice = scanner.nextInt();
      switch (choice) {
          case 1:
              addPerson();
              break;
          case 2:
              markAttendance();
              break;
          case 3:
              displayAttendance();
              break;
          case 4:
              displayRoleInfo();
              break;
          case 5:
              exit = true;
              System.out.println("Thank you for using the Attendance Management System!");
              break;
          default:
              System.out.println("Invalid choice! Please enter a valid option.");
      }
  }
  scanner.close();
  try {
      if (connection != null) {
          connection.close();
      }
  } catch (SQLException e) {
      e.printStackTrace();
  }
}
  public static void main(String[] args) {
  AttendanceManagementSystem attendanceSystem = new AttendanceManagementSystem();
  attendanceSystem.start();
}
}

    

