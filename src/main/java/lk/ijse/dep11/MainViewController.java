package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MainViewController {

    public Button btnClose;
    public Button btnMaximise;
    public Button btnMinimise;
    public Button btnBrowse;
    public ImageView iv;
    public ImageView iv2;


    @FXML
    private Button btnPlay;

    @FXML
    private Button btnStop;



    @FXML
    private MediaView mv;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtPath;


    MediaPlayer audioPlayer;
    MediaPlayer videoPalyer;
    public  double x=0;
    public  double y=0;

    public  void initialize(){
        String path ="/home/dilanka/Documents/dep-11/phase-1/Javafx/javafx-mediaPlayer/src/main/resources/images/pngegg.png";
        Image image=new Image(new File(path).toURI().toString());
        iv2.setImage(image);
    }

    @FXML
    void btnBrowseOnAction(ActionEvent event) {
        FileChooser fileChooser=new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Mp3","*.mp3"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Wave files","*.wav"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Video Files","*.mp4","*.avi","*.mkv"));
        File file = fileChooser.showOpenDialog(root.getScene().getWindow());
        System.out.println(file);
        if(file!= null){
            iv2.setImage(null);
            txtPath.setText(file.getAbsolutePath());
            Media media = new Media(file.toURI().toString());
            if(file.toString().substring(file.toString().length()-3).equals("mp4")){
                Media videomedia =new Media(file.toURI().toString());

                videoPalyer = new MediaPlayer(videomedia);
                mv.setMediaPlayer(videoPalyer);
            }else {
                String path ="/home/dilanka/Documents/dep-11/phase-1/Javafx/javafx-mediaPlayer/src/main/resources/video/1061097142-preview.mp4";
                Media mediaVideo =new Media(new File(path).toURI().toString());
                videoPalyer=new MediaPlayer(mediaVideo);
                mv.setMediaPlayer(videoPalyer);

            }
            audioPlayer = new MediaPlayer(media);

        }else {
            txtPath.clear();
        }

    }
    @FXML
    void btnPlayOnAction(ActionEvent event) {
        if(audioPlayer!=null){
            mv.setMediaPlayer(videoPalyer);
            audioPlayer.play();
            videoPalyer.play();
        }

    }
    @FXML
    void btnStopOnAction(ActionEvent event) {
        if(audioPlayer!=null){
            audioPlayer.pause();
            videoPalyer.pause();
        }

    }
    public void rootOnMousePressed(MouseEvent mouseEvent) {
            x=mouseEvent.getSceneX();
            y=mouseEvent.getSceneY();
    }

    public void rootOnMouseDragged(MouseEvent mouseEvent) {
        Stage stage =(Stage) root.getScene().getWindow();
        stage.setX(mouseEvent.getScreenX()-x);
        stage.setY(mouseEvent.getScreenY()-y);
    }

    public void btnCloseOnAtion(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void btnMaximiseOnAction(ActionEvent actionEvent) {
        Stage stage =(Stage) root.getScene().getWindow();
        if(stage.isMaximized()){
            stage.setMaximized(false);
        }else stage.setMaximized(true);
    }

    public void btnMinimiseOnAction(ActionEvent actionEvent) {
        Stage stage =(Stage) root.getScene().getWindow();
        stage.setIconified(true);
    }
}
