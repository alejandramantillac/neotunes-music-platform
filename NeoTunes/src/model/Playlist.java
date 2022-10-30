package model;

import java.util.ArrayList;

public class Playlist {
    private TypePlaylist type;
    private String name;
    private ArrayList<String> listAudios = new ArrayList<String>();
    private String numericCode;

    public Playlist(TypePlaylist type, String name, String numericCode) {
        // type 1 = songs, type 2 = podcast, type 3 = both
        this.type = type;        
        this.name = name;
        this.listAudios = listAudios;
        this.numericCode = numericCode;
    }

    public TypePlaylist getType() {
        return type;
    }

    public void setType(TypePlaylist type) {
        this.type = type;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getListAudios() {
        return listAudios;
    }

    public void setListAudios(ArrayList<String> listAudios) {
        this.listAudios = listAudios;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }
    
    /**
     * registerListAudios
     * @param audioName
     * @return 
     */
    public boolean registerListAudios(String audioName) {
       return listAudios.add(audioName);
    }  
    
    /**
     * deletePlaylistAudio
     * @param pPos
     * @return 
     */
    public String deletePlaylistAudio(int pPos) {
        return listAudios.remove(pPos);
    }
    
    /**
     * listPlaylistAudios
     * @return audiosList
     */    
    public String listPlaylistAudios() {
        String audiosList = "";
        
        for (int i = 0; i < listAudios.size(); i++) {
            audiosList += (i+1) + ". "+ listAudios.get(i);
        }
        
        return audiosList;
    }
    
}
