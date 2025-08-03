package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

final public class DBConnection {

    static private String url = "jdbc:mysql://localhost:3306/hotel_db";
    static private String username = "root";
    static private String password = "0324";

    private DBConnection() {
    }

    public static Connection getConnection(){
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            return connection;
        }
        catch(SQLException e){
            System.out.println("Connection Failed! Check output console");
            return null;
        }
    }
}
