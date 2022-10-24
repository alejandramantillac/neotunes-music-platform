package model;

/**
 *
 * @author Alejandra
 */
public abstract class Producer {
    private String name;
    private String registrationDate;
    private String url;

    public Producer(String name, String registrationDate, String url) {
        this.name = name;
        this.registrationDate = registrationDate;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
