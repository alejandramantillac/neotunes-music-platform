package model;

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
    
    public String msgPlaylistRegister() {
        return "The playlist was successfully registered.";
    }
    
    public String msgErrorPlaylistRegister() {
        return "The playlist could not be registered.";
    }
    
    public String msgPlaylistEdition() {
        return "The playlist was successfully updated.";
    }
    
    public String msgErrorPlaylistEdition() {
        return "The playlist could not be updated.";
    }
    
    public String msgErrorNameNotFound() {
        return "Error. Name not found.";
    }
    
    public String msgErrorDifferentPlaylistType() {
        return "Error. This playlist only can add other type of audio.";
    }

}
