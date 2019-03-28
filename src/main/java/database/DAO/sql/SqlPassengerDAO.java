package database.DAO.sql;

import database.DAO.DAO;
import database.DAO.PassengerDAO;
import database.Entity.Passenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlPassengerDAO implements PassengerDAO {

    private DAO dao = null;

    public SqlPassengerDAO(DAO dao) {
        this.dao = dao;
    }

    public Passenger getByID(int ID){
        try (Connection connection = dao.getConnection()) {
            String sql = "SELECT * FROM Passenger WHERE ID_passenger = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ID);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                Passenger passenger = new Passenger();
                passenger.setID(Integer.parseInt(resultSet.getString("ID_passenger")));
                passenger.setIDFlight(Integer.parseInt(resultSet.getString("ID_flight")));
                passenger.setFirstName(resultSet.getString("firstname"));
                passenger.setLastName(resultSet.getString("lastname"));
                preparedStatement.close();
                return passenger;
            }
            else {
                preparedStatement.close();
                return null;
            }
        }
        catch (SQLException e){
            System.out.println(e.fillInStackTrace());
        }
        return null;
    }

    public void create(int ID, int IDFlight, String lastName, String firstName){
        try (Connection connection = dao.getConnection()) {
            String sql = "INSERT INTO Passenger (id_passenger, id_flight, firstname, lastname) VALUES (?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, ID);
            preparedStatement.setInt(2, IDFlight);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, lastName);

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.fillInStackTrace());
        }
    }

    public void create(Passenger passenger){
        try (Connection connection = dao.getConnection()) {
            String sql = "INSERT INTO Passenger (id_passenger, id_flight, firstname, lastname)  VALUES (?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, passenger.getID());
            preparedStatement.setInt(2, passenger.getIDFlight());
            preparedStatement.setString(3, passenger.getFirstName());
            preparedStatement.setString(4, passenger.getLastName());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.fillInStackTrace());
        }
    }

    public void update(Passenger passenger){
        //dunno what to do
    }

    public void update(int ID, int IDFlight, String lastName, String firstName) {
        try (Connection connection = dao.getConnection()) {
            String sql = "UPDATE passenger SET id_flight = ?, firstname =  ?, lastname = ? WHERE id_passenger = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, IDFlight);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setInt(4, ID);

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(Passenger passenger){
        try (Connection connection = dao.getConnection()) {
            String sql = "DELETE FROM Passenger WHERE ID_passenger = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, passenger.getID());;

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.fillInStackTrace());
        }
    }

    public List<Passenger> getAll(){
        try (Connection connection = dao.getConnection()) {
            ArrayList<Passenger> listPassengers = new ArrayList<Passenger>();
            String sql = "SELECT * FROM passenger;";
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Passenger passenger = new Passenger(Integer.parseInt(resultSet.getString("ID_passenger")), resultSet.getString("firstname"), resultSet.getString("lastname"), Integer.parseInt(resultSet.getString("ID_flight")));
                listPassengers.add(passenger);
            }
            return listPassengers;
        }
        catch (SQLException e) {
            System.out.println(e.fillInStackTrace());
        }
        return null;
    }
}
