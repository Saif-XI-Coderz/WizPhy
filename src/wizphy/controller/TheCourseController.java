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
import javafx.scene.layout.AnchorPane;
import wizphy.controller.TheCourseOptionsController;
import static wizphy.controller.TheCourseOptionsController.currentVideo;
import static wizphy.controller.TheCourseOptionsController.currentQuiz;

/**
 * FXML Controller class
 * This is the controller class for the screen "The Course"
 * In javafx controller classes controls the behaviour of UIs defined in fxml
 * It must implement Initializable
 * ControlledScreen is used to enable us to switch back and forth between this screen and other
 * @author Sherlock
 */
public class TheCourseController implements Initializable, ControlledScreen {

    //Declaring the child GUI of this class
    public static String WebViewID = "webview2";
    public static String WebViewFile = "gui/TheCourseWebView.fxml";
    public static String CourseOptionID = "course_options";
    public static String CourseOptionFile = "gui/TheCourseOptions.fxml";
    //Controller classes for screens management
    ScreensController myController;
    ScreensController subController;
    //AnchorPane that will be injected from fxml file
    @FXML
    AnchorPane contentArea;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Course Controller initializing");
        subController = new ScreensController();
        //loads the child gui in the subController
        subController.loadScreen(CourseOptionID, CourseOptionFile);
        subController.loadScreen(WebViewID, WebViewFile);  
        contentArea.getChildren().addAll(subController);
    }    

    @Override
    public void setScreenParent(ScreensController screenParent) {
        //initilize the parent of this class so that it can be managed by its parent
        myController = screenParent;
    }
    
    @FXML
    private void goToHomework(ActionEvent event){
       myController.setScreen(WizPhy.TheHomeworkID);
    }
    
    @FXML
    private void goToLabs(ActionEvent event){
       myController.setScreen(WizPhy.TheLabID);
    }
    
    public void lbl1Clicked(){
        TheCourseOptionsController.currentNotes="src\\wizphy\\theCourseNotes\\kinematics\\Linear_Motion.html";   
        currentQuiz="Kinematics.pdf";
        currentVideo="Introduction_to_Vectors_and_Scalars.mp4";
        subController.setScreen(CourseOptionID); 
    }
    
    /**
    * Method called when selected topic clicked in the accordion
    * It set the CourseOptions variables for this topic and displayes the screen
    **/
    public void lbl2Clicked(){
        //Notes for current topic
        TheCourseOptionsController.currentNotes="src\\wizphy\\theCourseNotes\\kinematics\\Nonlinear_Motion.html";
        //Quiz for current topic
        currentQuiz="Kinematics.pdf";
        currentVideo="Newton's_First_Law_of_Motion.mp4";
        //Displayed the course option screen on the left side of the split pane
        subController.setScreen(CourseOptionID); 
    }
	
    public void lbl3Clicked(){        
        TheCourseOptionsController.currentNotes="src\\wizphy\\theCourseNotes\\dynamics\\Linear_momentum_and_its_conservation.html";
        currentQuiz="DynamicsForces1.pdf";
        currentVideo="Newton's_Second_Law_of_Motion.mp4";
        subController.setScreen(CourseOptionID);
    }
    public void lbl4Clicked(){
        TheCourseOptionsController.currentNotes="src\\wizphy\\theCourseNotes\\dynamics\\Newton_Law_of_Motion.html";
        currentQuiz="DynamicsForces2.pdf";
        currentVideo="Newton's_Third_Law_of_Motion.mp4";
        subController.setScreen(CourseOptionID);
    }
	
    public void lbl5Clicked(){
        TheCourseOptionsController.currentNotes="src\\wizphy\\theCourseNotes\\forces\\Types_of_forces.html";
        currentQuiz="DynamicsForces1.pdf";
        currentVideo="Newton's_First_Law_of_Motion.mp4";
        subController.setScreen(CourseOptionID);
    }
    public void lbl6Clicked(){
        TheCourseOptionsController.currentNotes="src\\wizphy\\theCourseNotes\\forces\\Centre_of_Gravity.html";
        currentQuiz="DynamicsForces2.pdf";
        currentVideo="Newton's_Second_Law_of_Motion.mp4";
        subController.setScreen(CourseOptionID);
    }
    public void lbl7Clicked(){
        TheCourseOptionsController.currentNotes="src\\wizphy\\theCourseNotes\\forces\\Turning_effects_of_forces.html";
        currentQuiz="DynamicsForces2.pdf";
        currentVideo="Newton's_Third_Law_of_Motion.mp4";
        subController.setScreen(CourseOptionID);
    }
    public void lbl8Clicked(){
        TheCourseOptionsController.currentNotes="src\\wizphy\\theCourseNotes\\forces\\Equilibrium_of_forces.html";
        currentQuiz="DynamicsForces2.pdf";
        currentVideo="Newton's_First_Law_of_Motion.mp4";
        subController.setScreen(CourseOptionID);
    }
    public void lbl9Clicked(){
        TheCourseOptionsController.currentNotes="src\\wizphy\\theCourseNotes\\wpe\\Kinetic_Energy.html";
        currentQuiz="WPE1.pdf";
        currentVideo="Newton's_Second_Law_of_Motion";
        subController.setScreen(CourseOptionID);
    }
    public void lbl10Clicked(){
        TheCourseOptionsController.currentNotes="src\\wizphy\\theCourseNotes\\wpe\\Potential_Energy.html";
        currentQuiz="WPE2.pdf";
        currentVideo="Newton's_First_Law_of_Motion.mp4";
        subController.setScreen(CourseOptionID);
    }
    public void lbl11Clicked(){
        TheCourseOptionsController.currentNotes="src\\wizphy\\theCourseNotes\\wpe\\Internal_Energy.html";
        currentQuiz="WPE1.pdf";
        currentVideo="Newton's_First_Law_of_Motion.mp4";
        subController.setScreen(CourseOptionID);
    }
    public void lbl12Clicked(){
        TheCourseOptionsController.currentNotes="src\\wizphy\\theCourseNotes\\wpe\\Energy_conversion_and_conservation.html";
        currentQuiz="WPE2.pdf";
        currentVideo="Newton's_First_Law_of_Motion.mp4";
        subController.setScreen(CourseOptionID);
    }
    public void lbl13Clicked(){
        TheCourseOptionsController.currentNotes="src\\wizphy\\theCourseNotes\\wpe\\Work_and_Power.html";
        currentQuiz="WPE1.pdf";
        currentVideo="Newton's_First_Law_of_Motion.mp4";
        subController.setScreen(CourseOptionID);
    }
	
    public void lbl14Clicked(){
        TheCourseOptionsController.currentNotes="src\\wizphy\\theCourseNotes\\circular_motion\\Centripetal_Force.html";
        currentQuiz="CircularMotion.pdf";
        currentVideo="Introduction_to_Vectors_and_Scalars.mp4";
        subController.setScreen(CourseOptionID);
    }
    public void lbl15Clicked(){
        TheCourseOptionsController.currentNotes="src\\wizphy\\theCourseNotes\\circular_motion\\Centripetal_Acceleration.html";
        currentQuiz="CircularMotion.pdf";
        currentVideo="Introduction_to_Vectors_and_Scalars.mp4";
        subController.setScreen(CourseOptionID);
    }
    public void lbl16Clicked(){
        TheCourseOptionsController.currentNotes="src\\wizphy\\theCourseNotes\\circular_motion\\Kinematics_of_a_Uniform_Circular_Motion.html";
        currentQuiz="CircularMotion.pdf";
        currentVideo="Introduction_to_Vectors_and_Scalars.mp4";
        subController.setScreen(CourseOptionID);
    }
	
    public void lbl17Clicked(){
        TheCourseOptionsController.currentNotes="src\\wizphy\\theCourseNotes\\gravitational_field\\Gravitational_Field.html";
        currentQuiz="GravitationalField.pdf";
        currentVideo="Introduction_to_Gravity.mp4";
        subController.setScreen(CourseOptionID);
    }
    public void lbl18Clicked(){
        TheCourseOptionsController.currentNotes="src\\wizphy\\theCourseNotes\\gravitational_field\\Gravitational_Potential.html";
        currentQuiz="GravitationalField.pdf";
        currentVideo="Introduction_to_Gravity.mp4";
        subController.setScreen(CourseOptionID);
    }
    public void lbl19Clicked(){
        TheCourseOptionsController.currentNotes="src\\wizphy\\theCourseNotes\\gravitational_field\\Field_of_a_Point_Mass.html";
        currentQuiz="GravitationalField.pdf";
        currentVideo="Introduction_to_Gravity.mp4";
        subController.setScreen(CourseOptionID);
    }
    public void lbl20Clicked(){
        TheCourseOptionsController.currentNotes="src\\wizphy\\theCourseNotes\\gravitational_field\\Force_between_point_masses.html";
        currentQuiz="GravitationalField.pdf";
        currentVideo="Introduction_to_Gravity.mp4";
        subController.setScreen(CourseOptionID);
    }
    public void lbl21Clicked(){       
        TheCourseOptionsController.currentNotes="src\\wizphy\\theCourseNotes\\gravitational_field\\Field_near_to_the_surface_of_the_earth.html";
        currentQuiz="GravitationalField.pdf";
        currentVideo="Introduction_to_Gravity.mp4";
        subController.setScreen(CourseOptionID);
    }
    
}
