package fr.greta.java.vehicle.domain;


import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.user.domain.UserService;
import fr.greta.java.vehicle.persistence.VehicleRepository;

import java.util.List;

public class VehicleService {

    private VehicleRepository repository = new VehicleRepository();
    private VehicleWrapper wrapper = new VehicleWrapper();
    private UserService userService = new UserService();


    public Vehicle findByIdWithUser(int id) throws ServiceException {
        try {
            Vehicle vehicle = wrapper.fromEntity(repository.findById(id));
            if (vehicle.getUser() != null) {
                vehicle.setUser(userService.findById(vehicle.getUser().getId()));
            }
            return vehicle;
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public List<Vehicle> findAll() throws ServiceException {
        try {
            return wrapper.fromEntities(repository.findAll());
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public Vehicle create(Vehicle vehicle) throws ServiceException {
    	if(vehicle.brandIsValid() && vehicle.immatIsValid()) {
    		try {
    			return wrapper.fromEntity(repository.create(wrapper.toEntity(vehicle)));
            } catch (RepositoryException e) {
            	throw new ServiceException(e);
            }
    	}
    	throw new ServiceException("La marque et l'immatriculation du véhicule ne peuvent pas être vide.");
    }





}
