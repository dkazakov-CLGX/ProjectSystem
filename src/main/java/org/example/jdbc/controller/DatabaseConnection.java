package org.example.jdbc.controller;

import lombok.SneakyThrows;
import org.example.jdbc.utils.PropertiesLoader;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection implements Closeable {
    private static final String URL = PropertiesLoader.getProperties("db.url");
    private static final String USERNAME = PropertiesLoader.getProperties("db.name");
    private static final String PASSWORD = PropertiesLoader.getProperties("db.password");
    private static final String JDBC_DRIVER = PropertiesLoader.getProperties("db.driver");
    private static DatabaseConnection databaseConnection;
    private final Connection connection;

    @SneakyThrows
    public DatabaseConnection() {
        Class.forName(JDBC_DRIVER);
        this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static DatabaseConnection getInstance() {
        if (databaseConnection == null) {
            synchronized (DatabaseConnection.class) {
                if (databaseConnection == null) {
                    databaseConnection = new DatabaseConnection();
                }
            }
        }
        return databaseConnection;
    }

    public Connection getConnection() {
        return connection;
    }

    @SneakyThrows
    @Override
    public void close() {
        connection.close();
    }
}
