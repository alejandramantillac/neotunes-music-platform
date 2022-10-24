package model;

/**
 *
 * @author Alejandra
 */
public abstract class Audio {
    private String name;
    private String url;
    private int duration;
    private int reproductions;

    public Audio(String name, String url, int duration, int reproductions) {
        this.name = name;
        this.url = url;
        this.duration = duration;
        this.reproductions = reproductions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getReproductions() {
        return reproductions;
    }

    public void setReproductions(int reproductions) {
        this.reproductions = reproductions;
    }

    @Override
    public String toString() {
        return "Audio{" + "name=" + name + ", url=" + url + ", duration=" + duration + ", reproductions=" + reproductions + '}';
    }
    
    
}
