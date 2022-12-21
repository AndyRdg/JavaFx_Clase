/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AndyRd
 */
public class MenuController implements Initializable {

    @FXML
    private Button btnIntroducir;
    @FXML
    private Button btnConsultar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void introducirMatricula(ActionEvent event) {
        try {
// Cargo la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/InsertarMatricula.fxml"));

            // Cargo el padre
            Parent root = loader.load();

            // Obtengo el controlador
            InsertarMatriculaController controlador = loader.getController();

            // Creo la scene y el stage
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("GRABAR MATRICULA");
            stage.setScene(scene);
            stage.showAndWait();



        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void consultarMatricula(ActionEvent event) {
        try {
// Cargo la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ConsultarMatricula.fxml"));

            // Cargo el padre
            Parent root = loader.load();

            // Obtengo el controlador
            ConsultarMatriculaController controlador = loader.getController();

            // Creo la scene y el stage
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("CONSULTA DE MATRICULAS");
            stage.setScene(scene);
            stage.showAndWait();



        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        
    
}
