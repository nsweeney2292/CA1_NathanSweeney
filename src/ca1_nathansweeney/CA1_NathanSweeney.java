/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1_nathansweeney;
//More efficient to read files in conjunction with FileReader
import java.io.BufferedReader; 
// Reads character data from file - for eg our customers.txt
import java.io.FileReader;
//in conjunction with catch for i/o exceptions
import java.io.IOException;

/**
 *
 * @author nathansweeney
 */
public class CA1_NathanSweeney {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // the name of the txt file being read
        String filename = "customers.txt";
        
        // create bufferedreader to read text file
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            
            //loop needed to read each line from file until the end
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
                    if (custClass < 1 || custClass > 3){ // check if number is outside of required range
                        System.out.println("Error in: " + custName + "\n" + "class is equal to: " 
                                + custClass + "\n" + "Customer class must be between 1-3"); // print useful error message
                        continue; // continue with the program
                    }
                
                //purchase year - int
                //converts to int
                line = br.readLine();
                int year = Integer.parseInt(line.trim());
                
                //new instance/object of customer class
                customer Cust = new customer(custName, purchase, custClass, year);
                
                //print the customer info in the correct format
                System.out.println(Cust.info());
            }
        }catch (IOException e){//catches any i/o exceptions
            System.out.println("Error in the file");
            
        }catch (NumberFormatException e){//catches any formatting errors
            System.out.println("Number not valid");
        }
    }
    
}
