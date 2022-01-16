package jm.task.core.jdbc.util;



import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.hibernate.cfg.AvailableSettings.DRIVER;

public class Util {
    private static String URL="jdbc:mysql://localhost:3306/mydbtest";
    private static String USERNAME="root";
    private static String PASSWORD="Champion567";
    public static Connection getConnetion() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
