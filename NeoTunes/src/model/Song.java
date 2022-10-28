package model;

/**
 *
 * @author Alejandra
 */
public class Song extends Audio {
    private String album;
    private String genre;
    private double cost;
    private double sales;

    public Song(String album, String genre, double cost, double sales, int type, String name, String url, int duration, double reproductions) {
        super(type, name, url, duration, reproductions);
        this.album = album;
        this.genre = genre;
        this.cost = cost;
        this.sales = sales;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Song{" + "album=" + album + ", genre=" + genre + ", cost=" + cost + ", sales=" + sales + '}';
    }
    
    
}
