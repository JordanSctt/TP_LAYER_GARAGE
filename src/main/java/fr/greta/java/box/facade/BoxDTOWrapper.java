package fr.greta.java.box.facade;

import fr.greta.java.box.domain.Box;

import java.util.ArrayList;
import java.util.List;

public class BoxDTOWrapper {

    public List<BoxDTO> toDTOS(List<Box> models) {
        List<BoxDTO> dtos = new ArrayList<>();
        for(Box model : models) {
            dtos.add(toDTO(model));
        }
        return dtos;
    }

    public BoxDTO toDTO(Box model) {
        BoxDTO dto = new BoxDTO();
        dto.setId(model.getId());
        dto.setLabel(model.getLabel());
        if(model.getVehicle() != null) {
            dto.setVehicleBrand(model.getVehicle().getBrand());
            dto.setVehicleImmatriculation(model.getVehicle().getImmatriculation());
            if (model.getUser() != null) {
                dto.setUserNom(model.getUser().getNom());
                dto.setUserEmail(model.getUser().getEmail());
            }
        }
        return dto;
    }
}
