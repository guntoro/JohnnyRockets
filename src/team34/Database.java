/*
 * Database.java
 *
 */
import java.util.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


//Database Class
public class Database {
    
//Declaration of variables    

//createTable() drops the current table and creates a new one
    public void createTable() {
        
       try
        {
             // load database driver class
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           
         // connect to database
         Connection con = DriverManager.getConnection("jdbc:odbc:RestaurantDB");
         Statement stmt = con.createStatement();
         
         //this code may need to be commented out because an exception will be thrown
         //if this table doesn't exist in the database
         stmt.execute("DROP TABLE Customers");
         
         stmt.execute("CREATE TABLE Customers" + 
                         "(CustomerID varchar(255), Name varchar(255)," +
                         " Address varchar(255), " + 
                         "Phone varchar(255), Email varchar(255), " + "Spending number)");
        
         System.out.println("Created Customers table");
         
         stmt.close();
         con.close();
        }
       // detect problems interacting with the database
      catch ( SQLException sqlException ) {
         JOptionPane.showMessageDialog( null, 
            sqlException.getMessage(), "Database Error",
            JOptionPane.ERROR_MESSAGE );
         
         System.exit( 1 );
      }//end catch block
      
      // detect problems loading database driver
      catch ( ClassNotFoundException classNotFound ) {
         JOptionPane.showMessageDialog( null, 
            classNotFound.getMessage(), "Driver Not Found",
            JOptionPane.ERROR_MESSAGE );

         System.exit( 1 );
      }//end catch block
        
   }//end createTable()

    
//this method accepts the student data as input and stores it to the database 
    public void storeRecord(String id ,String cName, String cAddress, String cPhone, String cEmail, float cSpending){
       
        try {
         
         // load database driver class
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           
         // connect to database
         Connection con =
                    DriverManager.getConnection("jdbc:odbc:RestaurantDB");
         
         Statement stmt = con.createStatement();
         //this Insert statement puts student info in the database
         stmt.executeUpdate("INSERT INTO Students VALUES ("+id+",'"+cName+"','" +cAddress+"','" +cPhone+"','"+cEmail+"','" +cSpending+"')");
         
         
         stmt.close();
         con.close();
        }//end try
        catch(Exception e) 
        {
                e.printStackTrace();
        }//end catch

    }//end storeRecord()
      
    public CustomerRecord[] getQueryData ()
    {
        CustomerRecord studentArray[] = new CustomerRecord[20];
        int numCustomers = 0;
        
        try {
        // load database driver class
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           
         // connect to database
         Connection con =
                    DriverManager.getConnection("jdbc:odbc:RestaurantDB");
         
         Statement stmt = con.createStatement();

          ResultSet rs = stmt.executeQuery("SELECT * from Customers");

          while (rs.next())
          {
              String rsName = rs.getString("Name");
              String rsAddress = rs.getString("Address");
              String rsPhone = rs.getString("Phone");
              String rsEmail = rs.getString("Email");
              float rsSpending = rs.getFloat(Spending);
              

              customerArray[numCustomers] = new CustomerRecord(numCustomers, rsName, rsAddress, rsPhone, rsEmail, rsSpending);
              numCustomers++;
              System.out.println(rsName);
          }

          stmt.close();

          con.close();

       }
       // detect problems interacting with the database
      catch ( SQLException sqlException ) {
         JOptionPane.showMessageDialog( null, 
            sqlException.getMessage(), "Database Error",
            JOptionPane.ERROR_MESSAGE );
         
         System.exit( 1 );
      }
      
      // detect problems loading database driver
      catch ( ClassNotFoundException classNotFound ) {
         JOptionPane.showMessageDialog( null, 
            classNotFound.getMessage(), "Driver Not Found",
            JOptionPane.ERROR_MESSAGE );

         System.exit( 1 );
      }      
       finally{
           return studentArray;
       }
        

   }
}// end Database class
    

