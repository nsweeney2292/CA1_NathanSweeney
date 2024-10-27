/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1_nathansweeney;
//More efficient to read files in conjunction with FileReader
import java.io.BufferedReader; 
// Reads character data from file - for eg our customers.txt
import java.io.FileReader;

/**
 *
 * @author nathansweeney
 */
public class CA1_NathanSweeney {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String filename = "customers.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            
            while ((line = br.readLine()) != null){
                //customers name - first and last - String
                String custName = line.trim();
                
                //total purchase value - double
                // converts to double 
                line = br.readLine();
                double purchase = Double.parseDouble(line.trim());
                
                //class of the customer - int
                //converts to int
                line = br.readLine();
                int custClass = Integer.parseInt(line.trim());
                
                //purchase year - int
                //converts to int
                line = br.readLine();
                int year = Integer.parseInt(line.trim());
                
                //create customer class and add instance below
            }
        }//add catch
    }
    
}
