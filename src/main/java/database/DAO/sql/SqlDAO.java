package database.DAO.sql;

import database.DAO.DAO;

import java.sql.*;
import java.util.ArrayList;

public class SqlDAO extends DAO {
    private static DAO dao;
    public static final String DEFAULT_DATABASE = "AirRadar";
    public static final String DEFAULT_LOGIN = "postgres";
    public static final String DEFAULT_PASSWORD = "0000";
    public static final int DEFAULT_PORT = 5432;

    private SqlDAO() {
        super("org.postgresql.Driver");
        setURL(DEFAULT_DATABASE, DEFAULT_PORT);
        connect(DEFAULT_LOGIN, DEFAULT_PASSWORD);
    }

    @Override
    public void setURL(String database, int port) {
        this.url = "jdbc:postgresql://localhost:" + port + "/" + database;
    }

    @Override
    public void connect(String user, String password) {
        super.connect(user, password);
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, properties.getProperty("user"), properties.getProperty("password"));
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static DAO newInstance(){
        if (dao==null){
            dao = new SqlDAO();
        }
        return dao;
    }

    public static ArrayList<ArrayList<String>> getFlights(String city1, String city2, String date) {
        try (Connection connection = dao.getConnection()) {
            ArrayList<ArrayList<String>> resultList = new ArrayList<>();
            String sql = "SELECT d.directionfrom, d.directionto, f.time_arrival, f.time_departure, f.date_arrival, f.date_departure, f.cost FROM Direction as d JOIN flight f ON d.id_direction = f.id_direction WHERE d.directionfrom = ? AND d.directionto = ? AND f.date_arrival = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, city1);
            preparedStatement.setString(2, city2);
            preparedStatement.setString(3, date);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                ArrayList<String> s = new ArrayList<>();
                s.add(resultSet.getString("directionfrom"));
                s.add(resultSet.getString("directionto"));
                s.add(resultSet.getString("time_arrival"));
                s.add(resultSet.getString("time_departure"));
                s.add(resultSet.getString("date_arrival"));
                s.add(resultSet.getString("date_departure"));
                s.add(resultSet.getString("cost"));
                preparedStatement.close();
                resultList.add(s);
            }
            else {
                preparedStatement.close();
                return null;
            }
            return resultList;
        }
        catch (SQLException e) {
            System.out.println(e.fillInStackTrace());
        }
        return null;
    }
}
