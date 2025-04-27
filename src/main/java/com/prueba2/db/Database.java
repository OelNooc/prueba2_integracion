package com.prueba2.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String JDBC_URL = "jdbc:h2:./h2-database";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    public static void init() {
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute("""
                        CREATE TABLE IF NOT EXISTS Persona (
                            Rut VARCHAR(20) PRIMARY KEY,
                            Nombres VARCHAR(100),
                            ApellidoPaterno VARCHAR(100),
                            ApellidoMaterno VARCHAR(100),
                            Telefono VARCHAR(20),
                            FechaIngreso VARCHAR(20)
                        );
                    """);

            stmt.execute("""
                        CREATE TABLE IF NOT EXISTS Usuario (
                            Rut VARCHAR(20) PRIMARY KEY,
                            Username VARCHAR(50),
                            Password VARCHAR(100),
                            FOREIGN KEY (Rut) REFERENCES Persona(Rut)
                        );
                    """);

            System.out.println("Tablas creadas correctamente.");

            stmt.execute("""
                        MERGE INTO Persona KEY(Rut) 
                        VALUES ('11111111-1', 'Juan', 'Pérez', 'González', '123456789', '2024-04-25');
                    """);

            stmt.execute("""
                        MERGE INTO Usuario KEY(Rut)
                        VALUES ('11111111-1', 'juanperez', '1234');
                    """);

            System.out.println("Usuario de test juanperez creado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
