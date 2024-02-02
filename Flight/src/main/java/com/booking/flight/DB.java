package com.booking.flight;
import java.sql.*;
public class DB {
    public static Connection con;

    public static Connection getCon() throws Exception {

    Class.forName("com.mysql.cj.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","1234");

        return con;
    }
}
