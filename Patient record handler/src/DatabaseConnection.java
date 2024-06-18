//import java.sql.*;
//
//public class DatabaseConnection {
//    public static void main(String[] args)
//            throws SQLException, ClassNotFoundException {
//
//        // Connect to a database
//        Connection connection = DriverManager.getConnection
//                ("jdbc:mysql://localhost:3306/patientsdb" , "root", "12211219");
//        System.out.println("Database connected");
//
//        // Create a statement
//        Statement statement = connection.createStatement();
//
//        // Execute a statement
//        ResultSet resultSet = statement.executeQuery
//                ("select * from patients");
//
//        // Iterate through the result and print the student names
//        while (resultSet.next())
//            System.out.println(resultSet.getString(1) + "\t" +
//                    resultSet.getString(2));
//
//        // Close the connection
//        connection.close();
//    }
//}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/patientsdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12211219";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Load the database driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database successfully.");
        } catch (ClassNotFoundException e) {
            System.out.println("Database driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database.");
            e.printStackTrace();
        }
        return connection;
    }
}
