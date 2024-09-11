package banking.management.project;
import java.sql.*;
public class connection {
 Connection c ;
 Statement s;
 public  connection(){
  try{

   // java do this registeration step itself
//   Class.forName(com.mysql.cj.jdbc.Driver); --> this is that registeration step
   c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","AYUSH3578");
   s = c.createStatement();
  }catch (Exception e)
  {
   System.out.println(e);
  }

 }

}
