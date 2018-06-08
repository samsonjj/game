import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import render.GameFrame;
import state.CurrentText;

import javax.swing.*;
import java.io.File;

public class Main extends Application {

    static final String gettysburg[] = ("Fourscore and seven years ago our fathers brought forth on this continent, a new nation, conceived in Liberty, and dedicated to the proposition that all men are created equal."+
            ""+
            "[2] Now we are engaged in a great civil war, testing whether that nation, or any nation so conceived and so dedicated, can long endure. We are met on a great battle-field of that war. We have come to dedicate a portion of that field, as a final resting place for those who here gave their lives that that nation might live. It is altogether fitting and proper that we should do this."+
            ""+
            "[3] But, in a larger sense, we can not dedicate-we can not consecrate-we can not hallow-this ground. The brave men, living and dead, who struggled here, have consecrated it, far above our poor power to add or detract. The world will little note, nor long remember what we say here, but it can never forget what they did here. It is for us the living, rather, to be dedicated here to the unfinished work which they who fought here have thus far so nobly advanced. It is rather for us to be here dedicated to the great task remaining before us-that from these honored dead we take increased devotion to that cause for which they gave the last full measure of devotion-that we here highly resolve that these dead shall not have died in vain-that this nation, under God, shall have a new birth of freedom-and that government of the people, by the people, for the people shall not perish from the earth.").split("\\.");
    static int index = 0;

    public static void main(String[] args) {

        Media hit = new Media(new File("spooky.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.setVolume(.1);
        mediaPlayer.play();

        GameFrame frame = new GameFrame();

        while(true) {
            try {
                Thread.sleep(1000);
                frame.repaint();
                CurrentText.text = gettysburg[index];
                index = (index+1) % gettysburg.length;
            } catch(Exception e) { }
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
