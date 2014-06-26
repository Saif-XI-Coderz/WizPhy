/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wizphy;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Sherlock
 */
public class TheHomeWorkController implements Initializable, ControlledScreen {
    ScreensController myController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
    
    @FXML
    private void goToCourse(ActionEvent event){
       myController.setScreen(WizPhy.TheCourseID);
    }
    
    @FXML
    private void goToLabs(ActionEvent event){
       myController.setScreen(WizPhy.TheLabID);
    }
}
