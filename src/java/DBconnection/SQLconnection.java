package DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLconnection {

    static Connection con;

    public static Connection getconnection() {
        try {
            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Get Railway environment variables
            String host = System.getenv("MYSQLHOST");
            String port = System.getenv("MYSQLPORT");
            String database = System.getenv("MYSQLDATABASE");
            String user = System.getenv("MYSQLUSER");
            String password = System.getenv("MYSQLPASSWORD");

            // Create connection URL
            String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=false&allowPublicKeyRetrieval=true";

            // Connect to database
            con = DriverManager.getConnection(url, user, password);

            System.out.println("Database Connected Successfully!");

        } catch (Exception e) {
            System.out.println("Database Connection Failed!");
            e.printStackTrace(); // VERY IMPORTANT for debugging
        }

        return con;
    }
}