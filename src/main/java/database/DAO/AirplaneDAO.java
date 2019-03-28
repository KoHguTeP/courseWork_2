package database.DAO;

import database.Entity.Airplane;

import java.util.List;

public interface AirplaneDAO {

    public Airplane getByID(int ID);

    public String getNameCompany(Airplane airplane);

    public void create(int ID, int IDComp, String name);

    public void create(Airplane airplane);

    public void update(int id, String name, int id_company);

    public void delete(Airplane airplane);

    public List<Airplane> getByIDComp(int IDComp);

    public  List<Airplane> getAll();

}
