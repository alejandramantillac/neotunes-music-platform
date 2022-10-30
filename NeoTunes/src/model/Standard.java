package model;


public final class Standard extends Consumer {
    
    public static final int MAX_PLAYLIST = 20;
    public static final int MAX_SONGS = 100;

    public Standard(int totalSongs, int totalPlaylists, int type, String nickname, String id, String registrationDate) {
        super(totalSongs, totalPlaylists, type, nickname, id, registrationDate);
    }    
    
}
