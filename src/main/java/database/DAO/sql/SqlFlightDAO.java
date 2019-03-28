package database.DAO.sql;

import database.DAO.DAO;
import database.DAO.FlightDAO;
import database.Entity.Flight;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlFlightDAO implements FlightDAO {

    private DAO dao;

    public SqlFlightDAO(DAO dao) {
        this.dao = dao;
    }

    public Flight getByID(int IDFlight){
        try (Connection connection = dao.getConnection()) {
            /*String sql = "SELECT * FROM Flight WHERE ID_flight = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, IDFlight);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                Flight flight = new Flight();
                flight.setIDFlight(Integer.parseInt(resultSet.getString("ID_flight")));
                flight.setIDAir(Integer.parseInt(resultSet.getString("ID_airplane")));
                flight.setIDDirection(Integer.parseInt(resultSet.getString("ID_direction")));
                flight.setCost(Integer.parseInt(resultSet.getString("cost")));
                flight.setTimeArrival(Time.valueOf(resultSet.getString("time_arrival")));
                flight.setTimeDeparture(Time.valueOf(resultSet.getString("time_departure")));
                flight.setDateArrival(Date.valueOf(resultSet.getString("date_arrival")));
                flight.setDateDeparture(Date.valueOf(resultSet.getString("date_departure")));
                preparedStatement.close();*/
            String sql = "SELECT id_flight, id_airplane, id_direction, cost, time_arrival, time_departure, date_arrival, date_departure FROM Flight WHERE id_flight = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, IDFlight);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Flight flight = new Flight(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3), resultSet.getInt(4), resultSet.getTime(5), resultSet.getTime(6), resultSet.getDate(7), resultSet.getDate(8));
                return flight;
            }
        }
        catch (SQLException e){
            System.out.println(e.fillInStackTrace());
        }
        return null;
    }

    public String getNameAirplane(Flight flight){
        try (Connection connection = dao.getConnection()) {
            String sql = "SELECT name_airplane FROM airplane WHERE id_airplane = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, flight.getIDAir());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                return resultSet.getString("name_airplane");
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

    public String getDirectionFrom(Flight flight){
        try (Connection connection = dao.getConnection()) {
            String sql = "SELECT directionfrom FROM direction WHERE id_direction = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, flight.getIDDirection() );

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                return resultSet.getString("directionfrom");
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

    public String getDirectionTo(Flight flight){
        try (Connection connection = dao.getConnection()) {
            String sql = "SELECT directionto FROM direction WHERE id_direction = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, flight.getIDDirection());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                return resultSet.getString("directionto");
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

    public void create(int IDFlight, int IDAir, int IDDirection, int cost, Time timeArrival, Time timeDeparture, Date dateArrival, Date dateDeparture){
        try (Connection connection = dao.getConnection()) {
            String sql = "INSERT INTO Flight (id_flight, id_airplane, id_direction, cost, time_arrival, time_departure, date_arrival, date_departure) VALUES (?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, IDFlight);
            preparedStatement.setInt(2, IDAir);
            preparedStatement.setInt(3, IDDirection);
            preparedStatement.setInt(4, cost);
            preparedStatement.setTime(5, timeArrival);
            preparedStatement.setTime(6, timeDeparture);
            preparedStatement.setDate(7, dateDeparture);
            preparedStatement.setDate(8, dateDeparture);

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.fillInStackTrace());
        }
    }

    public void create(Flight flight) {
        try (Connection connection = dao.getConnection()) {
            String sql = "INSERT INTO Flight (id_flight, id_airplane, id_direction, cost, time_arrival, time_departure, date_arrival, date_departure) VALUES (?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, flight.getIDFlight());
            preparedStatement.setInt(2, flight.getIDAir());
            preparedStatement.setInt(3, flight.getIDDirection());
            preparedStatement.setInt(4, flight.getCost());
            preparedStatement.setTime(5, flight.getTimeArrival());
            preparedStatement.setTime(6, flight.getTimeDeparture());
            preparedStatement.setDate(7, flight.getDateArrival());
            preparedStatement.setDate(8, flight.getDateDeparture());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.fillInStackTrace());
        }
    }

    public void update(Flight flight){
        //dunno what to do
    }

    public void update(int IDFlight, int IDAir, int IDDirection, int cost, Time timeArrival, Time timeDeparture, Date dateArrival, Date dateDeparture) {
        try (Connection connection = dao.getConnection()) {
            String sql = "UPDATE flight SET id_airplane = ?, id_direction = ?, time_arrival = ?, time_departure = ?, date_arrival = ?, date_departure = ?, cost = ? WHERE id_flight = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, IDAir);
            preparedStatement.setInt(2, IDDirection);
            preparedStatement.setTime(3, timeArrival);
            preparedStatement.setTime(4, timeDeparture);
            preparedStatement.setDate(5, dateArrival);
            preparedStatement.setDate(6, dateDeparture);
            preparedStatement.setInt(7, cost);
            preparedStatement.setInt(8, IDFlight);

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(Flight flight){
        try (Connection connection = dao.getConnection()) {
            String sql = "DELETE FROM Flight WHERE ID_flight = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, flight.getIDFlight());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.fillInStackTrace());
        }
    }

    public List<Flight> getAll(){
        try (Connection connection = dao.getConnection()) {
            ArrayList<Flight> listFlights = new ArrayList<Flight>();
            String sql = "SELECT id_flight, id_airplane, id_direction, cost, time_arrival, time_departure, date_arrival, date_departure FROM Flight;";
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Flight flight = new Flight(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3), resultSet.getInt(4), resultSet.getTime(5), resultSet.getTime(6), resultSet.getDate(7), resultSet.getDate(8));
                listFlights.add(flight);
            }
            return listFlights;
        }
        catch (SQLException e) {
            System.out.println(e.fillInStackTrace());
        }
        return null;
    }
}
