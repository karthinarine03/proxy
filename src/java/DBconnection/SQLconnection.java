package DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLconnection {

    static Connection con;

    public static Connection getconnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = System.getenv("MYSQL_URL");
            String user = System.getenv("MYSQLUSER");
            String password = System.getenv("MYSQLPASSWORD");

            con = DriverManager.getConnection(url, user, password);

            System.out.println("DB Connected Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}