package model;

/**
 *
 * @author Alejandra
 */
public class Podcast extends Audio {
    private String description;
    private String category;

    public Podcast(String description, String category, int type, String name, String url, int duration, double reproductions) {
        super(type, name, url, duration, reproductions);
        this.description = description;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Podcast{" + "description=" + description + ", category=" + category + '}';
    }

    
}
