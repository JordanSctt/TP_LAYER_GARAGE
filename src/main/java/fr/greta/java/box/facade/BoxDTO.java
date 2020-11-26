package fr.greta.java.box.facade;

public class BoxDTO {

    private int id;
    private String label;
    private String vehicleBrand;
    private String vehicleImmatriculation;
    private String userNom;

    //-----------------------------------------------
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
    //-----------------------------------------------
    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleImmatriculation() {
        return vehicleImmatriculation;
    }

    public void setVehicleImmatriculation(String vehicleImmatriculation) {
        this.vehicleImmatriculation = vehicleImmatriculation;
    }
    //----------------------------------------------
    public String getUserNom() {
        return userNom;
    }

    public void setUserNom(String userNom) {
        this.userNom = userNom;
    }
}
