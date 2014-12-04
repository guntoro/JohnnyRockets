/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team34;

/**
 *
 * @author Owner
 */
public class OrderRecord {

    private String OrderID;             // Order ID
    private String OrderDate;           // Order Date
    private String OrderCustomerID;     // Customer ID
    private String ItemCode1;           // Code of Item 1
    private String Q1;                  // Quantity of Item 1    
    private String ItemCode2;           // Code of Item 2
    private String Q2;                  // Quantity of Item 2
    private String ItemCode3;           // Code of Item 3
    private String Q3;                  // Quantity of Item 3
    private String ItemCode4;           // Code of Item 4
    private String Q4;                  // Quantity of Item 4
    private String ItemCode5;           // Code of Item 5
    private String Q5;                  // Quantity of Item 5
    private String TotalCost;           // Total cost of order
    
    /** Creates a new instance of StudentRecord */
    public OrderRecord(String dOrderID ,String dOrderDate, String dOrderCustomerID, String dItemCode1, String dQ1, String dItemCode2, String dQ2,String dItemCode3, String dQ3,String dItemCode4, String dQ4,String dItemCode5, String dQ5,String dTotalCost) {
        OrderID = dOrderID;
        OrderDate = dOrderDate;
        OrderCustomerID = dOrderCustomerID;
        ItemCode1 = dItemCode1;
        Q1 = dQ1;
        ItemCode2 = dItemCode2;
        Q2 = dQ2;
        ItemCode3 = dItemCode3;
        Q3 = dQ3;
        ItemCode4 = dItemCode4;
        Q4 = dQ4;
        ItemCode5 = dItemCode5;
        Q5 = dQ5;
        TotalCost = dTotalCost;
    }
    
    
//ACCESSORS
    //retrieves first name
    public String getOrderID(){
        return OrderID;
    }//end getFirstName()
    
    //retrieves last name
    public String getOrderDate(){
        return OrderDate;
    }//end getLastName()
    
    //retrieves degree status
    public String getOrderCustomerID(){
        return OrderCustomerID;
    }//end getDegreeStatus()
    
    //retrieves major
    public String getItemCode1(){
        return ItemCode1;
    }//end getMajor()
    
    public String getQ1(){
        return Q1;
    }//end getStudentID() 
    
    //retrieves major
    public String getItemCode2(){
        return ItemCode2;
    }//end getMajor()
    
    public String getQ2(){
        return Q2;
    }//end getStudentID() 
    
    //retrieves major
    public String getItemCode3(){
        return ItemCode3;
    }//end getMajor()
    
    public String getQ3(){
        return Q3;
    }//end getStudentID() 
    
    //retrieves major
    public String getItemCode4(){
        return ItemCode4;
    }//end getMajor()
    
    public String getQ4(){
        return Q4;
    }//end getStudentID() 
    
    //retrieves major
    public String getItemCode5(){
        return ItemCode5;
    }//end getMajor()
    
    public String getQ5(){
        return Q5;
    }//end getStudentID() 
    
    public String getTotalCost(){
        return TotalCost;
    }//end getStudentID() 
    
//MUTATORS 
    //sets first name
    public void setOrderID(String dOrderID){
        OrderID = dOrderID;
    }//end setFirstName()
    
    //sets last name
    public void setOrderDate(String dOrderDate){
        OrderDate = dOrderDate;
    }//end setLastName()
    
    //sets degree status
    public void setOrderCustomerID(String dOrderCustomerID){
        OrderCustomerID = dOrderCustomerID;
    }//end setDegreeStatus()
    
    //sets major
    public void setItemCode1(String dItemCode1){
        ItemCode1 = dItemCode1;
    }//end setMajor()
    
    //sets major
    public void setQ1(String dQ1){
        Q1 = dQ1;
    }//end setMajor()
    
    //sets major
    public void setItemCode2(String dItemCode2){
        ItemCode2 = dItemCode2;
    }//end setMajor()
    
    //sets major
    public void setQ2(String dQ2){
        Q2 = dQ2;
    }//end setMajor()
    
    //sets major
    public void setItemCode3(String dItemCode3){
        ItemCode3 = dItemCode3;
    }//end setMajor()
    
    //sets major
    public void setQ3(String dQ3){
        Q3 = dQ3;
    }//end setMajor()
    
    //sets major
    public void setItemCode4(String dItemCode4){
        ItemCode4 = dItemCode4;
    }//end setMajor()
    
    //sets major
    public void setQ4(String dQ4){
        Q4 = dQ4;
    }//end setMajor()
    
    //sets major
    public void setItemCode5(String dItemCode5){
        ItemCode5 = dItemCode5;
    }//end setMajor()
    
    //sets major
    public void setQ5(String dQ5){
        Q5 = dQ5;
    }//end setMajor()
    
    //sets Student ID, but it's really this students spot in the array
    public void setTotalCost(String dTotalCost){
        TotalCost = dTotalCost;
    }//end setID()
   
    
    public String toString(){
        return OrderID + "    " + OrderDate + " " + OrderCustomerID + "       " + ItemCode1 + "         " + Q1 + "         " + ItemCode2 + "         " + Q2 +
                "         " + ItemCode3 + "         " + Q3 + "         " + ItemCode4 + "         " + Q4 + "         " + ItemCode5 + "         " + Q5 + "         " + TotalCost;
    }
  
   
}//end CustomerRecord Class