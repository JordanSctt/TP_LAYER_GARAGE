package fr.greta.java.vehicle.domain;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VehicleTest {


    @Test
    public void isValidIfTheBrandIsFilled () {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand("any");
        assertTrue(vehicle.brandIsValid());
    }

    @Test
    public void isValidIfTheBrandIsNull () {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(null);
        assertFalse(vehicle.brandIsValid());
    }

    @Test
    public void isValidIfTheBrandIsEmpty () {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand("");
        assertFalse(vehicle.brandIsValid());
    }

}