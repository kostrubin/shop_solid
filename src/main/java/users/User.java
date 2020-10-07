package users;

public abstract class User {
    protected String login;
    protected String password;
    protected String name;
    protected String surname;

    public User(String login, String password, String name, String surname) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }
}
