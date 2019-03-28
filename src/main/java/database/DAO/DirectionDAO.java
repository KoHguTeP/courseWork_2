package database.DAO;

import database.Entity.Direction;

import java.util.List;

public interface DirectionDAO {

    public Direction getByID(int ID);

    public int getByDirection(String from, String to);

    public void create(int ID, String from, String to);

    public void create(Direction direction);

    public void update(Direction direction);

    public void update(int ID, String from, String to);

    public void delete(Direction direction);

    public  List<Direction> getAll();
}
