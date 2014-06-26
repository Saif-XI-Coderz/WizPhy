/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wizphy.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Sherlock
 */
public class LabLinearMotionCarController implements Initializable {
    @FXML
    private ImageView car_side;
    @FXML
    private ImageView car_top;
    @FXML
    private Label lbl_velocity;
    @FXML
    private Label lbl_acceleration;
    @FXML
    private Label lbl_time_elapsed;
    @FXML
    private Label lbl_dist_travelled;
    @FXML
    private Label lbl_time_rem;
    @FXML
    private Label lbl_dist_rem;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
