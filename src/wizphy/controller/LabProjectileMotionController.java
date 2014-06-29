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
        int v0 = Integer.parseInt(txtInitialSpeed.getText());
        int angle = Integer.parseInt(txtAngle.getText());
        double theta = toRadians(angle);
        double g = 10.0;
        double range=v0*v0*sin(2*theta)/g;
        range*=50;
        double height=v0*v0*sin(theta)*sin(theta)/(2*g);
        height*=50;
        double timeOfFlight=2*v0*sin(theta)/g;
        double offsetX = cannonball.getFitWidth()/2;
        double offsetY = cannonball.getFitHeight()/2;
        double startX = cannonball.getX() + offsetX;
        double startY = cannonball.getY() + offsetY;
        double endX=range+79.0f+offsetX;
        double endY=cannonball.getY()+offsetY;
        double midFlightX=(startX+endX)/2;
        double midFlightY=height;
        double controlPointX=2*midFlightX - startX/2.0f - endX/2.0f;
        double controlPointY=2*midFlightY - startY/2.0f - endY/2.0f;        
        /*double tanTheta = tan(theta);
        double cosTheta = cos(theta);
        double a = tanTheta;
        double b = g/(2*pow(v0*cosTheta,2));*/        
        MoveTo moveTo = new MoveTo();
        moveTo.setX(startX);
        moveTo.setY(startY);
        QuadCurveTo quadCurve = new QuadCurveTo();
        
        System.out.println(cannonball.getX());
        System.out.println(cannonball.getY());
        System.out.println(midFlightX);
        System.out.println(midFlightY);
        System.out.println(startX);
        System.out.println(startY);
        System.out.println(endX);
        System.out.println(endY);
        System.out.println(controlPointX);
        System.out.println(controlPointY);
        
        quadCurve.setControlX(controlPointX);
        quadCurve.setControlY(controlPointY);
        quadCurve.setX(endX);
        quadCurve.setY(endY);
        Path path = new Path();
        path.getElements().add(moveTo);
        path.getElements().add(quadCurve);        
        path.setOpacity(0.4);
        demoArea.getChildren().add(path);
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
