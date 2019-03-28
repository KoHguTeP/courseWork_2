package database.DAO.sql;

import database.DAO.DAO;
import database.DAO.DirectionDAO;
import database.Entity.Direction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlDirectionDAO implements DirectionDAO {

    private DAO dao;

    public SqlDirectionDAO(DAO dao) {
        this.dao = dao;
    }

    public Direction getByID(int ID){
        try (Connection connection = dao.getConnection()) {
            String sql = "SELECT * FROM Direction WHERE ID_direction = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ID);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                Direction direction = new Direction();
                direction.setID(Integer.parseInt(resultSet.getString("ID_direction")));
                direction.setFrom(resultSet.getString("directionfrom"));
                direction.setTo(resultSet.getString("directionto"));
                preparedStatement.close();
                return direction;
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

    public int getByDirection(String from, String to) {
        try (Connection connection = dao.getConnection()) {
            String sql = "SELECT ID_direction FROM Direction WHERE directionfrom = ? AND directionto = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, from);
            preparedStatement.setString(2, to);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                return Integer.parseInt(resultSet.getString("ID_direction"));
            }
            else {
                preparedStatement.close();
                return 0;
            }
        }
        catch (SQLException e){
            System.out.println(e.fillInStackTrace());
        }
        return 0;
    }

    public void create(int ID, String from, String to){
        try (Connection connection = dao.getConnection()) {
            String sql = "INSERT INTO Direction VALUES (?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, ID);
            preparedStatement.setString(2, from);
            preparedStatement.setString(3, to);

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.fillInStackTrace());
        }
    }

    public void create(Direction direction) {
        try (Connection connection = dao.getConnection()) {
            String sql = "INSERT INTO Direction VALUES (?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, direction.getID());
            preparedStatement.setString(2, direction.getFrom());
            preparedStatement.setString(3, direction.getTo());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.fillInStackTrace());
        }
    }

    public void update(Direction direction){

    }

    public void update(int ID, String from, String to) {
        try (Connection connection = dao.getConnection()) {
            String sql = "UPDATE direction SET directionfrom = ?, directionto = ? WHERE id_direction = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, from);
            preparedStatement.setString(2, to);
            preparedStatement.setInt(3, ID);

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(Direction direction){
        try (Connection connection = dao.getConnection()) {
            String sql = "DELETE FROM Direction WHERE ID_direction = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, direction.getID());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.fillInStackTrace());
        }
    }

    public List<Direction> getAll(){
        try (Connection connection = dao.getConnection()) {
            ArrayList<Direction> listDirections = new ArrayList<Direction>();
            String sql = "SELECT * FROM Direction;";
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Direction direction = new Direction(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
                listDirections.add(direction);
            }
            return listDirections;
        }
        catch (SQLException e) {
            System.out.println(e.fillInStackTrace());
        }
        return null;
    }
}
