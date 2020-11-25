package fr.greta.java.vehicle.domain;

import fr.greta.java.vehicle.persistence.VehicleEntity;

public class VehicleWrapper {

    public VehicleEntity toEntity(Vehicle model) {
        VehicleEntity entity = new VehicleEntity();
        entity.setId(model.getId());
        entity.setBrand(model.getBrand());
        entity.setBrand(model.getImmatriculation());
        return entity;
    }

    public Vehicle fromEntity(VehicleEntity entity) {
        Vehicle model = new Vehicle();
        model.setId(entity.getId());
        model.setBrand(entity.getBrand());
        model.setImmatriculation(entity.getImmatriculation());
        return model;
    }
}
