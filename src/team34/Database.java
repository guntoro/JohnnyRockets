/*
 * Database.java
 *
 */
package team34;

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
         //if this tables don't exist in the database
         stmt.execute("DROP TABLE Customers");         
         stmt.execute("CREATE TABLE Customers" + 
                         "(CustomerID varchar(255), Name varchar(255)," +
                         " Address varchar(255), " + 
                         "Phone varchar(255), Email varchar(255), " + "Spending varchar(255))");
         
         stmt.execute("DROP TABLE Inventory");         
         stmt.execute("CREATE TABLE Inventory" + 
                         "(IngName varchar(255), Stock varchar(255))");
        
         //System.out.println("Created Inventory table");
         
         stmt.execute("DROP TABLE Orders");         
         stmt.execute("CREATE TABLE Orders" + 
                         "(OrderID varchar(255), OrderDate varchar(255), CustomerID varchar(255), ItemCode1 varchar(255), Q1 varchar(255), ItemCode2 varchar(255), Q2 varchar(255),ItemCode3 varchar(255), Q3 varchar(255), ItemCode4 varchar(255), Q4 varchar(255), ItemCode5 varchar(255), Q5 varchar(255), TotalCost varchar(255))");
         
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
    public void storeCustomerRecord(String id ,String cName, String cAddress, String cPhone, String cEmail, String cSpending){
       
        try {         
            // load database driver class
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           
            // connect to database
            Connection con = DriverManager.getConnection("jdbc:odbc:RestaurantDB");         
            Statement stmt = con.createStatement();
            //this Insert statement puts student info in the database
            stmt.executeUpdate("INSERT INTO Customers VALUES ("+id+",'"+cName+"','" +cAddress+"','" +cPhone+"','"+cEmail+"','" +cSpending+"')");
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
        CustomerRecord customerArray[] = new CustomerRecord[20];
        int numCustomers = 0;
        
        try {
            // load database driver class
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           
            // connect to database
            Connection con = DriverManager.getConnection("jdbc:odbc:RestaurantDB");         
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from Customers");

            while (rs.next()){
                String rsCustomerID = rs.getString("CustomerID");
                String rsName = rs.getString("Name");
                String rsAddress = rs.getString("Address");
                String rsPhone = rs.getString("Phone");
                String rsEmail = rs.getString("Email");
                String rsSpending = rs.getString("Spending");
                customerArray[numCustomers] = new CustomerRecord(rsCustomerID, rsName, rsAddress, rsPhone, rsEmail, rsSpending);
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
            return customerArray;
        } 
    }
    
    //this method accepts the student data as input and stores it to the database 
    public void storeInventoryRecord(String iName ,String iStock){
       
        try {
         
         // load database driver class
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           
         // connect to database
         Connection con =
                    DriverManager.getConnection("jdbc:odbc:RestaurantDB");
         
         Statement stmt = con.createStatement();
         //this Insert statement puts inventory info in the database
         //stmt.executeUpdate("INSERT INTO Customers VALUES ("+id+",'"+cName+"','" +cAddress+"','" +cPhone+"','"+cEmail+"','" +cSpending+"')");
         stmt.executeUpdate("insert into Inventory " + "values  ('"+iName+"','"+iStock+"')");
         //stmt.executeUpdate("INSERT INTO Inventory VALUES ("+iName+",'"+iStock+"')");
         stmt.close();
         con.close();
        }//end try
        catch(Exception e) 
        {
                e.printStackTrace();
        }//end catch

    }//end storeRecord()
      
    public InventoryRecord[] getQueryInventoryData ()
    {
        InventoryRecord inventoryArray[] = new InventoryRecord[20];
        int numInventory = 0;
        
        try {
        // load database driver class
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           
         // connect to database
         Connection con =
                    DriverManager.getConnection("jdbc:odbc:RestaurantDB");
         
         Statement stmt = con.createStatement();

          ResultSet rs = stmt.executeQuery("SELECT * from Inventory");
          //System.out.println("Stop Here 1");

          while (rs.next())
          {
              String rsIngName = rs.getString("IngName");
              String rsStock = rs.getString("Stock");              

              inventoryArray[numInventory] = new InventoryRecord(rsIngName, rsStock);
              numInventory++;
              System.out.println(rsIngName);
          }
          //System.out.println("Stop Here 2");

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
           return inventoryArray;
       } 
    }
    
    //this method accepts the student data as input and stores it to the database 
    public void storeOrderRecord(String oOrderID ,String oOrderDate, String oOrderCustomerID, String oItemCode1, String oQ1, String oItemCode2, String oQ2, String oItemCode3, String oQ3, String oItemCode4, String oQ4, String oItemCode5, String oQ5, String oTotalCost){
       
        try {         
            // load database driver class
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           
            // connect to database
            Connection con = DriverManager.getConnection("jdbc:odbc:RestaurantDB");         
            Statement stmt = con.createStatement();
            //System.out.println("Error here");
            //this Insert statement puts student info in the database
            //stmt.executeUpdate("INSERT INTO Customers VALUES ("+id+",'"+cName+"','" +cAddress+"','" +cPhone+"','"+cEmail+"','" +cSpending+"')");
            //stmt.executeUpdate("insert into Inventory " + "values  ('"+iName+"','"+iStock+"')");
            //stmt.executeUpdate("INSERT INTO Customers VALUES ("+oOrderID+",'"+oOrderDate+"','" +oCustomerID+"','" +oItemCode1+"','"+oQ1+"','" +oItemCode2+"','"+oQ2+"','" +oItemCode3+"','"+oQ3+"','" +oItemCode4+"','"+oQ4+"','" +oItemCode5+"','"+oQ5+"','" +oTotalCost+"')");            
            stmt.executeUpdate("insert into Inventory " + "values  ('"+oOrderID+"','"+oOrderDate+"','"+oOrderCustomerID+"','"+oItemCode1+"','"+oQ1+"','"+oItemCode2+"','"+oQ2+"','"+oItemCode3+"','"+oQ3+"','"+oItemCode4+"','"+oQ4+"','"+oItemCode5+"','"+oQ5+"','"+oTotalCost+"')");
            stmt.close();
            con.close();
        }//end try
        catch(Exception e) 
        {
            e.printStackTrace();
        }//end catch

    }//end storeRecord()
      
    public OrderRecord[] getQueryOrderData ()
    {
        OrderRecord orderArray[] = new OrderRecord[90];
        int numOrders = 0;
        
        try {
            // load database driver class
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           
            // connect to database
            Connection con = DriverManager.getConnection("jdbc:odbc:RestaurantDB");         
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from Orders");

            while (rs.next()){
                String rsOrderID = rs.getString("OrderID");
                String rsOrderDate = rs.getString("OrderDate");
                String rsOrderCustomerID = rs.getString("OrderCustomerID");
                String rsItemCode1 = rs.getString("ItemCode1");
                String rsQ1 = rs.getString("Q1");
                String rsItemCode2 = rs.getString("ItemCode2");
                String rsQ2 = rs.getString("Q2");
                String rsItemCode3 = rs.getString("ItemCode3");
                String rsQ3 = rs.getString("Q3");
                String rsItemCode4 = rs.getString("ItemCode4");
                String rsQ4 = rs.getString("Q4");
                String rsItemCode5 = rs.getString("ItemCode5");
                String rsQ5 = rs.getString("Q5");
                String rsTotalCost = rs.getString("TotalCost");
                orderArray[numOrders] = new OrderRecord(rsOrderID, rsOrderDate, rsOrderCustomerID, rsItemCode1, rsQ1, rsItemCode2, rsQ2, rsItemCode3, rsQ3, rsItemCode4, rsQ4, rsItemCode5, rsQ5, rsTotalCost);
                numOrders++;
                System.out.println(rsOrderID);
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
            return orderArray;
        } 
    }
    
}// end Database class
    

