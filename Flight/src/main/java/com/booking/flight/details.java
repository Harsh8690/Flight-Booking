package com.booking.flight;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class details extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("details.fxml"));
        Pane root=fxmlLoader.load();
        Scene scene=new Scene(root);
        Stage primaryStage=new Stage();
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
