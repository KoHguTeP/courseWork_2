package database.Entity;

public class Airplane {
    private int IDAir;
    private int IDComp;
    private String nameAir;

    public void setIDComp(int IDComp) {
        this.IDComp = IDComp;
    }

    public int getIDComp() {
        return IDComp;
    }

    public int getID() {
        return IDAir;
    }

    public String getName() {
        return nameAir;
    }

    public void setID(int ID) {
        this.IDAir = ID;
    }

    public void setName(String name) {
        this.nameAir = name;
    }

    public Airplane() {
    }

    public Airplane(int IDAir, int IDComp, String nameAir) {
        this.IDAir = IDAir;
        this.IDComp = IDComp;
        this.nameAir = nameAir;
    }
}
