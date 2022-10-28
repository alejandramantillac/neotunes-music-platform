package model;

/**
 *
 * @author Alejandra
 */
public class Message {

    public Message() {

    }
    
    public String msgOutRange() {
        return "Error. You selected an option out of range.";
    }
    
    public String msgUserRegister() {
        return "The user was successfully registered.";
    }
    
    public String msgErrorUserRegister() {
        return "The user could not be registered.";
    }
    
    public String msgAudioRegister() {
        return "The audio was successfully registered.";
    }
    
    public String msgErrorAudioRegister() {
        return "The audio could not be registered.";
    }

}
