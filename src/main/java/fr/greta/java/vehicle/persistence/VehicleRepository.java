package fr.greta.java.vehicle.persistence;

import fr.greta.java.ConnectionFactory;
import fr.greta.java.generic.tools.JdbcTool;
import fr.greta.java.generic.exception.RepositoryException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleRepository {

    private final String SELECT_REQUEST = "SELECT id, brand, immatriculation FROM vehicle";
    private final String SELECT_REQUEST_WHERE_ID = SELECT_REQUEST + " WHERE id = ?";
    private final String INSERT_REQUEST = "INSERT INTO vehicle (brand, immatriculation) VALUES (?, ?)";

    private ConnectionFactory connectionFactory = new ConnectionFactory();


    public VehicleEntity findById(int id) throws RepositoryException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try {
            conn = connectionFactory.create();
            stmt = conn.prepareStatement(SELECT_REQUEST_WHERE_ID);
            stmt.setInt(1, id);
            resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return toEntity(resultSet);
            }
            throw new RepositoryException("Erreur lors de l'execution de la requête:" + SELECT_REQUEST_WHERE_ID);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RepositoryException("Erreur lors de l'execution de la requête:" + SELECT_REQUEST_WHERE_ID, e);
        } finally {
            JdbcTool.close(resultSet, stmt, conn);
        }
    }

    public List<VehicleEntity> findAll() throws RepositoryException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try {
            conn = connectionFactory.create();
            stmt = conn.prepareStatement(SELECT_REQUEST);
            resultSet = stmt.executeQuery();

            List<VehicleEntity> list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(toEntity(resultSet));
            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RepositoryException("Erreur lors de l'execution de la requête:" + SELECT_REQUEST, e);
        } finally {
            JdbcTool.close(resultSet, stmt, conn);
        }
    }

    public VehicleEntity create(VehicleEntity entity) throws RepositoryException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            conn = connectionFactory.create();
            preparedStatement = conn.prepareStatement(INSERT_REQUEST, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, entity.getBrand());
            preparedStatement.setString(2, entity.getImmatriculation());
            preparedStatement.executeUpdate();

            rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                entity.setId(rs.getInt(1));
            }
            return entity;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RepositoryException("Erreur lors de l'execution de la requête:" + INSERT_REQUEST, e);
        } finally {
            JdbcTool.close(rs, preparedStatement, conn);
        }
    }

    private VehicleEntity toEntity(ResultSet resultSet) throws SQLException {
        VehicleEntity entity = new VehicleEntity();
        entity.setId(resultSet.getInt("id"));
        entity.setBrand(resultSet.getString("brand"));
        entity.setImmatriculation(resultSet.getString("immatriculation"));
        return entity;
    }


}
