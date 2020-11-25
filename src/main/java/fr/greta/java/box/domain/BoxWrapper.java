package fr.greta.java.box.domain;

import fr.greta.java.box.persistence.BoxEntity;
import fr.greta.java.vehicle.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class BoxWrapper {

    public List<Box> toEntities(List<BoxEntity> entities) {
        List<Box> models = new ArrayList<>();
        for (BoxEntity entity : entities) {
            models.add(toEntity(entity));
        }
        return models;
    }

    public Box toEntity(BoxEntity entity) {
        Box model = new Box();
        model.setId(entity.getId());
        model.setLabel(entity.getLabel());
        model.setSecretKey(entity.getSecretKey());
        if(entity.getVehicleId() > 0) {
            Vehicle vehicle = new Vehicle();
            vehicle.setId(entity.getVehicleId());
            model.setVehicle(vehicle);
        }
        return model;
    }

    public BoxEntity fromEntity(Box model) {
        BoxEntity entity = new BoxEntity();
        entity.setId(model.getId());
        entity.setLabel(model.getLabel());
        entity.setSecretKey(model.getSecretKey());
        if(model.getVehicle() != null) {
            entity.setVehicleId(model.getVehicle().getId());
        }
        return entity;
    }
}
