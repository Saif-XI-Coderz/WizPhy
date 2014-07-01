/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wizphy.controller;

import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.tan;
import static java.lang.Math.toRadians;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.util.Duration;
import wizphy.ControlledScreen;
import wizphy.ScreensController;

/**
 * FXML Controller class
 *
 * @author Sherlock
 */
public class LabProjectileMotionController implements Initializable, ControlledScreen {
    ScreensController myController;
    @FXML
    private ImageView cannonball;
    @FXML
    private ImageView cannon;
    @FXML
    private ImageView fire;
    @FXML
    private Color x1;
    @FXML
    private TextField txtAngle;
    @FXML
    private TextField txtInitialSpeed;
    @FXML
    private AnchorPane demoArea;
    PathTransition projectileMotion;
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnStopClicked(ActionEvent event) {
        projectileMotion.stop();
    }
    @FXML
    private void btnPauseClicked(ActionEvent event) {
        projectileMotion.pause();
    }

    @FXML
    private void btnStartClicked(ActionEvent event) {
        //initial velocity
        int v0 = Integer.parseInt(txtInitialSpeed.getText());
        //angle of projection
        int angle = Integer.parseInt(txtAngle.getText());
        //convert degrees to radians
        double theta = toRadians(angle);
        //Earth's gravitational constant
        double g = 10.0;
        //Horizontal displacement achieved by object
        double range=v0*v0*sin(2*theta)/g;
        range*=50;
        //The highest displacement achieved by object
        double height=v0*v0*sin(theta)*sin(theta)/(2*g);
        height*=50;
        
        //Time spent in air by object
        double timeOfFlight=2*v0*sin(theta)/g;
        //Offsetting the values according to its initial positioning on screen
        double offsetX = cannonball.getFitWidth()/2;
        double offsetY = cannonball.getFitHeight()/2;
        //Calculating starting point of projectile motion
        double startX = cannonball.getX() + offsetX;
        double startY = cannonball.getY() + offsetY;
        //Calculating ending point of projectile motion
        double endX=range+79.0f+offsetX;
        double endY=cannonball.getY()+offsetY;
        //calculation apex coordinates of projectile motion
        double midFlightX=(startX+endX)/2;
        double midFlightY=height;
        //Calculation the bezier control point for the quadratic curve
        double controlPointX=2*midFlightX - startX/2.0f - endX/2.0f;
        double controlPointY=2*midFlightY - startY/2.0f - endY/2.0f;  
        
        /*double tanTheta = tan(theta);
        double cosTheta = cos(theta);
        double a = tanTheta;
        double b = g/(2*pow(v0*cosTheta,2));*/        
        //Start of transition
        
        MoveTo moveTo = new MoveTo();
        moveTo.setX(startX);
        moveTo.setY(startY);
        //Calculating trajectory to be followed by object (bezier curve)
        QuadCurveTo quadCurve = new QuadCurveTo();
        //setting control point for quadratic bezier curve
        quadCurve.setControlX(controlPointX);
        quadCurve.setControlY(controlPointY);
        //setting ending point of curve
        quadCurve.setX(endX);
        quadCurve.setY(endY);
        //Creates the path based on the starting point and the curve
        Path path = new Path();
        path.getElements().add(moveTo);
        path.getElements().add(quadCurve); 
        //makes path visible
        path.setOpacity(0.4);
        //shows the path on the screen
        demoArea.getChildren().add(path);
        
        //Creates a path transition object with the above calculated variables
        projectileMotion = new PathTransition(Duration.seconds(timeOfFlight),path,cannonball);
        projectileMotion.setCycleCount(PathTransition.INDEFINITE);  
        projectileMotion.setInterpolator(Interpolator.EASE_IN);
        projectileMotion.play();             
    }

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
    
}
