package fr.greta.java.user.domain;



import fr.greta.java.user.persistence.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserWrapper {

    public List<User> fromEntities(List<UserEntity> entities) {
        List<User> models = new ArrayList<>();
        for (UserEntity entity : entities) {
            models.add(fromEntity(entity));
        }
        return models;
    }

    public UserEntity toEntity(User model) {
        UserEntity entity = new UserEntity();
        entity.setId(model.getId());
        entity.setNom(model.getNom());
        entity.setEmail(model.getEmail());
        return entity;
    }

    public User fromEntity(UserEntity entity) {
        User model = new User();
        model.setId(entity.getId());
        model.setNom(entity.getNom());
        model.setEmail(entity.getEmail());
        return model;
    }

}
