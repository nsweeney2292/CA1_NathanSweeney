/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1_nathansweeney;
//More efficient to read files in conjunction with FileReader
//import java.io.BufferedReader; 
// Reads character data from file - for eg our customers.txt
//import java.io.FileReader;
//in conjunction with catch for i/o exceptions
//import java.io.IOException;

//in the end I did a full import of the io library to condense my code
import java.io.*; 

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
                
                String[] firstLast = custName.split(" ");
                    if (firstLast.length !=2 || !firstLast[0].matches("[a-zA-Z]+") || !firstLast[1].matches("[a-zA-Z0-9]+")){
                        System.out.println("Error detected in " + custName + "file" 
                        +"\n" + "First name must be letter only.");
                        continue;
                    }

                
                //total purchase value - double
                // converts to double 
                line = br.readLine();
                double purchase = Double.parseDouble(line.trim());
                
                //class of the customer - int
                //converts to int
                line = br.readLine();
                int custClass = Integer.parseInt(line.trim());
                    if (custClass < 1 || custClass > 3){ // check if number is outside of required range
                        System.out.println("Error in customer data: " + custName + "\n" + "class is equal to: " 
                                + custClass + "\n" + "Customer class must be between 1-3" + "\n"); // print useful error message
                        continue; // continue with the program
                    }
                
                //purchase year - int
                //converts to int
                line = br.readLine();
                int year = Integer.parseInt(line.trim());
                    if (year <= 1900 || year >= 2025 ){ // check if purchase year is between 1900 and 2024
                        System.out.println("Error in customer data: " + custName + "\n" + "year is equal to: "
                                + year + "\n" + "year must be between 1900 and 2024\n"); //error message
                        continue;
                    }
                
                //new instance/object of customer class
                customer Cust = new customer(custName, purchase, custClass, year);
                
                //question 3
                //create both variables for final value and discount
                double finalValue = purchase;
                double discount = 0;
                int currentYear = 2024;
                
                // use if statements to highlight discount per criteria
                if (custClass == 1 && year == currentYear){
                    discount = 0.3; //30%
                }else if (custClass == 1 && year < (currentYear - 5)){
                    discount = 0.1; //10%
                }else if (custClass == 1 && year < currentYear){
                    discount = .2; //20%
                }
                else if (custClass == 2 && year == currentYear){
                    discount = 0.15; //15%
                }else if (custClass == 2 && year < (currentYear - 5)){
                    discount = 0.05; //5%
                }else if (custClass == 2 && year < currentYear){
                    discount = 0.13; //13%
                }
                else if (custClass == 3 && year == 2024){
                    discount = 0.03; //3%
                }else{
                    discount = 0; //no discount
                }
                
                // calculate the final value
                finalValue = purchase * (1 - discount);
                
                //print the customer info in the correct format
                System.out.println(Cust.info());
                
                //write this data to a new txt file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("customerdiscount.txt", true))){
                    writer.write(custName + "\n" + finalValue + "\n");
                    
                }catch (IOException e){//catches any i/o exceptions
                    System.out.println("Error writing to the file");
                }
            }
            
        }catch (IOException e){//catches any i/o exceptions
            System.out.println("Error in the file");
            
        }catch (NumberFormatException e){//catches any formatting errors
            System.out.println("Number not valid");
        }
    }
    
}
