/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wizphy;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Sherlock
 * All JavaFX projects should have a class that extends the abstract class javafx.application.Application
 * This is the entry point into any JavaFX based software 
 */
public class WizPhy extends Application {
    //Declaring the various screens that we will switch back and forth
    //as and when the user navigates the software
    public static String TheCourseID = "main";
    public static String TheCourseFile = "gui/TheCourse.fxml";
    public static String TheHomeworkID = "thehomework";
    public static String TheHomeworkFile = "gui/TheHomeWork.fxml";
    public static String TheLabID = "thelab";
    public static String TheLabFile = "gui/TheLabs.fxml";
    //Setting the size of the screens as constanst
    //base on the dimentsion of the user's screen 
    private static final double SCREEN_WIDTH=Screen.getPrimary().getVisualBounds().getWidth();
    private static final double SCREEN_HEIGHT=Screen.getPrimary().getVisualBounds().getHeight();
    //ScreensController objects manages the loading and unloading of fxml files (GUI)
    static ScreensController mainContainer;
    static ScreensController subContainerCourse;
    //This class contains methods to provide host services
    public static HostServices wizPhyHostServices;
    
    @Override
    /**
    * start(javafx.stage.Stage) is the second method that is called when the application is launched
    * init() is the first one
    * start method gives us access to Stage called primaryStage 
    * The primaryStage is the top level window that contains all the other GUIs
    **/
    public void start(Stage primaryStage) throws Exception {
        //get the instance for this application's host service
        wizPhyHostServices=getHostServices();
        //initializing the ScreensController object
        mainContainer = new ScreensController(SCREEN_WIDTH,SCREEN_HEIGHT-20);
        //loading the various GUIs that this ScreensController will manage
        mainContainer.loadScreen(WizPhy.TheCourseID, WizPhy.TheCourseFile);
        mainContainer.loadScreen(WizPhy.TheHomeworkID, WizPhy.TheHomeworkFile);
        mainContainer.loadScreen(WizPhy.TheLabID, WizPhy.TheLabFile);
        mainContainer.setScreen(WizPhy.TheCourseID); 
        //A group is used to assemble UI components together
        Group root = new Group();
        //adds the GUI to the group
        root.getChildren().addAll(mainContainer);
        //Creates a scene and add the root to the scene
        Scene scene = new Scene(root);
        //set title text for the application
        primaryStage.setTitle("WizPhy - Newtonian mechanics");
        //adds the icon of our software
        primaryStage.getIcons().add(new Image(WizPhy.class.getResource("img/app_icon.png").toString()));
        //adds the scene to the stage
        primaryStage.setScene(scene);
        //and finally displays the stage
        primaryStage.show();        
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
