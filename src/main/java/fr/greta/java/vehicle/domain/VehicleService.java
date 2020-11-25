package fr.greta.java.vehicle.domain;


import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.vehicle.persistence.VehicleRepository;

public class VehicleService {

    private VehicleRepository repository = new VehicleRepository();
    private VehicleWrapper wrapper = new VehicleWrapper();


    public Vehicle findById(int id) throws ServiceException {
        try {
            return wrapper.fromEntity(repository.findById(id));
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
