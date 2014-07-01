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
    
    /**
    * EventHandler for when the start button is clicked
    **/
    @FXML
    public void btnStartClicked(){           
        //length the object will travel on screen 
        double pixelsDistance = demoArea.getWidth()-100.0;       
        //its speed as defined by user
        int velocity = Integer.parseInt(txtVelocity.getText());
        //1px on screen = ? meters
        int spaceScale = (int) sliderSpaceScale.getValue(); 
        //1sec in application = ? sec in real life
        double timeScale = (int) sliderTimeScale.getValue();
        //length object is actually moving in real life 
        double distance = pixelsDistance * spaceScale;
        lbl_dist_travelled.setText("Distance: "+distance + "m");
        //time to travel as computed by its distance and speed 
        double time = distance/velocity;      
        
        //Creates a translate transition with the following parameters
        demo=TranslateTransitionBuilder.create()
                 //Specify the component that will transition
                 .node(grpToAnimate)
                 //the horizontal starting point of the transition
                 .fromX(0)
                 //the horizontal ending point of the transition
                 .toX(pixelsDistance)
                 //time to complete the transition
                 .duration(Duration.seconds(time))
                 //The speed at which the transition will be played
                 .rate(timeScale)
                 //the method of interpolating intemediate points of the transition
                 .interpolator(Interpolator.LINEAR)
                 //No. of times animation should be played
                 .cycleCount(Timeline.INDEFINITE)
                 //Play the transition in reverse?
                 .autoReverse(true)
                 //Actions to be taken when transition is complete
                 .onFinished(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        //Do nothing yet
                    }                     
                 })                
                 .build();                  
        //Play the demo
        demo.play();                
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
