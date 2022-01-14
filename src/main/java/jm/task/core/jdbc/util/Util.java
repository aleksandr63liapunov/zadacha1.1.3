package jm.task.core.jdbc.util;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private String URL="jdbc:mysql://localhost:3306/mydbtest";
    private String Username="root";
    private String PASSWORD="Champion567";
    Connection connection;
    Driver driver;

    {
        try {
            driver = new FabricMySQLDriver();
        } catch (SQLException e) {
            System.out.println("ошибка подключения");

        }
        try {
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("ошибка регистрации драйвера");;
        }
        try {
            connection=DriverManager.getConnection(URL,Username,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
