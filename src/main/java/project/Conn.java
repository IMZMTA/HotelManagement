package project;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    Conn() throws ClassNotFoundException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root@123");
            s = c.createStatement();
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }

}
