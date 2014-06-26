/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wizphy.controller;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;
import wizphy.ControlledScreen;
import wizphy.ScreensController;

/**
 * FXML Controller class
 *
 * @author Sherlock
 */
public class TheCourseWebViewController implements Initializable, ControlledScreen  {
    ScreensController myController;
    public static String html_page;
    @FXML 
    static WebView web_view;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("initializing webview controller");  
    }    

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
}
