import java.sql.Connection;
import java.sql.DriverManager;

public class Test {

    public static void main(String[] args) {

        try {

            Connection con =
                DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_db",
                    "root",
                    "YOUR PASSWORD"
                );

            System.out.println("Connected Successfully!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}