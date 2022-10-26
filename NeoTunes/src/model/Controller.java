package model;

/**
 *
 * @author Alejandra
 */
public class Controller {

    public Controller() {
    }
    
    public boolean validateRange(int num, int min, int max) {
        boolean isOnRange = false;
        
        if (num >= min && num <= max) {
            isOnRange = true;
        }
        
        return isOnRange;
    }
    
    public String registerProducer() {
        String msg = "";
        
        return msg;
    }
    
    public String registerConsumer() {
        String msg = "";
        
        return msg;
    }
    
    public String registerAudio() {
        String msg = "";
        
        return msg;
    }
    
    
     public String createPlaylist() {
        String msg = "";
        
        return msg;
    }
}
