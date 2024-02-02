package com.booking.flight;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.InterruptedIOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class signup_controller implements Initializable {
    public TextField name;
    public TextField username;
    public TextField password;
    public TextField mobile;
    public Pane signup_pane;
    public Label label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void go_login(ActionEvent actionEvent) {
        try {
            Pane login= FXMLLoader.load(getClass().getResource("login.fxml"));
            signup_pane.getChildren().setAll(login);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void signin(ActionEvent actionEvent) {

        try {
            Connection con=DB.getCon();
            String q="insert into signup values(?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1,name.getText());
            ps.setString(2,username.getText());
            ps.setString(3,password.getText());
            ps.setString(4,mobile.getText());
            ps.executeUpdate();
            label.setText("sign-in successfully...");

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
