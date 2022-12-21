/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import db.Database;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Alumnos;
import modelo.Cursos;

/**
 * FXML Controller class
 *
 * @author AndyRd
 */
public class InsertarMatriculaController implements Initializable {

    @FXML
    private ComboBox<Cursos> cmbCurso;
    @FXML
    private ComboBox<Alumnos> cmbAlumno;
    @FXML
    private DatePicker dtpFechaMatricula;
    @FXML
    private TextField txtMatricula;
    @FXML
    private TextField txtNif;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtPoblacion;
    @FXML
    private TextField txtIdCurso;
    @FXML
    private TextField txtDenominacion;
    @FXML
    private TextField txtEtapa;
    @FXML
    private Button btnGrabarMatricula;
    @FXML
    private Button btnVolver;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        iniciarCombos();
    }    
    
    public void iniciarCombos(){
        Alumnos a = new Alumnos();
        ObservableList<Alumnos> obs_a = a.getAlumnos();
        this.cmbAlumno.setItems(obs_a);
        
        Cursos c = new Cursos();
        ObservableList<Cursos> obs_c = c.getCursos();
        this.cmbCurso.setItems(obs_c);
        
        
    }

    @FXML
    private void seleccionarCurso(ActionEvent event) {
        Cursos c = this.cmbCurso.getValue();
        
        if (c != null) {
             this.txtIdCurso.setText(c.getInd_curso()+"");
             this.txtDenominacion.setText(c.getDenominacion());
             this.txtEtapa.setText(c.getEtapa());
            
        }
    }

    @FXML
    private void seleccionarAlumno(ActionEvent event) {
        Alumnos a = this.cmbAlumno.getValue();
        
        if (a != null){
            this.txtMatricula.setText(a.getMatricula());
            this.txtNif.setText(a.getNif());
            this.txtNombre.setText(a.getNombre());
            this.txtDireccion.setText(a.getDireccion());
            this.txtPoblacion.setText(a.getPoblacion());
            
        }
    }

    @FXML
    private void introducirMatricula(ActionEvent event) {
    }

    @FXML
    private void volverMenu(ActionEvent event) {
               // Cerrar ventana
        Stage stage = (Stage) this.btnVolver.getScene().getWindow();
        stage.close();
    }
    
}
