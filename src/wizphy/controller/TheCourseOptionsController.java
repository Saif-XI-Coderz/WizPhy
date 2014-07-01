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
    /**
    * Handler function when "Video" button is clicked
    **/
    private void watchVideo(ActionEvent event) {
        //The folder path of the location of the videos
        String path = "file:/C:/Users/Sherlock/Documents/GitHub/WizPhy/src/wizphy/course_videos/";
        //Creates a new instance of our custom video player and initializing the video it has to play
        VideoPlayer player = new VideoPlayer(path+currentVideo);
        //Shows our video player on the screen with the video loaded and paused at the start
        player.show();
    }

    @FXML
    /**
    * Handler function when "Notes" button is clicked
    **/
    private void readNotes(ActionEvent event){
        //A webview in javafx is used to display html data and webpages
        WebView myWebView=new WebView();    
        //loads the current notes in the web engine of the webview
        myWebView.getEngine().load(Paths.get(currentNotes).toAbsolutePath().toUri().toString());
        Group group =new Group();
        //add webview to group
        group.getChildren().addAll(myWebView);
        //add group to scene
        Scene scene = new Scene(group);
        Stage stage = new Stage();
        //add scene to stage
        stage.setScene(scene);
        //show the stage
        stage.show();
    }

    @FXML
    /**
    * Handler function when "Quiz" button is clicked
    **/
    private void takeQuiz(ActionEvent event) {
        //use the HostServices of the application to open the current quiz in the browser
        wizPhyHostServices.showDocument("http://localhost:8080/Test1/"+currentQuiz);
    }    
}
