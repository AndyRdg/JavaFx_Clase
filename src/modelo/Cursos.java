/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import static db.Database.getConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author AndyRd
 */
public class Cursos {
    int ind_curso;
    String denominacion;
    String etapa;

    public Cursos(int ind_curso, String denominacion, String etapa) {
        this.ind_curso = ind_curso;
        this.denominacion = denominacion;
        this.etapa = etapa;
    }

    public Cursos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getInd_curso() {
        return ind_curso;
    }

    public void setInd_curso(int ind_curso) {
        this.ind_curso = ind_curso;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    @Override
    public String toString() {
        return denominacion;
    }

    public ObservableList<Cursos> getCursos() {
        
        ObservableList<Cursos> obs_c = FXCollections.observableArrayList();
            
            try {
                
                Connection conexion = getConnection();
                Statement consulta = conexion.createStatement();
                consulta.executeQuery("SELECT * FROM cursos");
                ResultSet rs = consulta.getResultSet();
                
            while (rs.next()) {
                int ind_curso = rs.getInt("ind_curso");
                String denominacion = rs.getString("denominacion");
                String etapa = rs.getString("etapa");
            
            // Creo el alumno
            Cursos c = new Cursos(ind_curso, denominacion, etapa);
            
            obs_c.add(c);
            }
            conexion.close();
            } catch (SQLException ex) {
            Logger.getLogger(Cursos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return obs_c;
}
    }