/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import modelo.Alumnos;

/**
 *
 * @author AndyRd
 */
public class Database {
     public static Connection getConnection() throws SQLException {
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/clase", "root", "");
        
        
        if (conexion != null) {
		System.out.println("Conexion establecida!");
                return conexion;
			}
        } catch (ClassNotFoundException | SQLException e) { 
        //Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        
			// Si hay algun fallo de conexion mostramos alerta.
			System.out.println("Fallo en la Conexion");
			Alert error = new Alert(Alert.AlertType.ERROR);
			error.setTitle("Error");
			error.setContentText("Error al conectar con la base de datos");
			error.showAndWait();
			e.printStackTrace();
		}
        
        
        return null;
        }

    
    
}
