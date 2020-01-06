package tr.com.mipek.core;

import tr.com.mipek.interfaces.CoreInterfaces;



import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ObjectHelper extends CoreFields implements CoreInterfaces {

    @Override
    public Connection getConnection() {
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
    } catch (ClassNotFoundException e) {

        System.out.println("Where is your Oracle JDBC Driver?");
        e.printStackTrace();
        return null;
    }
        System.out.println("Oracle JDBC Driver Registered!");
    Connection connection = null;
        try {
        connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "neww", "123456");
    } catch (SQLException e) {
        System.out.println("Connection Failed! Check output console");
        e.printStackTrace();
        return null;
    }
        if (connection != null) {
        System.out.println("You made it, take control your database now!");
        return connection;
    } else {

        System.out.println("Failed to make connection!");
            return null;
    }
}
}
