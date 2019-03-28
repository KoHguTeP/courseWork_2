package database.DAO;

import java.sql.Connection;
import java.util.Properties;

public abstract class DAO {
    protected String driver = null;
    protected String url = null;
    protected Properties properties = null;

    public DAO(String driver) {
        this.driver = driver;
    }

    protected void registerDriverManager() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.fillInStackTrace();
        }
    }

    public abstract void setURL(String database, int port);

    public abstract Connection getConnection();

    public void connect(String user, String password) {
        registerDriverManager();
        properties = new Properties();
        properties.setProperty("password", password);
        properties.setProperty("user", user);
        properties.setProperty("useUnicode", "true");
        properties.setProperty("characterEncoding", "utf8");
    }

    //public abstract ArrayList<ArrayList<String>> getFlights(String city1, String city2, String date);
}
