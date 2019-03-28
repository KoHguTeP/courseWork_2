package database.DAO;

import database.Entity.Flight;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface FlightDAO {

    public Flight getByID(int IDFlight);

    public String getNameAirplane(Flight flight);

    public String getDirectionFrom(Flight flight);

    public String getDirectionTo(Flight flight);

    public void create(int IDFlight, int IDAir, int IDDirection, int cost, Time timeArrival, Time timeDeparture, Date dateArrival, Date dateDeparture);

    public void create(Flight flight);

    public void update(Flight flight);

    public void update(int IDFlight, int IDAir, int IDDirection, int cost, Time timeArrival, Time timeDeparture, Date dateArrival, Date dateDeparture);

    public void delete(Flight flight);

    public List<Flight> getAll();
}
