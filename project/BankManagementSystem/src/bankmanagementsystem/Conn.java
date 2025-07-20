package bankmanagementsystem;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Ensure the driver is loaded
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem?useSSL=false&allowPublicKeyRetrieval=true", "root", "1234");
            s = c.createStatement();
            System.out.println("Connected to Database!");
        } catch (Exception e) {
            e.printStackTrace();
            s = null; // Mark statement as null if connection fails
        }
    }
}
