import java.sql.*;
import java.util.Scanner;

public class StudentManagement {
    private static final String URL = "jdbc:mysql://localhost:3306/school_db";
    private static final String USER = "root"; 
    private static final String PASSWORD = "Velaga@123";  

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                System.out.println("Connected to the database!");

                while (true) {
                    System.out.println("\n1. Add Student\n2. View Students\n3. Search Student by ID\n4. Exit");
                    System.out.print("Choose an option: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (choice) {
                        case 1:
                            addStudent(conn, scanner);
                            break;
                        case 2:
                            viewStudents(conn);
                            break;
                        case 3:
                            searchStudent(conn, scanner);
                            break;
                        case 4:
                            System.out.println("Goodbye!");
                            return;
                        default:
                            System.out.println("Invalid choice.");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addStudent(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, grade);
            stmt.executeUpdate();
            System.out.println("Student added successfully!");
        }
    }

    private static void viewStudents(Connection conn) throws SQLException {
        String sql = "SELECT * FROM students";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- Student List ---");
            while (rs.next()) {
                System.out.printf("ID: %d | Name: %s | Age: %d | Grade: %s%n",
                        rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("grade"));
            }
        }
    }

    private static void searchStudent(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        String sql = "SELECT * FROM students WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.printf("ID: %d | Name: %s | Age: %d | Grade: %s%n",
                            rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("grade"));
                } else {
                    System.out.println("No student found with that ID.");
                }
            }
        }
    }
}
