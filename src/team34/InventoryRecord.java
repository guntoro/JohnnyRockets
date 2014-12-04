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
public class InventoryRecord {

    private String IngName;       // name of Ingredient
    private String Stock;         // number of stock on hand    
    
    /** Creates a new instance of InventoryRecord */
    public InventoryRecord(String iName ,String iStock) {
        IngName = iName;
        Stock = iStock;
    }    
    
//ACCESSORS
    //retrieves ingredient name
    public String getIngName(){
        return IngName;
    }//end getIngName()
    
    //retrieves number of stock on hand
    public String getStock(){
        return Stock;
    }//end getStock()
    
//MUTATORS 
    //sets first name
    public void setIngName(String iName){
        IngName = iName;
    }//end setFirstName()
    
    //sets last name
    public void setStock(String iStock){
        Stock = iStock;
    }//end setLastName()   
    
    public String toString(){
        return IngName + "    " + Stock;
    }  
   
}//end InventoryRecord Class