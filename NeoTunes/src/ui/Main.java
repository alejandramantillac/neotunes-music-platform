package ui;

import model.*;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author Alejandra
 */
public class Main {
    private Scanner scan;
    
    private Controller controller;
    
    public Main() {
        scan = new Scanner(System.in);
        controller = new Controller();
    }

    public Scanner getScan() {
        return scan;
    }

    public Controller getController() {
        return controller;
    }
    
    public static void main(String[] args){
        Main main = new Main(); 

        int option = -1; 

            do{
                option = main.getOptionShowMenu(); 
                main.executeOption(option);

            } while(option != 0);

        main.getScan().close();
    }
 
    /**
    * getOptionShowMenu prints the menu and receives the option given by the user.
    * @return option save the option chosen.
    */
    public int getOptionShowMenu(){

        int option = 0; 
        System.out.println("<<<<< NeoTunes Music Platform  >>>>>");
        System.out.println(
        "1. Register a producer user. \n" +
        "2. Register a consumer user. \n" +
        "3. Register a song. \n" +
        "4. Register a podcast. \n" +
        "5. Create a playlist. \n" +
        "6. Edit a playlist. \n" +        
        "7. Share a playlist. \n" +
        "8. Play a song or podcast. \n" +        
        "9. Buy a song. \n" +
        "10. Report the total accumulated plays for each type of audio, song and podcast. \n" +
        "11. Report the most listened song genre and its number of plays. \n" +
        "12. Report the most listened podcast category and its number of plays. \n" +
        "13. Report the name and number of total plays for each of the Top 5 artists and Top 5 content creators.  \n" +
        "14. Report the name, genre or category and total number of plays of each of the members of the Top 10 songs and Top 10 podcasts. \n" +
        "15. Report the number of songs sold and the total sales value ($) of each genre. \n" +
        "16. Report the total number of sales and total sales value ($) of the best-selling song on the platform. \n" +
        "0. Exit. ");
        option = validateIntegerOption(); 

        return option; 
    }

    /**
     * executeOption executes the program's functionalities according to the user's choice.
     * @param option saves the user's choice.
     */    
    public void executeOption(int option){
                

        switch(option){
            case 1:            
                break; 

            case 2: 	
                break; 

            case 3: 
                break;                    

            case 4: 
                break; 

            case 5:    
                break; 

            case 6: 	
                break; 

            case 7: 
                break;                    

            case 8: 
                break; 

            case 9:    
                break; 
                
            case 10:
                break;
                
            case 11:
                break;

            case 12:
                break;
                
            case 13:
                break;
                
            case 14:
                break;
                
            case 15:
                break;
                
            case 16:
                break;
                
            case 0: 
                System.out.println("Exit program.");
                break; 

            default: 
                System.out.println("You selected an invalid option.");
                break; 
            }
    }
    
    /**
     * validateIntegerOption validates integer entries entered by the user.
     * @return option represents the validation (if return -1 means that is not an integer).
     */    
    public int validateIntegerOption(){
        int option = 0; 

        if(scan.hasNextInt()){
            option = scan.nextInt(); 
        }
        else{
            scan.nextLine(); 
            System.out.println("Error. You entered a non-numeric value.");
            option = -1; 
        }

        return option; 
    }
}
