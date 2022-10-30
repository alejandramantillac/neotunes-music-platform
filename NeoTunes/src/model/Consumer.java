package model;

public abstract class Consumer extends User {
    
    private int totalSongs;
    private int totalPlaylists;

    public Consumer(int totalSongs, int totalPlaylists, int type, String nickname, String id, String registrationDate) {
        super(type, nickname, id, registrationDate);
        //type 1 = standard, type 2 = premium
        this.totalSongs = totalSongs;
        this.totalPlaylists = totalPlaylists;
    }    

    public int getTotalSongs() {
        return totalSongs;
    }

    public void setTotalSongs(int totalSongs) {
        this.totalSongs = totalSongs;
    }

    public int getTotalPlaylists() {
        return totalPlaylists;
    }

    public void setTotalPlaylists(int totalPlaylists) {
        this.totalPlaylists = totalPlaylists;
    }
    
}
