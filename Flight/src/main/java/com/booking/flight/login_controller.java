package com.booking.flight;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotResult;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class login_controller implements Initializable {
    public TextField login_user;
    public PasswordField login_password;
    public Label liable;
    public Pane login_pane;

    @java.lang.Override
    public void initialize(java.net.URL url, java.util.ResourceBundle resourceBundle) {

    }

    public void login(ActionEvent actionEvent) {
        try {
            Connection con=DB.getCon();
            String q="select * from signup";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(q);
            while (rs.next()){
                String username=rs.getNString(2);
                String  password=rs.getNString(3);
                if (username.equals(login_user.getText()) && password.equals(login_password.getText())){
                        try {
                            Pane flight=FXMLLoader.load(getClass().getResource("flight.fxml"));
                            login_pane.getChildren().setAll(flight);

                        }catch (Exception e){
                            e.printStackTrace();
                        }
                }
                else {
                    liable.setText("please enter valid username and password");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void signup(ActionEvent actionEvent) {
        try {
            Pane signup= FXMLLoader.load(getClass().getResource("signup.fxml"));
            login_pane.getChildren().setAll(signup);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
