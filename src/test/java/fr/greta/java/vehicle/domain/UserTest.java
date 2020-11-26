package fr.greta.java.vehicle.domain;

import fr.greta.java.user.domain.User;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void isValidIfNomIsFilled () {
        User user = new User();
        user.setNom("any");
        assertTrue(user.nomIsValid());
    }

    @Test
    public void isValidIfNomIsNull () {
        User user = new User();
        user.setNom(null);
        assertFalse(user.nomIsValid());
    }

    @Test
    public void isValidIfNomIsEmpty () {
        User user = new User();
        user.setNom("");
        assertFalse(user.nomIsValid());
    }
}
