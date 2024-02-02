package com.booking.flight;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ticketController implements Initializable {
    public Label passenger;
    public Label flight;
    public Label date;
    public Label source;
    public Label destination;
    public Label time;
    public Pane ticket_pane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    void display(String FirstName, String f_no, String Date, String f_source, String f_destination, String f_departTime){

        passenger.setText(FirstName.toUpperCase());
        flight.setText(f_no.toUpperCase());
        date.setText(Date.toUpperCase());
        source.setText(f_source.toUpperCase());
        destination.setText(f_destination.toUpperCase());
        time.setText(f_departTime.toUpperCase());

    }


    public void home(ActionEvent actionEvent) throws  Exception{

        Pane back_flight= FXMLLoader.load(getClass().getResource("flight.fxml"));
        ticket_pane.getChildren().setAll(back_flight);

    }
}
