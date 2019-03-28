package database.DAO;

import database.Entity.Passenger;

import java.util.List;

public interface PassengerDAO {

    public Passenger getByID(int ID);

    public void create(int ID, int IDFlight, String lastName, String firstName);

    public void create(Passenger passenger);

    public void update(Passenger passenger);

    public void update(int ID, int IDFlight, String lastName, String firstName);

    public void delete(Passenger passenger);

    public  List<Passenger> getAll();
}
