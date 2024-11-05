package netbean_17_buoi2_MauThietKe_Creational;

class DBConfig {
    private static DBConfig obj;
    private static String URL;
    private static String Username;
    private static String Password;

    public static String getURL() {
        return URL;
    }

    public static String getUsername() {
        return Username;
    }

    public static String getPassword() {
        return Password;
    }

    public static void setURL(String URL) {
        DBConfig.URL = URL;
    }

    public static void setUsername(String Username) {
        DBConfig.Username = Username;
    }

    public static void setPassword(String Password) {
        DBConfig.Password = Password;
    }

    public DBConfig(String url, String username, String pass){
        URL = url;
        Username = username;
        Password = pass;
    }
    
    public static DBConfig getInstance() {
        if (obj == null) {
            obj = new DBConfig(URL, Username, Password);
        }
        return obj;
    }
}

public class bai1_singleton {

    public static void main(String[] args) {
        DBConfig d = new DBConfig("", "", "");
        d.getInstance();
    }
}
