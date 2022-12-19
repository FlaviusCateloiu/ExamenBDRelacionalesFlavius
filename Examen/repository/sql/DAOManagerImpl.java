package dao.sql;

import dao.DAOManager;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOManagerImpl implements DAOManager {
    final String RUTABASE = Path.of("Examen/db/examen.db").toString();
    private Connection conexion;

    public DAOManagerImpl() {
        try {
            conexion = DriverManager.getConnection("jdbc:sqlite:" + RUTABASE);
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void close() {
        try {
            conexion.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
