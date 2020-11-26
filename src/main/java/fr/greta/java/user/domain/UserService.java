package fr.greta.java.user.domain;

import fr.greta.java.generic.exception.RepositoryException;
import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.user.persistence.UserRepository;

import java.util.List;

public class UserService {

    private UserRepository repository = new UserRepository();
    private UserWrapper wrapper = new UserWrapper();


    public User findById(int id) throws ServiceException {
        try {
            return wrapper.fromEntity(repository.findById(id));
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public List<User> findAll() throws ServiceException {
        try {
            return wrapper.fromEntities(repository.findAll());
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public User create(User user) throws ServiceException {
        if(user.nomIsValid() && user.emailIsValid()) {
            try {
                return wrapper.fromEntity(repository.create(wrapper.toEntity(user)));
            } catch (RepositoryException e) {
                throw new ServiceException(e);
            }
        }
        throw new ServiceException("La marque et l'immatriculation du véhicule ne peuvent pas être vide.");
    }

}
