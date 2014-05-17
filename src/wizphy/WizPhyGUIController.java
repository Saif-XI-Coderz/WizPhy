/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wizphy;

import java.net.URL;
import java.nio.file.Paths;

import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.animation.TranslateTransitionBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
    AnchorPane demoArea;
    @FXML
    TextField txtfldVelocity,txtfldAccn;

    @FXML
    Label lblDistance,lblTimeScale,lblSpaceScale;
    @FXML
    Slider sliderSpaceScale,sliderTimeScale;
    
    TranslateTransition tt;

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
        double middleHeight = demoArea.getHeight()/2;
        final Circle circle = new Circle(25.0, middleHeight, 25.0, Color.web("1c89f4"));
        circle.setEffect(new Lighting());
        demoArea.getChildren().add(circle);
        lblSpaceScale.textProperty().bind(sliderSpaceScale.valueProperty().asString());
        lblTimeScale.textProperty().bind(sliderTimeScale.valueProperty().asString());
        //System.out.println("Hello world!");
    }
   
    public void btnStartClicked(ActionEvent event){
        double middleHeight = demoArea.getHeight()/2;
        final Circle circle = new Circle(25.0, middleHeight, 25.0, Color.web("1c89f4"));
        circle.setEffect(new Lighting());
        demoArea.getChildren().remove(1);
        demoArea.getChildren().add(circle);
        double pixelsDistance = demoArea.getWidth() - 50.0 ;//length the object will travel on screen        
        int velocity = Integer.parseInt(txtfldVelocity.getText());//its speed as defined by user
        int spaceScale = (int) sliderSpaceScale.getValue(); //1px on screen = ? meters
        double timeScale = (int) sliderTimeScale.getValue();//1sec in application = ? sec in real life
        double distance = pixelsDistance * spaceScale;//length object is actually moving in real life 
        lblDistance.setText("Distance: "+distance + "m");
        double time = distance/velocity;//time to travel as computed by its distance and speed

        tt=TranslateTransitionBuilder.create()
                 .node(circle)
                 .toX(pixelsDistance)
                 .duration(Duration.seconds(time))
                 .rate(timeScale)
                 .interpolator(Interpolator.LINEAR)
                 .cycleCount(Timeline.INDEFINITE)
                 .autoReverse(true)
                 .build();
        tt.play();
                 
        //System.out.println("Hello world");
    }
    
    public void btnStopClicked(ActionEvent event){
        tt.stop();
    }
    
    public void btnPauseClicked(ActionEvent event){
        tt.pause();
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
