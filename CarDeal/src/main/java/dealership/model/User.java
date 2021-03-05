package dealership.model;

public class User {

    private String username;
    private String password;
    private String userType;
    private String[] validUserTypes = {"customer", "employee", "system"};
    private boolean loggedIn;

    public User() {

    }

    public User(String username, String password, String userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        for (String s : validUserTypes) {
            if (s.equals(userType)) {
                this.userType = userType;
                break;
            }
        }
    }
}


