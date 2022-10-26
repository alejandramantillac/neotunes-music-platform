package model;

/**
 *
 * @author Alejandra
 */
public abstract class Producer extends User{
    private int type;
    private String name;
    private String url;

    public Producer(int type, String name, String url, String nickname, String id, String registrationDate) {
        super(nickname, id, registrationDate);
        this.type = type;
        this.name = name;
        this.url = url;
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

    @Override
    public String toString() {
        return "Producer{" + "type=" + type + ", name=" + name + ", url=" + url + '}';
    }
    
    
}
