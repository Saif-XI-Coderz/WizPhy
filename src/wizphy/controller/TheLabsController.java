/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wizphy;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.animation.TranslateTransitionBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Sherlock
 */
public class TheLabsController implements Initializable, ControlledScreen {
    public static String CarLabID = "carlab";
    public static String CarLabFile = "gui/LabLinearMotionCar.fxml";
    public static String ProjectileLabID = "projectile";
    public static String ProjectileLabFile = "gui/LabProjectileMotion.fxml";
    
    ScreensController myController;
    ScreensController subController;
    @FXML
    AnchorPane labArea;
    /*
    @FXML
    TextField txtfldVelocity,txtfldAccn;

    @FXML
    Label lblDistance,lblTimeScale,lblSpaceScale;
    @FXML
    Slider sliderSpaceScale,sliderTimeScale;
    
    TranslateTransition tt;
    
   Image CAR_IMAGE = new Image(WizPhy.class.getResource("img/car.png").toString());*/
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        subController = new ScreensController();
        subController.loadScreen(CarLabID, CarLabFile);
        subController.loadScreen(ProjectileLabID, ProjectileLabFile);
        labArea.getChildren().addAll(subController);
    }    
    
    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
    
    @FXML
    private void goToHomework(ActionEvent event){
       myController.setScreen(WizPhy.TheHomeworkID);
    }
    
    @FXML
    private void goToCourse(ActionEvent event){
       myController.setScreen(WizPhy.TheCourseID);
    }
    
        
    @FXML
    public void loadCarLab(){
        System.out.println("width"+labArea.getWidth()+" height "+labArea.getHeight());
        subController.setScreen(CarLabID);
    }
    
    public void loadProjectileLab(){
        subController.setScreen(ProjectileLabID);
        /*ImageView car = new ImageView(CAR_IMAGE); 
        double middleHeight = demoArea.getHeight()/2;
        car.setY(middleHeight);
        demoArea.getChildren().addAll(car);
        lblSpaceScale.textProperty().bind(sliderSpaceScale.valueProperty().asString());
        lblTimeScale.textProperty().bind(sliderTimeScale.valueProperty().asString());*/
    }
   /*
    public void btnStartClicked(ActionEvent event){
        double middleHeight = demoArea.getHeight()/2;
        ImageView car = new ImageView(CAR_IMAGE);            
        car.setY(middleHeight);     
        demoArea.getChildren().remove(1);
        demoArea.getChildren().add(car);
        double pixelsDistance = demoArea.getWidth() - CAR_IMAGE.getWidth() ;//length the object will travel on screen        
        int velocity = Integer.parseInt(txtfldVelocity.getText());//its speed as defined by user
        int spaceScale = (int) sliderSpaceScale.getValue(); //1px on screen = ? meters
        double timeScale = (int) sliderTimeScale.getValue();//1sec in application = ? sec in real life
        double distance = pixelsDistance * spaceScale;//length object is actually moving in real life 
        lblDistance.setText("Distance: "+distance + "m");
        double time = distance/velocity;//time to travel as computed by its distance and speed

        tt=TranslateTransitionBuilder.create()
                 .node(car)
                 .toX(pixelsDistance)
                 .duration(Duration.seconds(time))
                 .rate(timeScale)
                 .interpolator(Interpolator.LINEAR)
                 .cycleCount(2)
                 .autoReverse(true)
                 .onFinished(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        System.out.println("Not supported yet.");
                    }                     
                 })                
                 .build();
        tt.play();                
        //System.out.println("Hello world");
    }
     
    public void btnStopClicked(ActionEvent event){
        tt.stop();
    }
    
    public void btnPauseClicked(ActionEvent event){
        tt.pause();
    }*/
    
    @FXML
    public void lblCarRaceClicked(){
        openLab("ejs_bu_Car_Race2b.jar");
    }
    @FXML
    public void lblBoucingBallClicked(){
        openLab("ejs_mech_newton_CeilingBounce.jar");
    }
    @FXML
    public void lblPhysicalPendulumClicked(){
        openLab("ejs_mech_newton_PhysicalPendulumForces.jar");
    }
    @FXML
    public void lblInclinedPlaneClicked(){
        openLab("ejs_murcia_mech_SlidingDownAnInclinedPlane.jar");
    }
    @FXML
    public void lblAirplaneClicked(){
         openLab("ejs_murcia_mech_ThrowingPackageFromAnAirplane.jar");
    }
    
    public void openLab(String labName){
        String path = "C:\\Users\\Sherlock\\Documents\\GitHub\\WizPhy\\src\\wizphy\\lab_jars\\";
        String[] commands = {"java", "-jar",labName};
        ProcessBuilder pb=new ProcessBuilder(commands);
        pb.directory(new File(path));
        try {
            pb.start();
        } catch (IOException ex) {
            Logger.getLogger(TheLabsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
