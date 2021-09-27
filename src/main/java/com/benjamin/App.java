package com.benjamin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {
    public static Stage stage;
    public static Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    public static void changeFxml(String fxml) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(App.class.getResource("/com/benjamin/gui/fxml/" + fxml )));
        scene.setRoot(root);
        stage.hide();
        stage.show();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/benjamin/gui/fxml/menu.fxml")));
        scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
