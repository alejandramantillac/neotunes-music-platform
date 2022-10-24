package model;

/**
 *
 * @author Alejandra
 */
public class Podcast extends Audio {
    private String description;
    private Category category;

    public Podcast(String description, Category category, String name, String url, int duration, int reproductions) {
        super(name, url, duration, reproductions);
        this.description = description;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Podcast{" + "description=" + description + ", category=" + category + '}';
    }

    
}
