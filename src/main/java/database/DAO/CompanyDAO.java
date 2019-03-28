package database.DAO;

import database.Entity.Company;

import java.util.List;

public interface CompanyDAO {

    public Company getByID(int ID);

    public void create(int ID, String name);

    public void create(Company company);

    public void update(Company company);

    public void update(int id_company, String name);

    public void delete(Company company);

    public  List<Company> getAll();
}
