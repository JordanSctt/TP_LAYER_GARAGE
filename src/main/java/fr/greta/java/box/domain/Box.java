package fr.greta.java.box.domain;

import fr.greta.java.user.domain.User;
import fr.greta.java.vehicle.domain.Vehicle;

public class Box {

    private int id;
    private String label;
    private String secretKey;
    private Vehicle vehicle;


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

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
