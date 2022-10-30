package model;


public abstract class User {
    private int type;
    private String nickname;
    private String id;
    private String registrationDate;

    public User(int type, String nickname, String id, String registrationDate) {
        this.nickname = nickname;
        this.id = id;
        this.registrationDate = registrationDate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
