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



    // delete
    private Artist artist;
    private ContentCreator contentc;
    private Standard standard;
    private Premium premium;
    private Song song;
    private Podcast podcast;

    private int rock = 0;
    private int pop = 0; 
    private int trap = 0;
    private int house = 0; 
    private int mostListenedPlaysSong = 0;

    private int politics = 0;
    private int entertainment = 0;
    private int videogame = 0; 
    private int fashion = 0;
    private int mostListenedPlaysPodcast = 0;

    private double rockTotalSales = 0;
    private double popTotalSales = 0;
    private double trapTotalSales = 0;
    private double houseTotalSales = 0;

    private double rockCostsSales = 0;
    private double popCostsSales = 0;
    private double trapCostsSales = 0;
    private double houseCostsSales = 0;

    private double rockProfits = 0;
    private double popProfits = 0;
    private double trapProfits = 0;
    private double houseProfits = 0;   



    public Controller() {
        producers = new ArrayList<Producer>();
        consumers = new ArrayList<Consumer>();
        audios = new ArrayList<Audio>();
        playlists = new ArrayList<Playlist>();
        playlist = new Playlist(TypePlaylist.BOTH,"Default", "Default", "000");

        artist = new Artist("artist", "www", 1, "artist", "1111", "1111");
        contentc = new ContentCreator("content", "www", 2, "content", "2222", "2222");
        standard = new Standard(2, 2, 1, "standard", "standard", "1111");
        premium = new Premium(2, 2, 2, "premium", "premium", "1111");
        song = new Song("a", "POP", 1.000, 5.0, "artist", 1, "song1", "www", 5, 10);
        podcast = new Podcast("aaa", "FASHION", "content", 2, "podcast1", "www", 2, 4);

        consumers.add(standard);
        consumers.add(premium);
        producers.add(artist);
        producers.add(contentc);
        audios.add(song);
        audios.add(podcast);

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
     * addTotalSongPlays adds one more playback to a song when a user plays it.
     * @param songPos represents the position of the song.
     */
    public void addTotalSongPlays(int songPos) {
        double currentPlays = audios.get(songPos).getReproductions();
        audios.get(songPos).setReproductions(currentPlays+1);        
    }

    /**
     * addTotalPodcastPlays adds one more playback to a podcast when a user plays it.
     * @param podcastPos represents the position of the podcast.
     */
    public void addTotalPodcastPlays(int podcastPos) {
        double currentPlays = audios.get(podcastPos).getReproductions();
        audios.get(podcastPos).setReproductions(currentPlays+1);        
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

        Song song = new Song("", "", 0.0, 0.0, "", 0, "", "", 0, 0.0);
        
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
     * getPodcastName get the name of a specific podcast with the position.
     * @param optionAudio represents the audio's position.
     * @return podcastName represents the name of the podcast.
     */    
    public String getPodcastName(int optionAudio) {
        String podcastName = "";
        
        for (int i = 0; i < audios.size(); i++) {
            if(audios.get(optionAudio) instanceof Podcast){
                podcastName = ((Podcast)(audios.get(optionAudio))).getName();
            }
        }     
                
        return podcastName;
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
     * @return pPos
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
     * @return number represents the string number.
     */    
    public String generateRandomStringNumber() {
        int number = (int) (Math.random() * 9) + 1;
        
        return String.valueOf(number);
    }

    /**
     * generateRandomNumber generates a random number according to a range.
     * @param max represents the maximun value.
     * @param min represents the minimun value.
     * @return opInt represents the result.
     */
    public int generateRandomNumber(int max, int min) {
        double opDouble = Math.random() * (max - min + 1) + min;
        int opInt = (int) opDouble;

        return opInt;
    }

    /**
     * showAds show the ads to the standard consumer user.
     * @param randomAd show an specific add according to a random number.
     * @return ad represents the ad.
     */
    public String showAds(int randomAd) {
        String ad = "";

        switch(randomAd) {
        case 1:
            ad = "Nike - Just Do It.";
            break;
        case 2:
            ad = "Coca-Cola - Open Happiness.";
            break;

        case 3:
            ad = "M&Ms - Melts in Your Mouth, Not in Your Hands.";
            break;
        }

        return ad;
    }

    /**
     * generateMatrix creates the matrix.
     * @return matrixId represents the matrix id.
     */    
    public String [][] generateMatrix() {

        String matrixId[][] = new String[6][6];
        
        for(int i=0; i<6; i++){
            for(int j=0; i<6; i++){
                matrixId[i][j] = generateRandomStringNumber();
            }
        }

        return matrixId;
        
    }



    /**
     * generateMatrixCode generates an id code.
     * @param matrixId represents the matrix.
     * @return code represents the id code.
     */
    public String generateMatrixCode(String[][] matrixId) {
        String code = "";

        for (int i = 0; i < matrixId.length; i++) { 
            for (int j = 0; j < matrixId[i].length; j++) {
                if (matrixId[i][j] != null ) {
                    code += matrixId[i][j];
                    code += matrixId[i][j];
                    code += matrixId[i][j];
                }
        }
      }
  
      return code;
    }

    /**
     * showPlaylistId show the id of a playlist.
     * @param pName represents the name of the playlist.
     * @return pId represents the id code of the playlist.
     */
    public String showPlaylistId(String pName) {
        String pId = "";

        for(int i = 0; i < playlists.size(); i++) {
            if (playlists.get(i).getName().equals(pName)) {
                pId = playlists.get(i).getNumericCode();
            }

        }

        return pId;
    }

    /**
     * getTotalAccumulatedSongPlays gets the total number of plays of all songs.
     * @return songsList represents the list of the songs.
     */
    public String getTotalAccumulatedSongPlays() {
        String songsList = "";
        
        for (int i = 0; i < audios.size(); i++) {
            if(audios.get(i) instanceof Song){
                songsList += "Total plays: " + ((Song)(audios.get(i))).getReproductions();
            }
        }
        
        return songsList;  
    }

    /**
     * getTotalAccumulatedPodcastPlays gets the total number of plays of all podcasts.
     * @return podcastList represents the list of the podcasts.
     */
    public String getTotalAccumulatedPodcastPlays() {
        String podcastList = "";
        
        for (int i = 0; i < audios.size(); i++) {
            if(audios.get(i) instanceof Podcast){
                podcastList += "Total plays: " + ((Podcast)(audios.get(i))).getReproductions();
            }
        }
        
        return podcastList;  
    }
   
   /**
    * getMostListenedSongGenre gets the most listened song genre on the platform.
    * @return mostListened represents the genre most listened.
    */
    public String getMostListenedSongGenre() {
        String theGenre = "";
        String mostListened = "";

        
        for (int i = 0; i < audios.size(); i++) {

            if(audios.get(i) instanceof Song){
                theGenre = ((Song)(audios.get(i))).getGenre();
                if(theGenre.equals("ROCK")) {
                    rock += ((Song)(audios.get(i))).getReproductions();
                }
            }

        }

        for (int i = 0; i < audios.size(); i++) {

            if(audios.get(i) instanceof Song){
                theGenre = ((Song)(audios.get(i))).getGenre();
                if(theGenre.equals("POP")) {
                    pop += ((Song)(audios.get(i))).getReproductions();
                }
            }
            
        }

        for (int i = 0; i < audios.size(); i++) {

            if(audios.get(i) instanceof Song){
                theGenre = ((Song)(audios.get(i))).getGenre();
                if(theGenre.equals("TRAP")) {
                    trap += ((Song)(audios.get(i))).getReproductions();
                }
            }
            
        }

        for (int i = 0; i < audios.size(); i++) {

            if(audios.get(i) instanceof Song){
                theGenre = ((Song)(audios.get(i))).getGenre();
                if(theGenre.equals("HOUSE")) {
                    house += ((Song)(audios.get(i))).getReproductions();
                }
            }
            
        }

        if (rock > pop && rock > trap && rock > house) {
            mostListened = "ROCK";
        } else if (pop > rock && pop > trap && pop > house) {
            mostListened = "POP";
        } else if (trap > rock && trap > pop && trap > house) {
            mostListened = "TRAP";
        } else {
            mostListened = "HOUSE";
        }

        switch(mostListened) {
            case "ROCK":
                mostListenedPlaysSong = rock;
                break;

            case "POP":
                mostListenedPlaysSong = pop;
                break;

            case "TRAP":
                mostListenedPlaysSong = trap;
                break;

            case "HOUSE":
                mostListenedPlaysSong = house;
                break;
        }

        return mostListened;
    }

    /**
     * getmostListenedPlaysSong gets the number of plays of the most listened song.
     * @return mostListenedPlaysSong represents the number of plays of the most listened song.
     */
    public int getmostListenedPlaysSong() {
        return mostListenedPlaysSong;
    }

    /**
     * getMostListenedPodcastCategory gets the most listened podcast category on the platform.
     * @return mostListened represents the podcast category most listened.
     */
    public String getMostListenedPodcastCategory() {
        String theCategory = "";
        String mostListened = "";

        
        for (int i = 0; i < audios.size(); i++) {

            if(audios.get(i) instanceof Podcast){
                theCategory = ((Podcast)(audios.get(i))).getCategory();
                if(theCategory.equals("POLITICS")) {
                    politics += ((Podcast)(audios.get(i))).getReproductions();
                }
            }

        }

        for (int i = 0; i < audios.size(); i++) {

            if(audios.get(i) instanceof Podcast){
                theCategory = ((Podcast)(audios.get(i))).getCategory();
                if(theCategory.equals("ENTERTAINMENT")) {
                    entertainment += ((Podcast)(audios.get(i))).getReproductions();
                }
            }
            
        }

        for (int i = 0; i < audios.size(); i++) {

            if(audios.get(i) instanceof Podcast){
                theCategory = ((Podcast)(audios.get(i))).getCategory();
                if(theCategory.equals("VIDEOGAME")) {
                    videogame += ((Podcast)(audios.get(i))).getReproductions();
                }
            }
            
        }

        for (int i = 0; i < audios.size(); i++) {

            if(audios.get(i) instanceof Podcast){
                theCategory = ((Podcast)(audios.get(i))).getCategory();
                if(theCategory.equals("FASHION")) {
                    fashion += ((Podcast)(audios.get(i))).getReproductions();
                }
            }
            
        }

        if (politics > entertainment && politics > videogame && politics > fashion) {
            mostListened = "POLITICS";
        } else if (entertainment > politics && entertainment > videogame && entertainment > fashion) {
            mostListened = "ENTERTAINMENT";
        } else if (videogame > politics && videogame > entertainment && videogame > fashion) {
            mostListened = "VIDEOGAME";
        } else {
            mostListened = "FASHION";
        }

        switch(mostListened) {
            case "POLITICS":
                mostListenedPlaysPodcast = politics;
                break;

            case "ENTERTAINMENT":
                mostListenedPlaysPodcast = entertainment;
                break;

            case "VIDEOGAME":
                mostListenedPlaysPodcast = videogame;
                break;

            case "FASHION":
                mostListenedPlaysPodcast = fashion;
                break;
        }

        return mostListened;
    }

    /**
     * getmostListenedPlaysPodcast gets the number of plays of the most listened podcast.
     * @return mostListenedPlaysPodcast represents the number of plays of the most listened podcast.
     */
    public int getmostListenedPlaysPodcast() {
        return mostListenedPlaysPodcast;
    }


    /**
     * getPositionOfBestSellingSong gets the position of the best selling song.
     * @return positionBest represents the position of the song.
     */
    public int getPositionOfBestSellingSong() {
        int positionBest = 0;
        int positionNew = 0;
        double currentSales = ((Song)(audios.get(0))).getSales();
        double topSales = 0.0;
        
        for (int i = 0; i < audios.size(); i++) {
            if(audios.get(i) instanceof Song){
                topSales = ((Song)(audios.get(i))).getSales();
                if (topSales > currentSales) {
                    positionBest = i;
                }
            }
        }
        
        return positionBest;        
    }

    /**
     * getTotalSalesBestSellingSong gets the total sales of the best selling song.
     * @param positionBest represents the position of the song.
     * @return totalSales represents the total sales of the song.
     */
    public double getTotalSalesBestSellingSong(int positionBest) {
        double totalSales = 0;

        if(audios.get(positionBest) instanceof Song){
            totalSales = ((Song)(audios.get(positionBest))).getSales();
        }

        return totalSales;
    }

    /**
     * getCostBestSellingSong gets the cost of the best selling song.
     * @param positionBest represents the position of the song.
     * @return totalCost represents the cost of the song.
     */
    public double getCostBestSellingSong(int positionBest) {
        double totalCost = 0;

        if(audios.get(positionBest) instanceof Song){
            totalCost = ((Song)(audios.get(positionBest))).getCost();
        }

        return totalCost;
    }

    /**
     * getNameBestSellingSong gets the name of the best selling song.
     * @param positionBest represents the position of the song.
     * @return nameSong represents the name of the song.
     * */
    public String getNameBestSellingSong(int positionBest) {
        String nameSong = "";
        if(audios.get(positionBest) instanceof Song){
            nameSong = ((Song)(audios.get(positionBest))).getName();
        }

        return nameSong;
    }

    /**
     * getSongsSoldByGenre calculates the total amount of sales for each song genre.
     */
    public void getSongsSoldByGenre() {
        String theGenre = "";

        for (int i = 0; i < audios.size(); i++) {
            if(audios.get(i) instanceof Song){
                theGenre = ((Song)(audios.get(i))).getGenre();
                if(theGenre.equals("ROCK")) {
                    rockTotalSales += ((Song)(audios.get(i))).getSales();
                } else if(theGenre.equals("POP")) {
                    popTotalSales += ((Song)(audios.get(i))).getSales();
                } else if(theGenre.equals("TRAP")) {
                    trapTotalSales += ((Song)(audios.get(i))).getSales();
                } else {
                    houseTotalSales += ((Song)(audios.get(i))).getSales();
                }
            }
        }
    }

    /**
     * getSongsCostsByGenre calculates the total amount of earnings for each song genre.
     */
    public void getSongsCostsByGenre() {
        String theGenre = "";

        for (int i = 0; i < audios.size(); i++) {
            if(audios.get(i) instanceof Song){
                theGenre = ((Song)(audios.get(i))).getGenre();
                if(theGenre.equals("ROCK")) {
                    rockCostsSales += ((Song)(audios.get(i))).getCost();
                } else if(theGenre.equals("POP")) {
                    popCostsSales += ((Song)(audios.get(i))).getCost();
                } else if(theGenre.equals("TRAP")) {
                    trapCostsSales += ((Song)(audios.get(i))).getCost();
                } else {
                    houseCostsSales += ((Song)(audios.get(i))).getCost();
                }
            }
        }
    }

    /**
     * calculateProfitsByGenre calculates the sales revenue for each song genre.
     */
    public void calculateProfitsByGenre() {
        rockProfits = rockTotalSales * rockCostsSales;
        popProfits = popTotalSales * popCostsSales;
        trapProfits = trapTotalSales * trapCostsSales;
        houseProfits = houseTotalSales * houseCostsSales;
    }

    /**
     * getRockSales obtains the number of total sales of the rock genre.
     * @return rockTotalSales represents the total sales.
     */
    public double getRockSales() {
        return rockTotalSales;
    }

    /**
     * getPopSales obtains the number of total sales of the pop genre.
     * @return popTotalSales represents the total sales.
     */
    public double getPopSales() {
        return popTotalSales;
    }

    /**
     * getTrapSales obtains the number of total sales of the trap genre.
     * @return trapTotalSales represents the total sales.
     */
    public double getTrapSales() {
        return trapTotalSales;
    }

    /**
     * getHouseSales obtains the number of total sales of the house genre.
     * @return houseTotalSales represents the total sales.
     */
    public double getHouseSales() {
        return houseTotalSales;
    }    

    /**
     * getRockProfits obtains the total sales in the rock genre.
     * @return rockProfits represents the profits of the genre.
     */
    public double getRockProfits() {
        return rockProfits;
    }

    /**
     * getPopProfits obtains the total sales in the pop genre.
     * @return popProfits represents the profits of the genre.
     */
    public double getPopProfits() {
        return popProfits;
    }

    /**
     * getTrapProfits obtains the total sales in the trap genre.
     * @return trapProfits represents the profits of the genre.
     */
    public double getTrapProfits() {
        return trapProfits;
    }

    /**
     * getHouseProfits obtains the total sales in the house genre.
     * @return houseProfits represents the profits of the genre.
     */
    public double getHouseProfits() {
        return houseProfits;
    }



}
