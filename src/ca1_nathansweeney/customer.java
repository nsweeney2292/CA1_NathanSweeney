/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1_nathansweeney;

/**
 *
 * @author nathansweeney
 */
public class customer {
    //fields
    private String custName;
    private double purchase;
    private int custClass;
    private int year;
    
    //constructor
    public customer(String custName, double purchase, int custClass, int year){
        this.custName = custName;
        this.purchase = purchase;
        this.custClass = custClass;
        this.year = year;
    }
    
    // return method for customer info - to be incorporated in CA1
    public String info(){
        return "Customer Name: " + custName + "\n" + 
                "Value of Purchase: " + purchase + "\n" +
                "Customer Class: " + custClass + "\n" +
                "Year: " + year + "\n";
    }
}
    
    