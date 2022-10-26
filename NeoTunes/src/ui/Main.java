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
    private Message message;
    
    public Main() {
        scan = new Scanner(System.in);
        controller = new Controller();
        message = new Message();
    }

    public Scanner getScan() {
        return scan;
    }

    public Controller getController() {
        return controller;
    }
    
    public Message getMessage() {
        return message;
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
        "3. Register an audio. \n" +
        "4. Create a playlist. \n" +
        "5. Edit a playlist. \n" +        
        "6. Share a playlist. \n" +
        "7. Play a song or podcast. \n" +        
        "8. Buy a song. \n" +
        "9. Report the total accumulated plays for each type of audio, song and podcast. \n" +
        "10. Report the most listened song genre and its number of plays. \n" +
        "11. Report the most listened podcast category and its number of plays. \n" +
        "12. Report the name and number of total plays for each of the Top 5 artists and Top 5 content creators.  \n" +
        "13. Report the name, genre or category and total number of plays of each of the members of the Top 10 songs and Top 10 podcasts. \n" +
        "14. Report the number of songs sold and the total sales value ($) of each genre. \n" +
        "15. Report the total number of sales and total sales value ($) of the best-selling song on the platform. \n" +
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
                registerProducer();
                break; 

            case 2: 	
                registerConsumer();
                break; 

            case 3:
                registerAudio();
                break;                    

            case 4: 
                createPlaylist();
                break; 

            case 5:    
                editPlaylist();
                break; 

            case 6: 	
                sharePlaylist();
                break; 

            case 7: 
                playAudio();
                break;                    

            case 8: 
                buySong();
                break; 

            case 9:    
                getTotalAccumulatedPlays();
                break; 
                
            case 10:
                getMostListenedSongGenre();
                break;
                
            case 11:
                getMostListenedPodcastCategory();
                break;

            case 12:
                getInfoTopFiveProducers();
                break;
                
            case 13:
                getInfoTopTenAudio();
                break;
                
            case 14:
                getSongSalesInfoByGenre();
                break;
                
            case 15:
                getSalesInfoOfBestSellingSong();
                break;
                
            case 0: 
                System.out.println("Exit program.");
                break; 

            default: 
                System.out.println("You selected an invalid option.");
                break; 
            }
    }
    
    public void registerProducer() {
        boolean isOnRange = false;
        int optionType = 0;
        String pName, pUrl, pNickname, pId, pDate;
        
        System.out.println("Select a user type: \n" + 
        "1. Artist \n" +
        "2. Content creator");
        optionType = scan.nextInt();
        
        isOnRange = controller.validateRange(optionType, 1, 2);
        
        if(isOnRange) {
            
            System.out.println("Type the name: ");
            pName = scan.next();
            
            System.out.println("Type the photo url: ");
            pUrl = scan.next();
            
            System.out.println("Type the nickname: ");
            pNickname = scan.next();
            
            System.out.println("Type the document id: ");
            pId = scan.next();
            
            //calculate Date registration
            
            // add register method of controller
            
        } else {
            System.out.println(message.msgOutRange());
        }
        
        
    }
    
    public void registerConsumer() {
        
    }
    
    public void registerAudio() {
        
    }
    
    public void createPlaylist() {
        
    }
    
    public void editPlaylist() {
        
    }
    
    public void sharePlaylist() {
        
    }
    
    public void playAudio() {
        
    }
    
    public void buySong() {
        
    }
    
    public void getTotalAccumulatedPlays() {
        
    }
    
    public void getMostListenedSongGenre() {
        
    }
    
    public void getMostListenedPodcastCategory() {
        
    }
    
    public void getInfoTopFiveProducers() {
        
    }
    
    public void getInfoTopTenAudio() {
        
    }
    
    public void getSongSalesInfoByGenre() {
        
    }
    
    public void  getSalesInfoOfBestSellingSong() {
        
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
