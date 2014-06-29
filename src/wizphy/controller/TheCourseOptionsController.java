/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wizphy.controller;

import wizphy.VideoPlayer;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import wizphy.ControlledScreen;
import wizphy.ScreensController;
import static wizphy.WizPhy.wizPhyHostServices;

/**
 * FXML Controller class
 *
 * @author Sherlock
 */
public class TheCourseOptionsController implements Initializable, ControlledScreen  {
    ScreensController myController;
    public static String currentVideo;
    public static String currentNotes;
    public static String currentQuiz;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("TheCourseOptionsController initializing");
    }    
    
    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    @FXML
    private void watchVideo(ActionEvent event) {
        VideoPlayer player = new VideoPlayer(currentVideo);
        player.show();
    }

    @FXML
    private void readNotes(ActionEvent event){
        System.out.println(currentNotes);
        WebView myWebView=new WebView();    
        myWebView.getEngine().load(Paths.get(currentNotes).toAbsolutePath().toUri().toString());
        Group group =new Group();
        group.getChildren().addAll(myWebView);
        Scene scene = new Scene(group);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void takeQuiz(ActionEvent event) {
        wizPhyHostServices.showDocument("http://localhost:8080/Test1/Kinematics1.pdf");
    }    
}
