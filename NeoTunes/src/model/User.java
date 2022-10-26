package model;

/**
 *
 * @author Alejandra
 */
public abstract class User {
    private String nickname;
    private String id;
    private String registrationDate;

    public User(String nickname, String id, String registrationDate) {
        this.nickname = nickname;
        this.id = id;
        this.registrationDate = registrationDate;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "User{" + "nickname=" + nickname + ", id=" + id + ", registrationDate=" + registrationDate + '}';
    }
    
    
}
