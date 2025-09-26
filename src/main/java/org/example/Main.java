package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


 public class Main extends Application {
    public static void main(String[] args) {
      Application.launch(Main.class, args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Text Processing Tool");
        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.add();
        stage.setScene(new Scene(gridPane));


    }
}