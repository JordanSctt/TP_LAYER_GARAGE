package fr.greta.java.box.facade;

public class BoxDTO {

    private int id;
    private String label;
    private String vehicleBrand;



    public String getVehicleImmatriculation() {
        return vehicleImmatriculation;
    }

    public void setVehicleImmatriculation(String vehicleImmatriculation) {
        this.vehicleImmatriculation = vehicleImmatriculation;
    }

    private String vehicleImmatriculation;

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

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }
}
