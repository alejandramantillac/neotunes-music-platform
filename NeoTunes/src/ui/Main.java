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
    
    /**
     * registerProducer
     */
    public void registerProducer() {
        boolean isOnRange = false, register;
        int optionType = 0;
        String pName, pUrl, pNickname, pId, pDate;
        
        System.out.println("Select a user type: \n" + 
        "1. Artist \n" +
        "2. Content creator");
        optionType = validateIntegerOption();
        
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
            
            pDate = controller.getDate();
            
            switch(optionType) {
                case 1:
                    Producer artist = new Artist(pName, pUrl, optionType, pNickname, pId, pDate);
                    
                    register = controller.registerProducer(artist);
                    
                    if(register) {
                        System.out.println(message.msgUserRegister());
                    } else {
                        System.out.println(message.msgErrorUserRegister());
                    }
                    
                    break;
                    
                case 2:                  
                    Producer contentCreator = new ContentCreator(pName, pUrl, optionType, pNickname, pId, pDate);

                    register = controller.registerProducer(contentCreator);

                    if(register) {
                        System.out.println(message.msgUserRegister());
                    } else {
                        System.out.println(message.msgErrorUserRegister());
                    }
                    
                    break;
            }
            
            
        } else {
            System.out.println(message.msgOutRange());
        }
        
        
    }

    /**
     * registerConsumer
     */    
    public void registerConsumer() {
        boolean isOnRange = false, register;
        int optionType = 0;
        String cNickname, cId, cDate;
        
        System.out.println("Select a user type: \n" + 
        "1. Standard \n" +
        "2. Premium");
        optionType = validateIntegerOption();
        
        isOnRange = controller.validateRange(optionType, 1, 2);
        
        if(isOnRange) {
            
            System.out.println("Type the nickname: ");
            cNickname = scan.next();
            
            System.out.println("Type the document id: ");
            cId = scan.next();
            
            cDate = controller.getDate();
            
            switch(optionType) {
                case 1:
                    Consumer standard = new Standard(optionType, cNickname, cId, cDate);
                    
                    register = controller.registerConsumer(standard);
                    
                    if(register) {
                        System.out.println(message.msgUserRegister());
                    } else {
                        System.out.println(message.msgErrorUserRegister());
                    }
                    
                    break;
                    
                case 2:                  
                    Consumer premium = new Premium(optionType, cNickname, cId, cDate);

                    register = controller.registerConsumer(premium);

                    if(register) {
                        System.out.println(message.msgUserRegister());
                    } else {
                        System.out.println(message.msgErrorUserRegister());
                    }
                    
                    break;
            }
            
            
        } else {
            System.out.println(message.msgOutRange());
        }
    }

    /**
     * registerAudio
     */
    public void registerAudio() {
        boolean isOnRange = false, register;
        int optionType = 0, aDuration, optionGenre, optionCategory;
        double aReproductions, aCost, aUnitsSold;
        String aName, aUrl, aAlbum, aGenre, aDescription, aCategory;
        
        System.out.println("Select an audio type: \n" + 
        "1. Song \n" +
        "2. Podcast ");
        optionType = validateIntegerOption();
        
        isOnRange = controller.validateRange(optionType, 1, 2);
        
        if(isOnRange) {
            
            System.out.println("Type the name: ");
            aName = scan.next();
            
            System.out.println("Type the url: ");
            aUrl = scan.next();
            
            System.out.println("Type the duration (in minutes): ");
            aDuration = scan.nextInt();
            
            // delete reproductions
            System.out.println("Type the current total views or reproductions: ");
            aReproductions = scan.nextDouble();
            
            switch(optionType) {
                case 1:
                    System.out.println("Type the name of the album to add this song: ");
                    aAlbum = scan.next();
                    
                    System.out.println("Select a genre: \n" +
                    "1. Rock \n" +
                    "2. Pop \n" + 
                    "3. Track \n" +
                    "4. House \n");
                    optionGenre = scan.nextInt();
                    
                    isOnRange = controller.validateRange(optionGenre, 1, 4);
                    
                    if (isOnRange) {
                        
                        aGenre = controller.setGenreToSong(optionGenre);
                        
                        System.out.println("Type the cost: ");
                        aCost = scan.nextDouble();
                        
                        //delete units = 0
                        System.out.println("Type the units sold: ");
                        aUnitsSold = scan.nextDouble();
                        
                        Audio song = new Song(aAlbum, aGenre, aCost, aUnitsSold, optionType, aName, aUrl, aDuration, aReproductions);

                        register = controller.registerAudio(song);

                        if(register) {
                            System.out.println(message.msgAudioRegister());
                        } else {
                            System.out.println(message.msgErrorAudioRegister());
                        }   
                        
                    } else {
                        System.out.println(message.msgOutRange());
                    }
                    
                    break;
                    
                case 2:   
                    System.out.println("Type the description: ");
                    aDescription = scan.next();
                    
                    System.out.println("Select a category: \n" +
                    "1. Politics \n" +
                    "2. Entertainment \n" + 
                    "3. Videogame \n" +
                    "4. Fashion\n");
                    optionCategory = scan.nextInt();

                    isOnRange = controller.validateRange(optionCategory, 1, 4);
                    
                    if (isOnRange) {
                        aCategory = controller.setCategoryToPodcast(optionCategory);
                        
                        Audio podcast = new Podcast(aDescription, aCategory, optionType, aName, aUrl, aDuration, aReproductions);

                        register = controller.registerAudio(podcast);

                        if(register) {
                            System.out.println(message.msgAudioRegister());
                        } else {
                            System.out.println(message.msgErrorAudioRegister());
                        }                        
                    } else {
                        System.out.println(message.msgOutRange());
                    }
                    
                    break;
            }
            
            
        } else {
            System.out.println(message.msgOutRange());
        }
    }

    /**
     * createPlaylist
     */    
    public void createPlaylist() {
        boolean isOnRange, register;
        String pName, pCode, aName;
        int optionPlaylist, optionAudio, maxRange;
        Playlist playlist;
        
        System.out.println("Type the name of the playlist: ");
        pName = scan.next();

        System.out.println("Select a playlist type: \n" +
        "1. Only songs \n" +
        "2. Only podcasts \n" +
        "3. Podcast and songs");   
        optionPlaylist = scan.nextInt();
        
        isOnRange = controller.validateRange(optionPlaylist, 1, 3);
        
        if (isOnRange) {
            pCode = "0";
            
            switch(optionPlaylist) {
                case 1:
                    playlist = new Playlist(TypePlaylist.SONGS, pName, pCode);
                    register = controller.createPlaylist(playlist);
                    break;
                case 2:
                    playlist = new Playlist(TypePlaylist.PODCASTS, pName, pCode);
                    register = controller.createPlaylist(playlist);
                    break;
                case 3:
                    playlist = new Playlist(TypePlaylist.BOTH, pName, pCode);
                    register = controller.createPlaylist(playlist);
                    break;
            }  
            
            System.out.println(message.msgPlaylistRegister());
                
        } else {
            System.out.println(message.msgOutRange());
        }

    }
    
    /**
     * editPlaylist
     */       
    public void editPlaylist() {
        boolean isOnRange, register, hasAccess;
        String pName, pNewName, aName;
        int pPos, optionEdition, optionAudio, maxRange, optionPlaylist;
        
        System.out.println("Type the playlist name: ");
        pName = scan.next();
        
        pPos = controller.searchPlaylistByName(pName);

        if(pPos != -1) {
            
            do {
                System.out.println("What do you want to edit on the playlist? \n" +
                "1. Edit playlist name \n" +
                "2. Add a song to the playlist \n" +
                "3. Add a podcast to the playlist \n" +
                "4. Delete an audio of the playlist \n" +
                "5. Back to main menu");
                optionEdition = scan.nextInt();

                isOnRange = controller.validateRange(optionEdition, 1, 5);

                if (isOnRange) {

                    switch(optionEdition) {
                        case 1:
                            System.out.println("Type the new name of the playlist: ");
                            pNewName = scan.next();
                            controller.changePlaylistName(pName, pNewName);
                            System.out.println(message.msgPlaylistEdition());
                            break;

                        case 2:
                            hasAccess = controller.checkPlaylistType(pPos, optionEdition);
                            
                            if (hasAccess) {
                                System.out.println("Select a song of the list: \n" + controller.listAllSongs());
                                optionAudio = scan.nextInt();
                                optionAudio = (optionAudio-1);
                                maxRange = controller.countAllSongs();
                                isOnRange = controller.validateRange(optionAudio, 0, maxRange);

                                if (isOnRange) {
                                   aName = controller.getSongName(optionAudio);
                                   register = controller.registerAudioOnPlaylist(aName);

                                   if(register) {
                                       System.out.println(message.msgAudioRegister());
                                       System.out.println(message.msgPlaylistEdition());

                                       // this is to DELETE
                                       System.out.println(controller.listAllPlaylistAudios());
                                   } else {
                                       System.out.println(message.msgErrorAudioRegister());
                                   }

                                } else {
                                   System.out.println(message.msgOutRange());
                                }                               
                            } else {
                                System.out.println(message.msgErrorDifferentPlaylistType());
                            }
                            
                            break;

                        case 3:
                            System.out.println("Select a podcast of the list: \n" + controller.listAllPodcasts());
                            optionAudio = scan.nextInt();
                            optionAudio = (optionAudio-1);
                            maxRange = controller.countAllPodcasts();
                            isOnRange = controller.validateRange(optionAudio, 0, maxRange);
                            
                            if (isOnRange) {
                                aName = controller.getSongName(optionAudio);
                                register = controller.registerAudioOnPlaylist(aName);
                                
                                if(register) {
                                    System.out.println(message.msgAudioRegister());
                                    System.out.println(message.msgPlaylistEdition());
                                    
                                    // this is to DELETE
                                    System.out.println(controller.listAllPlaylistAudios());
                                } else {
                                    System.out.println(message.msgErrorAudioRegister());
                                }
                                
                            } else {
                                System.out.println(message.msgOutRange());
                            }
                            break;

                        case 4:
                            System.out.println("Select an audio of the list to delete: \n" + controller.listPlaylistAudios(pName));
                            optionAudio = scan.nextInt()-1;
                            maxRange = controller.countAllSongs();
                            isOnRange = controller.validateRange(optionAudio, 0, maxRange);
                            
                            if (isOnRange) {
                                System.out.println(controller.deletePlaylistAudio(optionAudio));
                                System.out.println(message.msgPlaylistEdition());
                            } else {
                                System.out.println(message.msgOutRange());
                            }
                            break;
                    }

                } else {
                    System.out.println(message.msgOutRange());
                }
            
            } while (optionEdition != 5);
            
        } else {
            System.out.println(message.msgErrorNameNotFound());
        }
        
    }

    /**
     * sharePlaylist
     */           
    public void sharePlaylist() {
        
    }
    
    /**
     * playAudio
     */           
    public void playAudio() {
        
    }
    
    /**
     * buySong
     */           
    public void buySong() {
        
    }
    
    /**
     * getTotalAccumulatedPlays
     */          
    public void getTotalAccumulatedPlays() {
        
    }
    
    /**
     * getMostListenedSongGenre
     */           
    public void getMostListenedSongGenre() {
        
    }
    
    /**
     * getMostListenedPodcastCategory
     */           
    public void getMostListenedPodcastCategory() {
        
    }
    
    /**
     * getInfoTopFiveProducers
     */          
    public void getInfoTopFiveProducers() {
        
    }
    
    /**
     * getInfoTopTenAudio
     */           
    public void getInfoTopTenAudio() {
        
    }

    /**
     * getSongSalesInfoByGenre
     */           
    public void getSongSalesInfoByGenre() {
        
    }

    /**
     * getSalesInfoOfBestSellingSong
     */           
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
            option = -1; 
        }

        return option; 
    }
}
