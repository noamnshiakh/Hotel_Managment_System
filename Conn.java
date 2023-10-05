package Hotel.Managment.System;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");jdbc:mysql://localhost:3306/?user=root
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","Noman@123");
            s = c.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
