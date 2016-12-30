package gui;

/**
 * Created by everduin on 12/22/2016.
 */
class ServerInfo {
    private String name;
    private int id;
    private boolean checked;

    ServerInfo(String name,
               int id,
               boolean checked) {
        this.name = name;
        this.id = id;
        this.checked = checked;
    }

    public int getId() {
        return id;
    }

    /*When is defensive copy needed?*/
    public boolean isChecked() {return checked;}

    public void setChecked(boolean checked) { this.checked = checked; }

    @Override
    public String toString() {
        return name;
    }
}
