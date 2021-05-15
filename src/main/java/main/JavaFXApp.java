package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class JavaFXApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/MainMenu.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();

//        Group root = new Group();
//        Scene scene = new Scene(root, 640, 640, Color.color(126.0/255,160.0/255,58.0/255));
//        stage.setTitle("Topos");
//        stage.setScene(scene);
//        stage.show();
    }
}
