package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;

import java.io.File;

public class MainViewController {

    @FXML
    private Button btnBrowseAudio;

    @FXML
    private Button btnBrowseVideo;

    @FXML
    private Button btnPalyVideo;

    @FXML
    private Button btnPlayAudio;

    @FXML
    private Button btnStopAudio;

    @FXML
    private Button btnStopVideo;

    @FXML
    private MediaView mv;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtAudioPath;

    @FXML
    private TextField txtVideoPath;
    MediaPlayer audioPlayer;
    MediaPlayer videoPalyer;

    @FXML
    void btnBroseAudiOnAction(ActionEvent event) {
        FileChooser fileChooser=new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Mp3","*.mp3"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Wave files","*.wav"));
        File audioFile = fileChooser.showOpenDialog(root.getScene().getWindow());
        System.out.println(audioFile);
        if(audioFile!= null){
            txtAudioPath.setText(audioFile.getAbsolutePath());
            Media media = new Media(audioFile.toURI().toString());
            if(videoPalyer==null){
                String path ="/home/dilanka/Documents/dep-11/phase-1/Javafx/javafx-mediaPlayer/src/main/resources/video/1061097142-preview.mp4";
                Media mediaVideo =new Media(new File(path).toURI().toString());
                videoPalyer=new MediaPlayer(mediaVideo);
                mv.setMediaPlayer(videoPalyer);

            }


            audioPlayer = new MediaPlayer(media);

        }else {
            txtAudioPath.clear();
        }

    }

    @FXML
    void btnBrowseVideoOnAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Video Files","*.mp4","*.avi","*.mkv"));

        File videoFile =fileChooser.showOpenDialog(root.getScene().getWindow());
        if(videoFile!= null){
            txtVideoPath.setText(videoFile.getAbsolutePath());
            Media media =new Media(videoFile.toURI().toString());

            videoPalyer = new MediaPlayer(media);

        }else {
            txtVideoPath.clear();
        }

    }

    @FXML
    void btnPlayAudioonAction(ActionEvent event) {
        if(audioPlayer!=null){
            mv.setMediaPlayer(videoPalyer);
            audioPlayer.play();
            videoPalyer.play();
        }

    }

    @FXML
    void btnPlayVideoOnAction(ActionEvent event) {
        if(videoPalyer != null){
            mv.setMediaPlayer(videoPalyer);
            videoPalyer.play();
        }

    }

    @FXML
    void btnStopAudioOnAction(ActionEvent event) {
        if(audioPlayer!=null){
            audioPlayer.stop();
            videoPalyer.stop();
        }

    }

    @FXML
    void btnStopVideoOnAction(ActionEvent event) {

    }

}
