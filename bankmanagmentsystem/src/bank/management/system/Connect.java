package bank.management.system;

import java.sql.*;

public class Connect {
    Connection connection=null;
    Statement statement=null;

    public Connect() {
        try{
            connection=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Amanak@2003#");
            statement=connection.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
