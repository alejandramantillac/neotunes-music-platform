package model;

/**
 *
 * @author Alejandra
 */
public abstract class Producer extends User{
    private String name;
    private String url;

    public Producer(String name, String url, int type, String nickname, String id, String registrationDate) {
        super(type, nickname, id, registrationDate);
        this.name = name;
        this.url = url;
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

    @Override
    public String toString() {
        return "Producer{" + "type=" + super.getType() + ", name=" + name + ", url=" + url + '}';
    }
    
    
}
