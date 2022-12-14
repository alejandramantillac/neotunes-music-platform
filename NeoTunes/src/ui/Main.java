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
        int optionType = 0, cPos, pPos;
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
            cPos = controller.checkUserNickname(pNickname, 1);
            pPos = controller.checkUserNickname(pNickname, 2);
            
            if(cPos == -1 && pPos == -1) {
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
                System.out.println(message.msgErrorNickname());
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
        int optionType = 0, cTotalSongs = 0, cTotalPlaylist = 0, cPos, pPos, sPos;
        String cNickname, cId, cDate;
        
        System.out.println("Select a user type: \n" + 
        "1. Standard \n" +
        "2. Premium");
        optionType = validateIntegerOption();
        
        isOnRange = controller.validateRange(optionType, 1, 2);
        
        if(isOnRange) {
            System.out.println("Type the nickname: ");
            cNickname = scan.next();
            
            cPos = controller.checkUserNickname(cNickname, 1);
            pPos = controller.checkUserNickname(cNickname, 2);
            
            if (cPos == -1 && pPos == -1) {
                System.out.println("Type the document id: ");
                cId = scan.next();

                cDate = controller.getDate();

                switch(optionType) {
                    case 1:
                        Consumer standard = new Standard(cTotalSongs, cTotalPlaylist, 1, cNickname, cId, cDate);

                        register = controller.registerConsumer(standard);

                        if(register) {
                            sPos = controller.checkUserNickname(cNickname, 1);
                            System.out.println(message.msgUserRegister());
                            controller.setConsumerType(sPos, 1);
                        } else {
                            System.out.println(message.msgErrorUserRegister());
                        }

                        break;

                    case 2:                  
                        Consumer premium = new Premium(cTotalSongs, cTotalPlaylist, 2, cNickname, cId, cDate);

                        register = controller.registerConsumer(premium);

                        if(register) {
                            sPos = controller.checkUserNickname(cNickname, 1);
                            System.out.println(message.msgUserRegister());
                            controller.setConsumerType(sPos, 2);
                        } else {
                            System.out.println(message.msgErrorUserRegister());
                        }

                        break;
                }               
            } else {
                System.out.println(message.msgErrorNickname());
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
        int optionType = 0, aDuration, optionGenre, optionCategory, nickPos, uType;
        double aReproductions, aCost, aUnitsSold;
        String aName, aUrl, aAlbum, aGenre, aDescription, aCategory, aNickname = "";
        
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
            
            aReproductions = 0;
            
            switch(optionType) {
                case 1:
                    System.out.println("Type the nickname of the artist user (owner): ");
                    aNickname = scan.next();

                    nickPos = controller.checkUserNickname(aNickname, 2);

                    if (nickPos == -1) {
                        System.out.println(message.msgErrorNameNotFound());

                    } else {
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
                            
                            aUnitsSold = 0;

                            Audio song = new Song(aAlbum, aGenre, aCost, aUnitsSold, aNickname, optionType, aName, aUrl, aDuration, aReproductions);

                            register = controller.registerAudio(song);

                            if(register) {
                                System.out.println(message.msgAudioRegister());
                            } else {
                                System.out.println(message.msgErrorAudioRegister());
                            }   
                            
                        } else {
                            System.out.println(message.msgOutRange());
                        }
                    }
                    
                    break;
                    
                case 2:   
                    System.out.println("Type the nickname of the content creator user (owner): ");
                    aNickname = scan.next();

                    nickPos = controller.checkUserNickname(aNickname, 2);

                    if (nickPos == -1) {
                        System.out.println(message.msgErrorNameNotFound());

                    } else {
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
                            
                            Audio podcast = new Podcast(aDescription, aCategory, aNickname, optionType, aName, aUrl, aDuration, aReproductions);

                            register = controller.registerAudio(podcast);

                            if(register) {
                                System.out.println(message.msgAudioRegister());
                            } else {
                                System.out.println(message.msgErrorAudioRegister());
                            }                        
                        } else {
                            System.out.println(message.msgOutRange());
                        }
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
        boolean isOnRange, register, isNotFull = false;
        String pName, pCode, aName, pOwner;
        int optionPlaylist, optionAudio, maxRange, ownerPos, cType;
        Playlist playlist;
        
        System.out.println("Type the nickname of the owner of the playlist: ");
        pOwner = scan.next();
        
        ownerPos = controller.checkUserNickname(pOwner, 1);
        
        if (ownerPos != -1) {
            
            cType = controller.getConsumerType(ownerPos);

            if (cType == 1) {
                isNotFull = controller.checkStandardConsumerTotalPlaylists(ownerPos);
            }

            if((cType == 1 && isNotFull) || cType == 2) {
                System.out.println("Type the name of the playlist: ");
                pName = scan.next();

                System.out.println("Select a playlist type: \n" +
                "1. Only songs \n" +
                "2. Only podcasts \n" +
                "3. Podcast and songs");   
                optionPlaylist = scan.nextInt();

                isOnRange = controller.validateRange(optionPlaylist, 1, 3);

                if (isOnRange) {
                    String [][] pMatrix = controller.generateMatrix();
                    pCode = controller.generateMatrixCode(pMatrix);

                    System.out.println("Copy the playlist id: " + pCode);

                    switch(optionPlaylist) {
                        case 1:
                            playlist = new Playlist(TypePlaylist.SONGS, pOwner, pName, pCode);
                            register = controller.createPlaylist(playlist);
                            break;
                        case 2:
                            playlist = new Playlist(TypePlaylist.PODCASTS, pOwner, pName, pCode);
                            register = controller.createPlaylist(playlist);
                            break;
                        case 3:
                            playlist = new Playlist(TypePlaylist.BOTH, pOwner, pName, pCode);
                            register = controller.createPlaylist(playlist);
                            break;
                    }  

                    System.out.println(message.msgPlaylistRegister());

                } else {
                    System.out.println(message.msgOutRange());
                }           
            } else {
                System.out.println(message.msgErrorFullPlaylist());
            }
        
        } else {
            System.out.println(message.msgErrorNameNotFound());
        }

    }
    
    /**
     * editPlaylist
     */       
    public void editPlaylist() {
        boolean isOnRange, register, hasAccess;
        String pName, pNewName, aName, pOwner;
        int pPos, optionEdition, optionAudio, maxRange, optionPlaylist, ownerPos;
        
        System.out.println("Type the nickname of the owner of the playlist: ");
        pOwner = scan.next();
        
        ownerPos = controller.checkUserNickname(pOwner, 1);
        
        if(ownerPos != -1) {
            
            System.out.println("These are the playlists of the user " + pOwner + ": \n" + controller.showPlaylistsConsumerUser(pOwner));            
            
            System.out.println("Type the playlist name that you want to edit: ");
            pName = scan.next();

            pPos = controller.checkPlaylistOwner(pName, pOwner);

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
        } else {
            System.out.println(message.msgErrorNameNotFound());
        }
        
    }

    /**
     * sharePlaylist
     */           
    public void sharePlaylist() {
        String uNickname;
        int userPos;

        System.out.println("Type the nickname of the user: ");
        uNickname = scan.next();
        
        userPos = controller.checkUserNickname(uNickname, 1);
        
        if (userPos != -1) {
            System.out.println("These are the playlists of the user " + uNickname + ": \n" + controller.showPlaylistsConsumerUser(uNickname));            
            
            System.out.println("Type the playlist name that you want to share: ");
            String pName = scan.next();

            int pPos = controller.checkPlaylistOwner(pName, uNickname);

            if (pPos != -1) {
                System.out.println("Playlist id: " + controller.showPlaylistId(pName));
                System.out.println("matrix: ");
            } else {
                System.out.println(message.msgErrorNameNotFound());
            }

        } else {
            System.out.println(message.msgErrorNameNotFound());
        }

    }
    
    /**
     * playAudio
     */           
    public void playAudio() {
        boolean isOnRange;
        String uNickname, showAd, songName;
        int userPos, cType, optionSong, maxRange, count = 0, randomAd, optionAudio;
        
        System.out.println("Type the nickname of the user: ");
        uNickname = scan.next();
        
        userPos = controller.checkUserNickname(uNickname, 1);
        
        if (userPos != -1) {
            System.out.println(controller.checkuser(userPos));

            cType = controller.getConsumerType(userPos);

            System.out.println("Choose the audio option you want to listen: \n" + "1. Song \n" + "2. Podcast");
            optionAudio = scan.nextInt();

            isOnRange = controller.validateRange(optionAudio, 1, 2);

            // song
            if (isOnRange && optionAudio == 1) {
                switch(cType) {
                    case 1:
                        // standard
                        do {
                            System.out.println("Select a song of the list: \n" + controller.listAllSongs() + "\nor if you want to back to main menu type 0");
                            optionSong = scan.nextInt()-1;
                            maxRange = controller.countAllSongs();
                            isOnRange = controller.validateRange(optionSong, -1, maxRange);  

                            if(optionSong == -1) {
                                System.out.println("Playing finished");
                            } else {
                               if (isOnRange) {
                                    
                                    if (count != 0 && count%3 == 0) {
                                        randomAd = controller.generateRandomNumber(3,1);

                                        showAd = controller.showAds(randomAd);
                                        
                                        System.out.println("Ad: " + showAd);
                                        songName = controller.getSongName(optionSong);
                                        System.out.println("Playing song: " + songName);
                                        controller.addTotalSongPlays(optionSong);
                                    } else {
                                        songName = controller.getSongName(optionSong);
                                        System.out.println("Playing song: " + songName);
                                        controller.addTotalSongPlays(optionSong);
                                    }
                                    
                                    ++count;
                                } else {
                                    System.out.println(message.msgOutRange());
                                }
                            } 
                            
                            
                        } while (optionSong != -1);   
                        break;
                        
                    case 2:
                        // premium

                        do {
                            System.out.println("Select a song of the list: \n" + controller.listAllSongs() + "\nor if you want to back to main menu type 0");
                            optionSong = scan.nextInt()-1;
                            maxRange = controller.countAllSongs();
                            isOnRange = controller.validateRange(optionSong, -1, maxRange);
                            
                            if(optionSong == -1) {
                                System.out.println("Playing finished");  
                            } else {
                                if (isOnRange) {
                                    System.out.println("Playing song: " + controller.getSongName(optionSong));
                                    controller.addTotalSongPlays(optionSong);
                                } else {
                                    System.out.println(message.msgOutRange());
                                }                            
                            }                                
                        } while (optionSong != -1);
               

                        
                        break;
                }
            } else {
                System.out.println(message.msgOutRange());
            }

            // podcast
            if (isOnRange && optionAudio == 2) {
                switch(cType) {
                    case 1:
                        // standard
                        do {
                            count = 2;
                            System.out.println("Select a podcast of the list: \n" + controller.listAllPodcasts() + "\nor if you want to back to main menu type 0");
                            optionSong = scan.nextInt()-1;
                            maxRange = controller.countAllPodcasts();
                            isOnRange = controller.validateRange(optionSong, -1, maxRange);      

                            if (optionSong == -1) {
                                System.out.println("Playing finished.");
                            } else {
                               if (isOnRange) {
                                    if (count%2 == 0) {
                                        randomAd = controller.generateRandomNumber(3,1);

                                        showAd = controller.showAds(randomAd);
                                        
                                        System.out.println("Ad: " + showAd);
                                        System.out.println("Playing podcast: " + controller.getPodcastName(optionSong));
                                        controller.addTotalPodcastPlays(optionSong);
                                    } else {
                                        System.out.println("Playing podcast: " + controller.getPodcastName(optionSong));
                                        controller.addTotalPodcastPlays(optionSong);
                                    }
                                    count++;
                                    
                                } else {
                                    System.out.println(message.msgOutRange());
                                }
                            }
                            
                            
                        } while (optionSong != -1);   
                        
                        break;

                    case 2:
                        // premium
                        do {
                            System.out.println("Select a podcast of the list: \n" + controller.listAllPodcasts() + "\n or type 0 if you want to back to main menu");
                            optionSong = scan.nextInt()-1;
                            maxRange = controller.countAllPodcasts();
                            isOnRange = controller.validateRange(optionSong, -1, maxRange);
                            
                            if (optionSong == -1) {
                                System.out.println("Playing finished.");
                            } else {
                                if (isOnRange) {
                                    System.out.println("Playing podcast: " + controller.getPodcastName(optionSong));
                                    controller.addTotalPodcastPlays(optionSong);
                                } else {
                                    System.out.println(message.msgOutRange());
                                }                                 
                            }
                    

                        } while(optionSong != -1);

                        break;
                }
            }

        } else {
            System.out.println(message.msgErrorNameNotFound());
        }
    }
    
    
    /**
     * buySong
     */           
    public void buySong() {
        boolean isOnRange, isNotFull;
        String cNickname;
        int cPos, optionSong, maxRange, cType;
        Song song;
        
        System.out.println("Type the nickname of the consumer user: ");
        cNickname = scan.next();
        
        cPos = controller.checkUserNickname(cNickname, 1);    
        
        if (cPos != -1) {
            System.out.println("Select a song of the list: \n" + controller.listAllSongs());
            optionSong = scan.nextInt()-1;
            maxRange = controller.countAllSongs();
            isOnRange = controller.validateRange(optionSong, 0, maxRange);
            
            if (isOnRange) {
                System.out.println("The cost of this song is: " + controller.getSongCost(optionSong) + " dollars.");
                song = controller.getSong(optionSong);
                controller.setSongPurchase(optionSong, song);
                
                cType = controller.getConsumerType(cPos);
                
                switch(cType) {
                    case 1:
                        // standard user
                        isNotFull = controller.checkStandardConsumerTotalSongs(cPos);
                        
                        if(isNotFull) {
                            controller.updateConsumerPurchasedSongs(cPos);
                        } else {
                            System.out.println(message.msgErrorPurchaseSong());
                        }
                        break;
                        
                    case 2:
                        // premium user
                        controller.updateConsumerPurchasedSongs(cPos);
                        break;
                }
                
                System.out.println(message.msgSuccesfullPurchase());    
            } else {
                System.out.println(message.msgOutRange());
            }
            
        } else {
            System.out.println(message.msgErrorNameNotFound());
        }
    }
    
    /**
     * getTotalAccumulatedPlays
     */          
    public void getTotalAccumulatedPlays() {
        System.out.println("Songs: \n" + controller.getTotalAccumulatedSongPlays());

        System.out.println("Podcasts: \n" + controller.getTotalAccumulatedPodcastPlays());
    }
    
    /**
     * getMostListenedSongGenre
     */           
    public void getMostListenedSongGenre() {
        // all platform
        System.out.println("The most listened song genre is: " + controller.getMostListenedSongGenre() + " with " + controller.getmostListenedPlaysSong() + " plays. ");
    }
    
    /**
     * getMostListenedPodcastCategory
     */           
    public void getMostListenedPodcastCategory() {
        // all platform
        System.out.println("The most listened podcast category is: " + controller.getMostListenedPodcastCategory() + "with " + controller.getmostListenedPlaysPodcast() + "plays. ");       
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
        controller.getSongsSoldByGenre();
        controller.getSongsCostsByGenre();
        controller.calculateProfitsByGenre();

        System.out.println("# Rock \n" + "Number of songs sold:" + controller.getRockSales() + " \n Total sales value: " + controller.getRockProfits());
        System.out.println("# Pop \n" + "Number of songs sold:" + controller.getPopSales() + " \n Total sales value: " + controller.getPopProfits());
        System.out.println("# Trap \n" + "Number of songs sold:" + controller.getTrapSales() + " \n Total sales value: " + controller.getTrapProfits());
        System.out.println("# House \n" + "Number of songs sold:" + controller.getHouseSales() + " \n Total sales value: " + controller.getHouseProfits());

    }

    /**
     * getSalesInfoOfBestSellingSong
     */           
    public void getSalesInfoOfBestSellingSong() {
        int positionBest = controller.getPositionOfBestSellingSong();
        double totalSales = controller.getTotalSalesBestSellingSong(positionBest);
        double totalCost = controller.getCostBestSellingSong(positionBest);
        String songName = controller.getNameBestSellingSong(positionBest);

        System.out.println("Best selling song: " + songName + "\n" + ". Total sales: " + totalSales + "\n" + "Total value (money): " + totalCost);
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
