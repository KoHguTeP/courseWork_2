package database.Entity;

public class Company {
    private int ID;
    private String name;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Company() {
    }

    public Company(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }
}
