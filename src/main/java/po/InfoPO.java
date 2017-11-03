package po;

public class InfoPO {
    public InfoPO(String name, String ID) {
        this.name = name;
        this.ID = ID;
    }

    private String name;
    private String ID;

    public InfoPO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
