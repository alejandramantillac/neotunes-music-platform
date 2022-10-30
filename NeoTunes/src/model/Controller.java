package model;

import model.Playlist;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class Controller {

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
        playlist = new Playlist(TypePlaylist.BOTH,"Default", "000");
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
     * validateRange
     * @param num
     * @param min
     * @param max
     * @return isOnRange
     */
    public boolean validateRange(int num, int min, int max) {
        boolean isOnRange = false;
        
        if (num >= min && num <= max) {
            isOnRange = true;
        }
        
        return isOnRange;
    }
    
    /**
     * getDate
     * @return newDate
     */    
    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        Date currentDate = new Date();
        
        String newDate = sdf.format(currentDate);
        
        return newDate;
    }
    
    /**
     * setGenreToSong
     * @param optionGenre
     * @return aGenre
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
     * setCategoryToPodcast
     * @param optionCategory
     * @return aCategory
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
     * registerProducer
     * @param producer
     */   
    public boolean registerProducer(Producer producer) {
        return producers.add(producer);
    }
    
    /**
     * registerConsumer
     * @param consumer
     */    
    public boolean registerConsumer(Consumer consumer) {
        return consumers.add(consumer);
    }
    
    /**
     * registerAudio
     * @param audio
     */    
    public boolean registerAudio(Audio audio) {
        return audios.add(audio);
    }
    
    /**
     * createPlaylist
     * @param playlist
     */    
    public boolean createPlaylist(Playlist playlist) {
        return playlists.add(playlist);
    }
    
    /**
     * listAllSongs
     * @return songsList
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
     * listPlaylistAudios
     * @param pName
     * @return playlistAudios
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
     * countAllSongs
     * @return countSongs
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
     * getSongName
     * @param optionAudio
     * @return songName
     */    
    public String getSongName(int optionAudio) {
        String songName = "";
        for (int i = 0; i < audios.size(); i++) {
            if(audios.get(optionAudio) instanceof Song){
                songName = ((Song)(audios.get(optionAudio))).getName();
            }
        }     
        
        System.out.println("songname is "+ songName);
        
        return songName;
    }

    /**
     * listAllPodcasts
     * @return podcastList
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
     * countAllPodcasts
     * @return countPodcasts
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
     * registerAudioOnPlaylist
     * @param audioName
     * @return 
     */
    public boolean registerAudioOnPlaylist(String audioName) {
        return playlist.registerListAudios(audioName);
    }
    
    /**
     * listAllPlaylistAudios
     * @return playlistAudio
     */   
    public String listAllPlaylistAudios() {
        String playlistAudio = "";
        
        for (int i = 0; i < audios.size(); i++) {
            playlistAudio += playlist.getListAudios();
        }
        
        return playlistAudio;
    }
    
    /**
     * searchPlaylistByName
     * @param pName
     * @return pPos
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
     * changePlaylistName
     * @param pName
     * @param pNewName
     */
    public void changePlaylistName(String pName, String pNewName) {
        int pPos = searchPlaylistByName(pName);
        
        playlists.get(pPos).setName(pNewName);
    }
    
    /**
     * deletePlaylistAudio
     * @param pPos
     * @return 
     */    
    public String deletePlaylistAudio(int pPos) {
        return playlist.deletePlaylistAudio(pPos);
    }
    
    /**
     * checkPlaylistType
     * @param pPos
     * @param optionEdition
     * @return hasAccess
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
     * generateRandomStringNumber
     * @return
     */    
    public String generateRandomStringNumber() {
        int number = (int) (Math.random() * 9) + 1;
        
        return String.valueOf(number);
    }

    /**
     * generateMatriz
     */    
    public String generateMatriz() {
        
        return "";
    }
   
}
