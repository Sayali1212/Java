package training.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {

    public static Connection getConnection()throws SQLException {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","pass");
        //System.out.println(con);
        return con;
    }
}
