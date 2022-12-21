package modelo;

import static db.Database.getConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author AndyRd
 */
public class Alumnos {
    String matricula;
    String nombre;
    String direccion;
    String poblacion;
    String nif;
    String tlf;

    public Alumnos(String matricula, String nombre, String direccion, String poblacion, String nif, String tlf) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.nif = nif;
        this.tlf = tlf;
    }

    public Alumnos() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    @Override
    public String toString() {
        return nombre ;
    }
    
    public static ObservableList<Alumnos> getAlumnos() {
      
            ObservableList<Alumnos> obs_a = FXCollections.observableArrayList();
            
            try {
                
                Connection conexion = getConnection();
                Statement consulta = conexion.createStatement();
                consulta.executeQuery("SELECT * FROM alumnos");
                ResultSet rs = consulta.getResultSet();
                
            while (rs.next()) {
                String matricula = rs.getString("matricula");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String poblacion = rs.getString("poblacion");
                String nif = rs.getString("nif");
                String tlf = rs.getString("telefono");
            
            // Creo el alumno
            Alumnos a = new Alumnos(matricula, nombre, direccion, poblacion, nif, tlf);
            obs_a.add(a);
            }
            conexion.close();
            } catch (SQLException ex) {
            Logger.getLogger(Alumnos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return obs_a;
}
    }
    
    
    
    
    
