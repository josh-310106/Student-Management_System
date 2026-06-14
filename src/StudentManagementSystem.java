import java.sql.*;
import java.util.Scanner;

public class StudentManagementSystem {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    static void addStudent() {

        try {

            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Mark: ");
            double mark = sc.nextDouble();

            Connection con = DBConnection.getConnection();

            String sql =
                    "INSERT INTO students(id,name,mark) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, mark);

            ps.executeUpdate();

            System.out.println("Student Added Successfully!");

            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    static void viewStudents() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM students";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n----- STUDENT RECORDS -----");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getDouble("mark")
                );
            }

            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    static void searchStudent() {

        try {

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();

            Connection con = DBConnection.getConnection();

            String sql =
                    "SELECT * FROM students WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getDouble("mark")
                );

            } else {

                System.out.println("Student Not Found!");
            }

            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    static void updateStudent() {

        try {

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter New Name: ");
            String name = sc.nextLine();

            System.out.print("Enter New Mark: ");
            double mark = sc.nextDouble();

            Connection con = DBConnection.getConnection();

            String sql =
                    "UPDATE students SET name=?, mark=? WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setDouble(2, mark);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Student Updated Successfully!");

            } else {

                System.out.println("Student Not Found!");
            }

            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    static void deleteStudent() {

        try {

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();

            Connection con = DBConnection.getConnection();

            String sql =
                    "DELETE FROM students WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Student Deleted Successfully!");

            } else {

                System.out.println("Student Not Found!");
            }

            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}