package fr.greta.java.vehicle.domain;

import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.vehicle.persistence.VehicleEntity;
import fr.greta.java.vehicle.persistence.VehicleRepository;
import org.junit.Test;


import static org.mockito.Mockito.*;

public class VehicleServiceTest {

    private VehicleRepository vehicleRepository = mock(VehicleRepository.class);
    private VehicleWrapper vehicleWrapper = mock(VehicleWrapper.class);

    private VehicleService vehicleService = new VehicleService(vehicleRepository, vehicleWrapper);


    @Test
    public void callRepoCreateWhenVehicleIsValid () throws ServiceException, RepositoryException {
        Vehicle vehicle = mock(Vehicle.class);
        when(vehicle.brandIsValid()).thenReturn(true);

        VehicleEntity vehicleEntity = new VehicleEntity();
        when(vehicleWrapper.toEntity(vehicle)).thenReturn(vehicleEntity);

        vehicleService.create(vehicle);
        verify(vehicleRepository).create(vehicleEntity);
    }

    @Test
    public void NeverCallRepoCreateWhenVehicleIsNotValid () throws RepositoryException {
        Vehicle vehicle = mock(Vehicle.class);
        when(vehicle.brandIsValid()).thenReturn(false);

        VehicleEntity vehicleEntity = new VehicleEntity();
        when(vehicleWrapper.toEntity(vehicle)).thenReturn(vehicleEntity);

        try {
            vehicleService.create(vehicle);
        } catch (ServiceException e) {

        }
        verify(vehicleRepository, never()).create(any());
    }
}
