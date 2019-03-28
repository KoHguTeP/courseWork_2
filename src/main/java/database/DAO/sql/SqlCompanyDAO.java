package database.DAO.sql;

import database.DAO.CompanyDAO;
import database.DAO.DAO;
import database.Entity.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlCompanyDAO implements CompanyDAO {

    private DAO dao;

    public SqlCompanyDAO(DAO dao) {
        this.dao = dao;
    }

    public Company getByID(int ID){
        try (Connection connection = dao.getConnection()) {
            String sql = "SELECT * FROM Company WHERE ID_company = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ID);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                Company company = new Company();
                company.setID(Integer.parseInt(resultSet.getString("ID_company")));
                company.setName(resultSet.getString("name_company"));
                preparedStatement.close();
                return company;
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

    public void create(int ID, String name){
        try (Connection connection = dao.getConnection()) {
            String sql = "INSERT INTO Company VALUES (?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, ID);
            preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.fillInStackTrace());
        }
    }

    public void create(Company company){
        try (Connection connection = dao.getConnection()) {
            String sql = "INSERT INTO Company VALUES (?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, company.getID());
            preparedStatement.setString(2, company.getName());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.fillInStackTrace());
        }
    }

    public void update(Company company){
        
    }

    public void update(int id_company, String name) {
        try (Connection connection = dao.getConnection()) {
            String sql = "UPDATE company SET name_company = ? WHERE id_company = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id_company);

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(Company company){
        try (Connection connection = dao.getConnection()) {
            String sql = "DELETE FROM Company WHERE ID_company = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, company.getID());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.fillInStackTrace());
        }
    }

    public List<Company> getAll(){
        try (Connection connection = dao.getConnection()) {
            ArrayList<Company> listCompanies = new ArrayList<Company>();
            String sql = "SELECT * FROM Company;";
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Company company = new Company(resultSet.getInt(1), resultSet.getString(2));
                listCompanies.add(company);
            }
            return listCompanies;
        }
        catch (SQLException e) {
            System.out.println(e.fillInStackTrace());
        }
        return null;
    }
}
