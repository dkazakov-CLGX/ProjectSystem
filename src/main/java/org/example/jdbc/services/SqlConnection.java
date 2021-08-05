package org.example.jdbc.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.SneakyThrows;
import org.example.jdbc.controller.DatabaseConnection;
import org.example.jdbc.model.BaseModel;
import org.example.jdbc.utils.PropertiesLoader;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public abstract class SqlConnection<T extends BaseModel<Long>> implements Closeable {

    private final ObjectMapper mapper;

    private final String[] fieldNames;

    @Getter(AccessLevel.PROTECTED)
    protected final Connection connection;

    private final String databaseSchemaName;

    @Getter(AccessLevel.PROTECTED)
    protected final PreparedStatement findAllPreparedStatement;

//    @Getter(AccessLevel.PROTECTED)
//    protected final PreparedStatement findByIDPreparedStatement;
//
//    @Getter(AccessLevel.PROTECTED)
//    protected final PreparedStatement deletePreparedStatement;
//
//    @Getter(AccessLevel.PROTECTED)
//    protected final PreparedStatement updatePreparedStatement;

    @SneakyThrows
    public SqlConnection(String tableName, String... fieldNames) {
        this.mapper = new ObjectMapper();
        this.fieldNames = fieldNames;
        connection = DatabaseConnection.getInstance().getConnection();
        databaseSchemaName = PropertiesLoader.getProperties("db.schemaName");
        findAllPreparedStatement = connection.prepareStatement("SELECT * FROM " + databaseSchemaName + "." + tableName);
//        findByIDPreparedStatement = connection.prepareStatement("SELECT FROM " + databaseSchemaName + "." + tableName + " WHERE id=" + tableName+".id");
//        deletePreparedStatement = connection.prepareStatement("DELETE FROM "+ databaseSchemaName+"."+tableName+" WHERE id=" + "id");
//        updatePreparedStatement = connection.prepareStatement("UPDATE "+ databaseSchemaName+"."+tableName+" set "+fieldNames+"=?, "+fieldNames+"=?,"+fieldNames+"=? WHERE id= "+"id"+";");
    }

    @SneakyThrows
    protected List<T> parse(ResultSet resultSet) {
        final List<Map<String, Object>> result = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> objectMap = new HashMap<>();
            for (String fieldName : fieldNames) {
                objectMap.put(fieldName, resultSet.getObject(fieldName));
                result.add(objectMap);
            }
        }
        return mapper.convertValue(result, List.class);
    }

    @SneakyThrows
    @Override
    public void close() {
        connection.close();
    }
}
