package database.Entity;

public class Direction {
    private int ID;
    private String to;
    private String from;


    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Direction() {
    }

    public Direction(int ID, String from, String to) {
        this.ID = ID;
        this.to = to;
        this.from = from;
    }
}
