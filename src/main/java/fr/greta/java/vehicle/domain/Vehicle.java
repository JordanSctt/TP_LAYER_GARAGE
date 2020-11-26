package fr.greta.java.vehicle.domain;

import fr.greta.java.generic.tools.StringTool;
import fr.greta.java.user.domain.User;

public class Vehicle {

    private int id;
    private String brand;
    private String immatriculation;
    private User user;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //----------------------------------------------------------------
	public boolean brandIsValid() {
		return !StringTool.isNullOrEmpty(getBrand());
	}
    public boolean immatIsValid() {
        return !StringTool.isNullOrEmpty(getImmatriculation());
    }


}
