package database.Entity;

public class Passenger{
    private int ID;
    private String firstName;
    private String lastName;
    private int IDFlight;

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIDFlight() {
        return IDFlight;
    }

    public void setIDFlight(int IDFlight) {
        this.IDFlight = IDFlight;
    }

    public Passenger() {
    }

    public Passenger(int ID, String firstName, String lastName, int IDFlight) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.IDFlight = IDFlight;
    }
}
