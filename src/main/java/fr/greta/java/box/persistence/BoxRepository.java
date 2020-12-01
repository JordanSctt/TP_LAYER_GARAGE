package fr.greta.java.box.persistence;

import fr.greta.java.ConnectionFactory;
import fr.greta.java.generic.tools.JdbcTool;
import fr.greta.java.generic.exception.RepositoryException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoxRepository {

    private static final String SELECT_REQUEST = "SELECT id, label, secret_key, vehicle_id FROM box";
    private static final String ORDER_BY = SELECT_REQUEST + " ORDER BY label ASC";
    private static final String WHERE_ID = " WHERE id = ?";

    private static final String SELECT_REQUEST_WHERE_ID = SELECT_REQUEST + WHERE_ID;
    private static final String UPDATE_VEHICLE_REQUEST = "UPDATE box SET vehicle_id = ?" + WHERE_ID;

    private ConnectionFactory connectionFactory = new ConnectionFactory();

    public List<BoxEntity> findAll() throws RepositoryException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try {
            conn = connectionFactory.create();
            stmt = conn.prepareStatement(ORDER_BY);
            resultSet = stmt.executeQuery();

            List<BoxEntity> list = new ArrayList<>();
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



    public BoxEntity findById(int boxId) throws RepositoryException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try {
            conn = connectionFactory.create();
            stmt = conn.prepareStatement(SELECT_REQUEST_WHERE_ID);
            stmt.setInt(1, boxId);
            resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return toEntity(resultSet);
            }
            throw new RepositoryException("Erreur lors de l'execution de la requête:" + SELECT_REQUEST);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RepositoryException("Erreur lors de l'execution de la requête:" + SELECT_REQUEST, e);
        } finally {
            JdbcTool.close(resultSet, stmt, conn);
        }
    }

    public BoxEntity updateVehicle(BoxEntity entity) throws RepositoryException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            conn = connectionFactory.create();
            preparedStatement = conn.prepareStatement(UPDATE_VEHICLE_REQUEST);
            preparedStatement.setInt(1, entity.getVehicleId());
            preparedStatement.setInt(2, entity.getId());
            preparedStatement.executeUpdate();
            return entity;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RepositoryException("Erreur lors de l'execution de la requête:" + UPDATE_VEHICLE_REQUEST, e);
        } finally {
            JdbcTool.close(rs, preparedStatement, conn);
        }
    }

    public BoxEntity removeVehicle(BoxEntity entity) throws RepositoryException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            conn = connectionFactory.create();
            preparedStatement = conn.prepareStatement(UPDATE_VEHICLE_REQUEST);
            preparedStatement.setNull(1, Types.NULL);
            preparedStatement.setInt(2, entity.getId());
            preparedStatement.executeUpdate();
            return entity;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RepositoryException("Erreur lors de l'execution de la requête:" + UPDATE_VEHICLE_REQUEST, e);
        } finally {
            JdbcTool.close(rs, preparedStatement, conn);
        }
    }



    private BoxEntity toEntity(ResultSet resultSet) throws SQLException {
        BoxEntity entity = new BoxEntity();
        entity.setId(resultSet.getInt("id"));
        entity.setLabel(resultSet.getString("label"));
        entity.setSecretKey(resultSet.getString("secret_key"));
        entity.setVehicleId(resultSet.getInt("vehicle_id"));
        return entity;
    }



}


