package bank.management.system;

import java.sql.*;

public class Conn {
    Connection connection=null;
    Statement statement=null;

    public Conn() {
        try{
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306:/bankmanagementsystem","root","Amanak@2003#");
            statement=connection.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
