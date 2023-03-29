
package hotel.management.system;
import java.sql.* ; 
/*
 1.register the driver (include jar in lib  and lib - conn..jdbc - driverclass )
 2.Create  the connection . (database creation and getconnection line)
 3.Create the statement . (s ) 
 4.Executing the mysql queries .
 5.Closing the connection 
*/
public class Conn {
    Connection c ; 
    Statement s ; 
    Conn(){
        try{ // we include in try catch to avoid runtime errors becoz sql is external and may have error there.
            Class.forName("com.mysql.cj.jdbc.Driver") ; 
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","Dattu@2002");
            s = c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
