package fr.greta.java.box.domain;

import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.box.persistence.BoxRepository;
import fr.greta.java.user.domain.User;
import fr.greta.java.user.domain.UserService;
import fr.greta.java.vehicle.domain.Vehicle;
import fr.greta.java.vehicle.domain.VehicleService;

import java.util.List;

public class BoxService {

    private BoxRepository repository = new BoxRepository();

    private BoxWrapper wrapper = new BoxWrapper();

    private VehicleService vehicleService = new VehicleService();
    private UserService userService = new UserService();


    public List<Box> findAllWithVehicle() throws ServiceException {
        try {
            List<Box> models = wrapper.fromEntities(repository.findAll());
            for(Box box : models) {
                if(box.getVehicle() != null) {
                    box.setVehicle(vehicleService.findByIdWithUser(box.getVehicle().getId()));
                }
            }
            return models;
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public void affectedNewVehicle(Box box, Vehicle vehicle, User user) throws ServiceException {
        try {
            vehicle.setUser(userService.create(user));
            box.setVehicle(vehicleService.create(vehicle));
            repository.updateVehicle(wrapper.toEntity(box));
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public Box findById(int boxId) throws ServiceException {
        try {
            return wrapper.fromEntity(repository.findById(boxId));
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }


}
