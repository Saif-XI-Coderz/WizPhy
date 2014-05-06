/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wizphy;

import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;

import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;

/**
 *
 * @author Sherlock
 */
public class WizPhyGUIController implements Initializable {
    @FXML
    WebView myWebView;
    @FXML
    Label motion1d;
    @FXML
    Label motion2d;
    @FXML
    Button btnStart;
    Timeline timeline;
    @FXML
    AnchorPane demoArea;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     /**
     * Called when the 1dMotion Label is clicked
     *
     * @param event the action event.
     */
    public void loadMotion1dDemo(){
        final Circle circle = new Circle(25.0, 25.0, 20.0, Color.web("1c89f4"));
        circle.setEffect(new Lighting());
        final Circle s  = new Circle();
        
        timeline = new Timeline();
        timeline.setCycleCount(timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.getKeyFrames().addAll
            (new KeyFrame(Duration.ZERO, 
                    new KeyValue(circle.translateXProperty(),0)),
            new KeyFrame(new Duration(4000), 
                    new KeyValue(circle.translateXProperty(),205)));
        demoArea.getChildren().add(circle);
        //System.out.println("Hello world!");
    }
    
    public void btnStartClicked(ActionEvent event){
        timeline.play();
        //System.out.println("Hello world");
    }
    
    public void lbl1Clicked(){
        showHtml("src\\wizphy\\theCourseNotes\\kinematics\\Linear_Motion.html");
    }
	public void lbl2Clicked(){
        showHtml("src\\wizphy\\theCourseNotes\\kinematics\\Nonlinear_Motion.html");
    }
	
	public void lbl3Clicked(){
        showHtml("src\\wizphy\\theCourseNotes\\dynamics\\Linear_momentum_and_its_conservation.html");
    }
	public void lbl4Clicked(){
        showHtml("src\\wizphy\\theCourseNotes\\dynamics\\Newton_Law_of_Motion.html");
    }
	
	public void lbl5Clicked(){
        showHtml("src\\wizphy\\theCourseNotes\\forces\\Types_of_forces.html");
    }
	public void lbl6Clicked(){
        showHtml("src\\wizphy\\theCourseNotes\\forces\\Centre_of_Gravity.html");
    }
	public void lbl7Clicked(){
        showHtml("src\\wizphy\\theCourseNotes\\forces\\Turning_effects_of_forces.html");
    }
	public void lbl8Clicked(){
        showHtml("src\\wizphy\\theCourseNotes\\forces\\Equilibrium_of_forces.html");
    }
    
	public void lbl9Clicked(){
        showHtml("src\\wizphy\\theCourseNotes\\wpe\\Kinetic_Energy.html");
    }
	public void lbl10Clicked(){
        showHtml("src\\wizphy\\theCourseNotes\\wpe\\Potential_Energy.html");
    }
	public void lbl11Clicked(){
        showHtml("src\\wizphy\\theCourseNotes\\wpe\\Internal_Energy.html");
    }
	public void lbl12Clicked(){
        showHtml("src\\wizphy\\theCourseNotes\\wpe\\Energy_conversion_and_conservation.html");
    }
	public void lbl13Clicked(){
        showHtml("src\\wizphy\\theCourseNotes\\wpe\\Work_and_Power.html");
    }
	
	public void lbl14Clicked(){
        showHtml("src\\wizphy\\theCourseNotes\\circular_motion\\Centripetal_Force.html");
    }
	public void lbl15Clicked(){
        showHtml("src\\wizphy\\theCourseNotes\\circular_motion\\Centripetal_Acceleration.html");
    }
	public void lbl16Clicked(){
        showHtml("src\\wizphy\\theCourseNotes\\circular_motion\\Kinematics_of_a_Uniform_Circular_Motion.html");
    }
	
	public void lbl17Clicked(){
        showHtml("src\\wizphy\\theCourseNotes\\gravitational_field\\Gravitational_Field.html");
    }
	public void lbl18Clicked(){
        showHtml("src\\wizphy\\theCourseNotes\\gravitational_field\\Gravitational_Potential.html");
    }
	public void lbl19Clicked(){
        showHtml("src\\wizphy\\theCourseNotes\\gravitational_field\\Field_of_a_Point_Mass.html");
    }
	public void lbl20Clicked(){
        showHtml("src\\wizphy\\theCourseNotes\\gravitational_field\\Force_between_point_masses.html");
    }
	public void lbl21Clicked(){
        showHtml("src\\wizphy\\theCourseNotes\\gravitational_field\\Field_near_to_the_surface_of_the_earth.html");
    }
    
    private void showHtml(String html){
        myWebView.getEngine().load(Paths.get(html).toAbsolutePath().toUri().toString());
    }
}
