package fr.greta.java.vehicle.domain;

import fr.greta.java.generic.tools.StringTool;

public class Vehicle {

    private int id;
    private String brand;
    private String immatriculation;


    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

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

//----------------------------------------------------------------
	public boolean brandIsValid() {
		return !StringTool.isNullOrEmpty(getBrand());
	}
    public boolean immatIsValid() {
        return !StringTool.isNullOrEmpty(getImmatriculation());
    }


}
