package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource(
                "sample.fxml"));
        Scene scene = new Scene(parent, 1200, 700);
        stage.setScene(scene);
        stage.setTitle("Bank");
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}