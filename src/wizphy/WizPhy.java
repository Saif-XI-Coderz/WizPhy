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
 */
public class WizPhy extends Application {
    public static String TheCourseID = "main";
    public static String TheCourseFile = "gui/TheCourse.fxml";
    public static String TheHomeworkID = "thehomework";
    public static String TheHomeworkFile = "gui/TheHomeWork.fxml";
    public static String TheLabID = "thelab";
    public static String TheLabFile = "gui/TheLabs.fxml";
    private static final double SCREEN_WIDTH=Screen.getPrimary().getVisualBounds().getWidth();
    private static final double SCREEN_HEIGHT=Screen.getPrimary().getVisualBounds().getHeight();
    static ScreensController mainContainer;
    static ScreensController subContainerCourse;
    public static HostServices wizPhyHostServices;
    @Override
    public void start(Stage primaryStage) throws Exception {
        wizPhyHostServices=getHostServices();
        //Parent root = FXMLLoader.load(getClass().getResource("WizPhyGUI.fxml"));
        mainContainer = new ScreensController(SCREEN_WIDTH,SCREEN_HEIGHT-20);
        mainContainer.loadScreen(WizPhy.TheCourseID, WizPhy.TheCourseFile);
        mainContainer.loadScreen(WizPhy.TheHomeworkID, WizPhy.TheHomeworkFile);
        mainContainer.loadScreen(WizPhy.TheLabID, WizPhy.TheLabFile);
        mainContainer.setScreen(WizPhy.TheCourseID); 
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setTitle("WizPhy - Newtonian mechanics");
        primaryStage.getIcons().add(new Image(WizPhy.class.getResource("img/app_icon.png").toString()));
        primaryStage.setScene(scene);
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
