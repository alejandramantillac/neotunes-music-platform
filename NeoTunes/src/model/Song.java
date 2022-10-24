package model;

/**
 *
 * @author Alejandra
 */
public class Song extends Audio {
    private String album;
    private Genre genre;
    private double cost;
    private double sales;

    public Song(String album, Genre genre, double cost, double sales, String name, String url, int duration, int reproductions) {
        super(name, url, duration, reproductions);
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
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
