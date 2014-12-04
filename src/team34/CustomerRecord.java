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
public class CustomerRecord {

    private String CustomerID;       // first name of Student
    private String Name;        // last name of Student
    private String Address;    // degree status of student
    private String Phone;           // student major
    private String Email;           // student major
    private String  Spending;                 // StudentID, (contains position of student in the Array within the Applet)
    
    /** Creates a new instance of StudentRecord */
    public CustomerRecord(String id ,String cName, String cAddress, String cPhone, String cEmail, String cSpending) {
        CustomerID = id;
        Name = cName;
        Address = cAddress;
        Phone = cPhone;
        Email = cEmail;
        Spending = cSpending;
    }
    
    
//ACCESSORS
    //retrieves first name
    public String getCustomerID(){
        return CustomerID;
    }//end getFirstName()
    
    //retrieves last name
    public String getName(){
        return Name;
    }//end getLastName()
    
    //retrieves degree status
    public String getAddress(){
        return Address;
    }//end getDegreeStatus()
    
    //retrieves major
    public String getPhone(){
        return Phone;
    }//end getMajor()
    
    public String getEmail(){
        return Email;
    }//end getStudentID() 
    
    public String getSpending(){
        return Spending;
    }//end getStudentID() 
    
//MUTATORS 
    //sets first name
    public void setCustomerID(String id){
        CustomerID = id;
    }//end setFirstName()
    
    //sets last name
    public void setName(String cName){
        Name = cName;
    }//end setLastName()
    
    //sets degree status
    public void setAddress(String cAddress){
        Address = cAddress;
    }//end setDegreeStatus()
    
    //sets major
    public void setPhone(String cPhone){
        Phone = cPhone;
    }//end setMajor()
    
    //sets major
    public void setEmail(String cEmail){
        Email = cEmail;
    }//end setMajor()
    
    //sets Student ID, but it's really this students spot in the array
    public void setSpending(String cSpending){
        Spending = cSpending;
    }//end setID()
   
    
    public String toString(){
        return CustomerID + "    " + Name + " " + Address + "       " + Phone + "         " + Email + "         " + Spending;
    }
  
   
}//end CustomerRecord Class