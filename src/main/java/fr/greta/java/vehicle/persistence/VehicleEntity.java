package fr.greta.java.vehicle.persistence;

public class VehicleEntity {

    private int id;
    private int userId;
    private String brand;
    private String immatriculation;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }
}
