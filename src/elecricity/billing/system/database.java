package elecricity.billing.system;
import java.sql.*;
public class database {
    Connection connection;
    Statement statement;
    database(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bill_system", "root", "Manchurian@6969");
            statement=connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
