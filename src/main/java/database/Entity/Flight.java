package database.Entity;

import java.sql.Date;
import java.sql.Time;

public class Flight {
    private int IDFlight;
    private int IDAir;
    private int IDDirection;
    private int cost;
    private Time timeDeparture;
    private Time timeArrival;
    private Date dateDeparture;
    private Date dateArrival;

    public void setIDFlight(int IDFlight) {
        this.IDFlight = IDFlight;
    }

    public int getIDFlight() {
        return IDFlight;
    }

    public void setIDAir(int IDAir) {
        this.IDAir = IDAir;
    }

    public int getIDAir() {
        return IDAir;
    }

    public Time getTimeArrival() {
        return timeArrival;
    }

    public Time getTimeDeparture() {
        return timeDeparture;
    }

    public Date getDateDeparture() {
        return dateDeparture;
    }

    public Date getDateArrival() {
        return dateArrival;
    }

    public void setDateArrival(Date dateArrival) {
        this.dateArrival = dateArrival;
    }

    public void setDateDeparture(Date dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

    public int getCost() {
        return cost;
    }

    public int getIDDirection() {
        return IDDirection;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setIDDirection(int IDDirection) {
        this.IDDirection = IDDirection;
    }

    public void setTimeArrival(Time timeArrival) {
        this.timeArrival = timeArrival;
    }

    public void setTimeDeparture(Time timeDeparture) {
        this.timeDeparture = timeDeparture;
    }

    public Flight() {
    }

    public Flight(int IDFlight, int IDAir, int IDDirection, int cost, Time timeArrival, Time timeDeparture, Date dateArrival, Date dateDeparture) {
        this.IDFlight = IDFlight;
        this.IDAir = IDAir;
        this.IDDirection = IDDirection;
        this.cost = cost;
        this.timeDeparture = timeDeparture;
        this.timeArrival = timeArrival;
        this.dateArrival = dateArrival;
        this.dateDeparture = dateDeparture;
    }
}
