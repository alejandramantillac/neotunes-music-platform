package model;

/**
 *
 * @author Alejandra
 */
public abstract class Audio {
    private int type;
    private String name;
    private String url;
    private int duration;
    private double reproductions;

    public Audio(int type, String name, String url, int duration, double reproductions) {
        this.type = type;
        this.name = name;
        this.url = url;
        this.duration = duration;
        this.reproductions = reproductions;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public double getReproductions() {
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
