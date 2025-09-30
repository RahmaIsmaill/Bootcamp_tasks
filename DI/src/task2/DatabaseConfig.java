package task2;

public class DatabaseConfig {
    private String url;
    private String username;
    private String password;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public void save(String Vehicle_Name) {
        System.out.println("---------------Successfully connected to Database------------------");
        System.out.println("From Class: " + Vehicle_Name);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
    }
}
