/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wizphy;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 *
 * @author Sherlock
 * This is our implementation of a video player
 * with basic video players UI components and
 * functionality
 */
public class VideoPlayer {
    //The stage to show the VideoPlayer in
    Stage videoStage;
    //Declaring the UI components of the VideoPlayes
    MediaPlayer media_player;
    String video_file;    
    Button btn_play_pause;
    Button btn_stop;
    Slider timeSlider;
    
   /**
   * Constructor initializing the video to be played,
   * the UI components and EvenHandlers
   **/
    public VideoPlayer(String video){
        video_file=video;
        //A media resource, containing information about the media, such as its source, resolution, and metadata
        Media media=new Media(video_file);
        //The key component providing the controls for playing media
        media_player=new MediaPlayer(media);
        //A Node object to support animation, translucency, and effects
        //This is the actual UI component appearing on the screen
        MediaView view = new MediaView(media_player);
        //Action triggered once the media player is ready
        //i.e. ready is a state signifying that the media player is ready to its video
        media_player.setOnReady(new Runnable(){
            @Override
            public void run() {
               //setting the size of the the windows according to the 
               //dimension of the the media (video)
               videoStage.setWidth(media.getWidth());
               videoStage.setMinHeight(media.getHeight());
            }
        });       
        //Horizontal box groups children components in a horizontal fashion
        HBox vbox = new HBox();
        //Button responsible for playing/pausing video
        btn_play_pause=new Button("Play");
        //Button responsible for stopping video
        btn_stop=new Button("Stop");
        //Executed when the play/pause button is clicked
        btn_play_pause.setOnMouseClicked((MouseEvent t) -> {
            //Check if video is playing
            if(media_player.getStatus()==MediaPlayer.Status.PLAYING){
                //pause video if video is playing
                btn_play_pause.setText("Play");
                media_player.pause();
            }else{
                //play video if video is not playing
                btn_play_pause.setText("Pause");
                media_player.play();
            }
        });
        //Executed when stop button is clicked
        btn_stop.setOnMouseClicked((MouseEvent t)->{
            //stop the video
            media_player.stop();
        });
        //Vertical box groups children components in vertical fashion
        vbox.getChildren().addAll(btn_play_pause,btn_stop);
        Group group = new Group();
        //Add the controls and media view in group
        group.getChildren().addAll(view,vbox);
        //adds the group to the scene
        Scene scene=new Scene(group);
        //creates the stage and add the scene to it
        videoStage=new Stage();
        videoStage.setScene(scene);
    }
    
    public void setVideo(String video) {
        //set the video file
        video_file=video;
    }

    public void show() {
        //show the VideoPlayer
        videoStage.show();
    }
}
