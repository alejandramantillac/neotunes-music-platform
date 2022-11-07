package model;

import model.Playlist;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class Controller {
        
    public static final int MAX_STANDARD_PLAYLIST = 21;
    public static final int MAX_STANDARD_SONGS = 101;

    private ArrayList<Producer> producers; 
    private ArrayList<Consumer> consumers; 
    private ArrayList<Audio> audios; 
    private ArrayList<Playlist> playlists; 
    private Playlist playlist;

    public Controller() {
        producers = new ArrayList<Producer>();
        consumers = new ArrayList<Consumer>();
        audios = new ArrayList<Audio>();
        playlists = new ArrayList<Playlist>();
        playlist = new Playlist(TypePlaylist.BOTH,"Default", "Default", "000");
    }
    
    public ArrayList<Producer> getProducers(){
            return producers;
    }
    
    public ArrayList<Consumer> getConsumers(){
            return consumers;
    }
    
    public ArrayList<Audio> getAudios(){
            return audios;
    }
    
    public ArrayList<Playlist> getPlaylists(){
            return playlists;
    }
    
    public Playlist getPlaylist() {
        return playlist;
    }
        
    /**
     * validateRange checks if a given number falls within a specific range.
     * @param num represents the number to evaluate.
     * @param min represents the minimum value on the range.
     * @param max represents the maximun value on the range.
     * @return isOnRange represents the response (true or false).
     */
    public boolean validateRange(int num, int min, int max) {
        boolean isOnRange = false;
        
        if (num >= min && num <= max) {
            isOnRange = true;
        }
        
        return isOnRange;
    }
    
    /**
     * getDate get the current date.
     * @return newDate represents the current date in String format.
     */    
    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        Date currentDate = new Date();
        
        String newDate = sdf.format(currentDate);
        
        return newDate;
    }
    
    /**
     * setGenreToSong sets the genre of a song according to the chosen option. 
     * @param optionGenre represents the option chosen by the user.
     * @return aGenre represents the genre to assign.
     */    
    public String setGenreToSong(int optionGenre) {
        String aGenre = "";
        switch(optionGenre) {
            case 1:
                aGenre = Genre.ROCK.toString();
                break;
            case 2:
                aGenre = Genre.POP.toString();
                break;
                
            case 3:
                aGenre = Genre.TRAP.toString();
                break;
                
            case 4:
                aGenre = Genre.HOUSE.toString();
                break;
        }
        
        return aGenre;
    }
    
    /**
     * setCategoryToPodcast sets the category of a podcast according to the chosen option. 
     * @param optionCategory represents the option chosen by the user.
     * @return aCategory represents the category to assign.
     */    
    public String setCategoryToPodcast(int optionCategory) {
        String aCategory = "";
        switch(optionCategory) {
            case 1:
                aCategory = Category.POLITICS.toString();
                break;
            case 2:
                aCategory = Category.ENTERTAINMENT.toString();
                break;
                
            case 3:
                aCategory = Category.VIDEOGAME.toString();
                break;
                
            case 4:
                aCategory = Category.FASHION.toString();
                break;
        }
        
        return aCategory;
    }
    
    /**
     * checkConsumerNickname verifies and gets the position of a given nickname.
     * @param uNickname represents user nickname.
     * @param type represents the user type (consumer or producer).
     * @return pos
     */
    public int checkUserNickname(String uNickname, int type) {
        int pos = -1;
        
        switch(type) {
            case 1:
                for(int i = 0; i < consumers.size(); i++) {
                    if(consumers.get(i).getNickname().equals(uNickname)) {
                        pos = i;
                    }
                }     
                break;
                
            case 2:
                for(int i = 0; i < producers.size(); i++) {
                    if(producers.get(i).getNickname().equals(uNickname)) {
                        pos = i;
                    }
                }     
                break;
        }

        return pos;
    }
    
    /**
     * getConsumerType gets the type of consumer user (standard or premium).
     * @param cPos represents the consumer position.
     * @return cType represents the type of consumer.
     */
    public int getConsumerType(int cPos) {
             
        int cType = consumers.get(cPos).getType();
        
        return cType;
    }
    
    /**
     * getProducerType gets the type of consumer user (standard or premium).
     * @param cPos represents the consumer position.
     * @return cType represents the type of consumer.
     */
    public int getProducerType(int cPos) {
             
        int cType = producers.get(cPos).getType();
        System.out.println("ctype is" + cType);
        
        return cType;
    }
    
    public String checkuser(int cPos) {
             
        String cType = consumers.get(cPos).toString();
        
        return cType;
    }
 
    /**
     * checkStandardConsumerTotalSongs verifies whether or not a standard user has the capacity to buy more songs.
     * @param cPos represents the costumer position.
     * @return isEmpty represents the response (true or false).
     */
    public boolean checkStandardConsumerTotalSongs(int cPos) {
        boolean isEmpty = false;
        
        int currentSongs = consumers.get(cPos).getTotalSongs();
        
        if (currentSongs < MAX_STANDARD_SONGS) {
            isEmpty = true;
        }
        
        return isEmpty;
    }
    
    /**
     * checkStandardConsumerTotalPlaylists verifies whether or not a standard user has the capacity to create more playlists.
     * @param cPos represents the consumer position.
     * @return isEmpty represents the response (true or false).
     */   
    public boolean checkStandardConsumerTotalPlaylists(int cPos) {
        boolean isEmpty = false;

        int currentPlaylists = consumers.get(cPos).getTotalPlaylists();
  
        if (currentPlaylists < MAX_STANDARD_PLAYLIST) {
            isEmpty = true;
        }
        
        return isEmpty;
    }
    
    /**
     * updateConsumerPurchasedSongs updates the number of songs purchased by a consumer user.
     * @param cPos represents the consumer position.
     */  
    public void updateConsumerPurchasedSongs(int cPos) {
        int currentSongs = consumers.get(cPos).getTotalSongs();
        
        consumers.get(cPos).setTotalSongs(currentSongs+1);       
    }

    /**
     * updateConsumerPlaylistsCreated updates the number of playlists created by a consumer user.
     * @param cPos represents the consumer position.
     */
    public void updateConsumerPlaylistsCreated(int cPos) {
        int currentPlaylists = consumers.get(cPos).getTotalPlaylists();
        
        consumers.get(cPos).setTotalSongs(currentPlaylists+1);               
    }
    
    public void setConsumerType(int cPos, int cType) {     
        if (cType == 1) {
            consumers.get(cPos).setType(1);                          
        } else {
            consumers.get(cPos).setType(2);               
        }
    }

    /**
     * showPlaylistsConsumerUser displays all songs of a specific consumer user.
     * @param pOwner represents the nickname of the owner of the playlist.
     * @return consumerPlaylists represents the playlists names of the owner.
     */
    public String showPlaylistsConsumerUser(String pOwner) {
        String consumerPlaylists = "";
        
        for (int i = 0; i < playlists.size(); i++) {
            if(playlists.get(i).getOwnerNickname().equals(pOwner)) {
                consumerPlaylists += playlists.get(i).getName() + "\n";
            }
        }
        
        return consumerPlaylists;
    }
    
    /**
     * registerProducer adds a producer user to the producers' arraylist.
     * @param producer represents a Producer object.
     */   
    public boolean registerProducer(Producer producer) {
        return producers.add(producer);
    }
    
    /**
     * registerConsumer adds a consumer user to the consumers' arraylist.
     * @param consumer represents a Consumer object.
     */    
    public boolean registerConsumer(Consumer consumer) {
        return consumers.add(consumer);
    }
    
    /**
     * registerAudio adds an audio to the audios' arraylist.
     * @param audio represents an Audio object.
     */    
    public boolean registerAudio(Audio audio) {
        return audios.add(audio);
    }
    
    /**
     * createPlaylist adds a playlist to the playlists' arraylist.
     * @param playlist represents a Playlist object.
     */    
    public boolean createPlaylist(Playlist playlist) {
        return playlists.add(playlist);
    }
    
    /**
     * listAllSongs displays the list of all registered songs.
     * @return songsList represents the songs list.
     */    
    public String listAllSongs() {
        String songsList = "";
        
        for (int i = 0; i < audios.size(); i++) {
            if(audios.get(i) instanceof Song){
                    songsList += (i+1) + ". "+ ((Song)(audios.get(i))).getName() + "\n";
            }
        }
        
        return songsList;
    }
    
    /**
     * getSongCost obtains the cost of a specific song.
     * @param optionSong represents the song position.
     * @return cost represents the song cost.
     */   
    public double getSongCost(int optionSong) {
        double cost = 0;
        
        if(audios.get(optionSong) instanceof Song){
            cost = ((Song)(audios.get(optionSong))).getCost();
        }
        
        return cost;
    }
    
    /**
     * listPlaylistAudios shows the list of audios of a specific playlist.
     * @param pName represents the name of the playlist.
     * @return playlistAudios represents the list of audios.
     */   
    public String listPlaylistAudios(String pName) {
        String playlistAudios = "";
        for (int i = 0; i < playlists.size(); i++) {
            if (playlists.get(i).getName().equals(pName)) {
                playlistAudios = playlist.listPlaylistAudios();         
            }
        }
        return playlistAudios;
    }
    
    /**
     * countAllSongs counts the total number of registered songs.
     * @return countSongs represents the total number of registered songs.
     */    
    public int countAllSongs() {
        int countSongs = 0;
        
        for (int i = 0; i < audios.size(); i++) {
            if(audios.get(i) instanceof Song){
                countSongs++;
            }
        }      
        
        return countSongs;
    }

    /**
     * getSong gets an object of type Song.
     * @param optionSong represents the object's position.
     * @return song represents the Song object.
     */    
    public Song getSong(int optionSong) {

        Song song = new Song("", "", 0.0, 0.0, 0, "", "", 0, 0.0);
        
        if(audios.get(optionSong) instanceof Song){
            song = ((Song)(audios.get(optionSong)));
        }

        return song;
    }
    
    /**
     * setSongPurchase updates the number of sales of a specific song.
     * @param optionSong represents the song's position.
     * @param song represents the Song object.
     */    
    public void setSongPurchase(int optionSong, Song song) {
        double currentSales = 0;
        double newSales = 0;
        
        if(audios.get(optionSong) instanceof Song) {
            System.out.println("song is: " + audios.get(optionSong).getName());
            currentSales = ((Song)song).getSales();
            ((Song)song).setSales(currentSales+1);
        }
           
    }
    
    /**
     * getSongName get the name of a specific song with the position.
     * @param optionAudio represents the audio's position.
     * @return songName represents the name of the song.
     */    
    public String getSongName(int optionAudio) {
        String songName = "";
        
        for (int i = 0; i < audios.size(); i++) {
            if(audios.get(optionAudio) instanceof Song){
                songName = ((Song)(audios.get(optionAudio))).getName();
            }
        }     
                
        return songName;
    }

    /**
     * listAllPodcasts displays a list of all registered podcasts.
     * @return podcastList represents the list of the podcasts.
     */    
    public String listAllPodcasts() {
        String podcastList = "";
        
        for (int i = 0; i < audios.size(); i++) {
            if(audios.get(i) instanceof Podcast){
                    podcastList += (i+1) + ". "+ ((Podcast)(audios.get(i))).getName() + "\n";
            }
        }
        
        return podcastList;
    }
    
    /**
     * countAllPodcasts counts the number of registered podcasts.
     * @return countPodcasts represents the total number of registered podcasts.
     */    
    public int countAllPodcasts() {
        int countPodcasts = 0;
        
        for (int i = 0; i < audios.size(); i++) {
            if(audios.get(i) instanceof Podcast){
                countPodcasts++;
            }
        }      
        
        return countPodcasts;
    }
   
    /**
     * registerAudioOnPlaylist adds a new audio to a playlist.
     * @param audioName represents the name of the audio.
     * @return 
     */
    public boolean registerAudioOnPlaylist(String audioName) {
        return playlist.registerListAudios(audioName);
    }
    
    /**
     * listAllPlaylistAudios displays a list of all the audios in a playlist.
     * @return playlistAudio represents the list of audios.
     */   
    public String listAllPlaylistAudios() {
        String playlistAudio = "";
        
        for (int i = 0; i < audios.size(); i++) {
            playlistAudio += playlist.getListAudios();
        }
        
        return playlistAudio;
    }
    
    /**
     * searchPlaylistByName searches for the position of a playlist according to its name.
     * @param pName represents the playlist's name.
     * @return pPos represents the playlist's position.
     */   
    public int searchPlaylistByName(String pName) {
        int pPos = -1;
        
        for(int i = 0; i < playlists.size(); i++) {
            if(playlists.get(i).getName().equals(pName)) {
                pPos = i;
            }
        }    
        
        return pPos;
    }
    
    /**
     * checkPlaylistOwner verifies if a playlist belongs to a certain person.
     * @param pName represents the name of the playlist.
     * @param pOwner represents the nickname of the playlist's owner.
     * @return pPos represents the playlist's position.
     */    
    public int checkPlaylistOwner(String pName, String pOwner) {
    int pPos = -1;

        for(int i = 0; i < playlists.size(); i++) {
            if(playlists.get(i).getName().equals(pName) && playlists.get(i).getOwnerNickname().equals(pOwner)) {
                pPos = i;
            }
        }    

        return pPos;
    }
 
    /**
     * changePlaylistName rename a playlist.
     * @param pName represents the current playlist's name.
     * @param pNewName represents the new playlist's name.
     */
    public void changePlaylistName(String pName, String pNewName) {
        int pPos = searchPlaylistByName(pName);
        
        playlists.get(pPos).setName(pNewName);
    }
    
    /**
     * deletePlaylistAudio deletes an audio from a playlist.
     * @param pPos represents the audio's position.
     * @return  
     */    
    public String deletePlaylistAudio(int pPos) {
        return playlist.deletePlaylistAudio(pPos);
    }
    
    /**
     * checkPlaylistType check the type of playlist (songs only, podcast only, or both).
     * @param pPos represents the playlist's position.
     * @param optionEdition represents the option chosen.
     * @return hasAccess represents the response (true or false).
     */    
    public boolean checkPlaylistType(int pPos, int optionEdition) {
        boolean hasAccess = false;
        
        switch(optionEdition) {
            case 2:
                if ((playlists.get(pPos).getType().equals(TypePlaylist.SONGS)) || (playlists.get(pPos).getType().equals(TypePlaylist.BOTH)))  {       
                    hasAccess = true;
                }
                break;
                
            case 3: 
                if ((playlists.get(pPos).getType().equals(TypePlaylist.PODCASTS)) || (playlists.get(pPos).getType().equals(TypePlaylist.BOTH)))  {       
                    hasAccess = true;
                }
                break;
        }
        
        return hasAccess;
    }
    
    /**
     * generateRandomStringNumber generates a random number and converts it to String data type.
     * @return 
     */    
    public String generateRandomStringNumber() {
        int number = (int) (Math.random() * 9) + 1;
        
        return String.valueOf(number);
    }

    /**
     * generateMatriz
     */    
    public String generateMatrix() {
        
        return "";
    }
   
}
