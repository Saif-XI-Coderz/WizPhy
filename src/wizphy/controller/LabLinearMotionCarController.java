/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wizphy.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.animation.TranslateTransitionBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import wizphy.ControlledScreen;
import wizphy.ScreensController;

/**
 * FXML Controller class
 *
 * @author Sherlock
 */
public class LabLinearMotionCarController implements Initializable, ControlledScreen {
    ScreensController myController;
    @FXML
    private Group grpToAnimate;
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
    @FXML
    private TextField txtVelocity,txtAccn;
    
    @FXML
    Slider sliderSpaceScale,sliderTimeScale;
    @FXML
    private AnchorPane demoArea;
    @FXML
    TranslateTransition tt;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void btnStartClicked(){           
        double pixelsDistance = demoArea.getWidth()-100.0;//length the object will travel on screen        
        int velocity = Integer.parseInt(txtVelocity.getText());//its speed as defined by user
        int spaceScale = (int) sliderSpaceScale.getValue(); //1px on screen = ? meters
        double timeScale = (int) sliderTimeScale.getValue();//1sec in application = ? sec in real life
        double distance = pixelsDistance * spaceScale;//length object is actually moving in real life 
        lbl_dist_travelled.setText("Distance: "+distance + "m");
        double time = distance/velocity;//time to travel as computed by its distance and speed       
        tt=TranslateTransitionBuilder.create()
                 .node(grpToAnimate)
                 .fromX(0)
                 .toX(pixelsDistance)
                 .duration(Duration.seconds(time))
                 .rate(timeScale)
                 .interpolator(Interpolator.LINEAR)
                 .cycleCount(Timeline.INDEFINITE)
                 .autoReverse(true)
                 .onFinished(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        System.out.println("Not supported yet.");
                    }                     
                 })                
                 .build();
        tt.play();                
    }
    
    @FXML
    public void btnStopClicked(ActionEvent event){
        tt.stop();
    }
    
    @FXML
    public void btnPauseClicked(ActionEvent event){
        tt.pause();
    }

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
}
