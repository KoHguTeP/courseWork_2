package database.DAO.sql;

import database.DAO.AirplaneDAO;
import database.DAO.DAO;
import database.Entity.Airplane;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlAirplaneDAO implements AirplaneDAO {

    private DAO dao;

    public SqlAirplaneDAO(DAO dao) {
        this.dao = dao;
    }

    public Airplane getByID(int ID){
        try (Connection connection = dao.getConnection()) {
            String sql = "SELECT id_airplane, name_airplane, id_company FROM Airplane WHERE ID_airplane = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ID);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                Airplane airplane = new Airplane(Integer.parseInt(resultSet.getString("id_airplane")), Integer.parseInt(resultSet.getString("id_company")), resultSet.getString("name_airplane"));
                preparedStatement.close();
                return airplane;
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

    public String getNameCompany(Airplane airplane){
        try (Connection connection = dao.getConnection()) {
            String sql = "SELECT name_company FROM company WHERE id_company = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, airplane.getIDComp());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                return resultSet.getString("name_company");
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

    public void create(int ID, int IDComp, String name){
        try (Connection connection = dao.getConnection()) {
            String sql = "INSERT INTO Airplane (id_airplane, name_airplane, id_company) VALUES (?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, ID);
            preparedStatement.setString(3, name);
            preparedStatement.setInt(2, IDComp);

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.fillInStackTrace());
        }
    }

    public void create(Airplane airplane) {
        try (Connection connection = dao.getConnection()) {
            String sql = "INSERT INTO Airplane (id_airplane, name_airplane, id_company) VALUES (?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, airplane.getID());
            preparedStatement.setString(2, airplane.getName());
            preparedStatement.setInt(3, airplane.getIDComp());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.fillInStackTrace());
        }
    }

    public void update(int id_airplane, String name, int id_company){
        try (Connection connection = dao.getConnection()) {
            String sql = "UPDATE airplane SET name_airplane = ?, id_company = ? WHERE id_airplane = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id_company);
            preparedStatement.setInt(3, id_airplane);

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.fillInStackTrace());
        }
    }

    public void delete(Airplane airplane){
        try (Connection connection = dao.getConnection()) {
            String sql = "DELETE FROM Airplane WHERE ID_airplane = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, airplane.getID());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.fillInStackTrace());
        }
    }

    public ArrayList<Airplane> getByIDComp(int IDComp){
        try (Connection connection = dao.getConnection()) {
            ArrayList<Airplane> listAirplanes = new ArrayList<Airplane>();
            String sql = "SELECT * FROM Airplane WHERE ID_company = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, IDComp);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Airplane airplane = new Airplane(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3));
                listAirplanes.add(airplane);
            }
            return listAirplanes;
        }
        catch (SQLException e) {
            System.out.println(e.fillInStackTrace());
        }
        return null;
    }

    public  List<Airplane> getAll(){
        try (Connection connection = dao.getConnection()) {
            ArrayList<Airplane> listAirplanes = new ArrayList<Airplane>();
            String sql = "SELECT * FROM Airplane;";
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Airplane airplane = new Airplane(resultSet.getInt(1), resultSet.getInt(3), resultSet.getString(2));
                listAirplanes.add(airplane);
            }
            return listAirplanes;
        }
        catch (SQLException e) {
            System.out.println(e.fillInStackTrace());
        }
        return null;
    }

}
