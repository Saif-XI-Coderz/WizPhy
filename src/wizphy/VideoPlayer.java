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
 */
public class VideoPlayer {
    Stage videoStage;
    MediaPlayer media_player;
    String video_file;    
    Button btn_play_pause;
    Button btn_stop;
    Slider timeSlider;
    public VideoPlayer(String video){
        video_file=video;
        Media media=new Media(video_file);
        media_player=new MediaPlayer(media);
        MediaView view = new MediaView(media_player);
        media_player.setOnReady(new Runnable(){
            @Override
            public void run() {
               videoStage.setWidth(media.getWidth());
               videoStage.setMinHeight(media.getHeight());
            }
        });        
        HBox vbox = new HBox();
        btn_play_pause=new Button("Play");
        btn_stop=new Button("Stop");
        btn_play_pause.setOnMouseClicked((MouseEvent t) -> {
            if(media_player.getStatus()==MediaPlayer.Status.PLAYING){
                btn_play_pause.setText("Play");
                media_player.pause();
            }else{
                btn_play_pause.setText("Pause");
                media_player.play();
            }
        });
        btn_stop.setOnMouseClicked((MouseEvent t)->{
            media_player.stop();
        });
        vbox.getChildren().addAll(btn_play_pause,btn_stop);
        Group group = new Group();
        group.getChildren().addAll(view,vbox);
        Scene scene=new Scene(group);
        videoStage=new Stage();
        videoStage.setScene(scene);
    }
    
    public void setVideo(String video) {
        video_file=video;
    }

    public void show() {
        videoStage.show();
    }
}
