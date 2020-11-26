package fr.greta.java.vehicle.domain;

import fr.greta.java.user.domain.User;
import fr.greta.java.vehicle.persistence.VehicleEntity;

import java.util.ArrayList;
import java.util.List;

public class VehicleWrapper {


    public List<Vehicle> fromEntities(List<VehicleEntity> entities) {
        List<Vehicle> models = new ArrayList<>();
        for (VehicleEntity entity : entities) {
            models.add(fromEntity(entity));
        }
        return models;
    }

    public Vehicle fromEntity(VehicleEntity entity) {
        Vehicle model = new Vehicle();
        model.setId(entity.getId());
        model.setBrand(entity.getBrand());
        model.setImmatriculation(entity.getImmatriculation());
        if(entity.getUserId() > 0) {
            User user = new User();
            user.setId(entity.getUserId());
            model.setUser(user);
        }
        return model;
    }

    public VehicleEntity toEntity(Vehicle model) {
        VehicleEntity entity = new VehicleEntity();
        entity.setId(model.getId());
        entity.setBrand(model.getBrand());
        entity.setImmatriculation(model.getImmatriculation());
        if(model.getUser() != null) {
            entity.setUserId(model.getUser().getId());
        }
        return entity;
    }


}
