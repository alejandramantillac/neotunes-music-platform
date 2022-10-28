package model;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Alejandra
 */
public class Controller {

    private ArrayList<Producer> producers; 
    private ArrayList<Consumer> consumers; 
    private ArrayList<Audio> audios; 

    public Controller() {
        producers = new ArrayList<Producer>();
        consumers = new ArrayList<Consumer>();
        audios = new ArrayList<Audio>();
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
        
    public boolean validateRange(int num, int min, int max) {
        boolean isOnRange = false;
        
        if (num >= min && num <= max) {
            isOnRange = true;
        }
        
        return isOnRange;
    }
    
    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        Date currentDate = new Date();
        
        String newDate = sdf.format(currentDate);
        
        return newDate;
    }
    
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
    
    public boolean registerProducer(Producer producer) {
        return producers.add(producer);
    }
    
    public boolean registerConsumer(Consumer consumer) {
        return consumers.add(consumer);
    }
    
    public boolean registerAudio(Audio audio) {
        return audios.add(audio);
    }
    
    
     public String createPlaylist() {
        String msg = "";
        
        return msg;
    }
}
