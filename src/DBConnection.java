import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        try {

            String url = "jdbc:mysql://localhost:3306/student_db";
            String user = "root";
            String password = "YOUR_PASSWORD";

            return DriverManager.getConnection(url, user, password);

        } catch (Exception e) {

            System.out.println("Connection Failed!");
            System.out.println(e);
            return null;
        }
    }
}