package com.booking.flight;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.*;

public class detailsController implements Initializable {
    public TextField flight_no;
    public TextField flight_name;
    public TextField persons;
    public Label label;
    public Pane details_pane;
    List<String > l=new ArrayList<>();
    public TextField first_name;
    public TextField last_name;
    public TextField source;
    public TextField destination;
    public TextField arrr_time;
    public TextField depart_time;
    public ComboBox class_box;
    public TextField price;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<String > list=new ArrayList<>();
        list.add("Economic class");
        class_box.setItems(FXCollections.observableArrayList(list));

    }


    public void cancle(ActionEvent actionEvent) throws Exception{

        Pane back_flight=FXMLLoader.load(getClass().getResource("flight.fxml"));
        details_pane.getChildren().setAll(back_flight);

    }


    public void pay(ActionEvent actionEvent) throws Exception {
        String f_no=fc.getFNo();
        String f_name=fc.getFName();
        String f_source=fc.getFSource();
        String f_destination=fc.getFDepart();
        String f_arrTime= fc.getArrTime();
        String f_departTime=fc.getDepartTime();
        int  f_charger= Integer.parseInt(fc.getCharge());


        String FirstName=first_name.getText();
        String LastName=last_name.getText();
        int Person=Integer.parseInt(persons.getText());

        first_name.setText(FirstName.toUpperCase());
        last_name.setText(LastName.toUpperCase());

        int count=0;
        for (int i=0;i<Person;i++){
            count++;
        }

        String p= String.valueOf(f_charger*count);
        price.setText(p);

        String classes=class_box.getSelectionModel().getSelectedItem().toString();

        String Date= String.valueOf(new Date(System.currentTimeMillis()));
        label.setText(Date);


        Connection con=DB.getCon();
        String q="insert into tickets(first_name,last_name,source,destnation,arriving_time,depart_time,class,persons,flight_no,flight_name,date,price) values (?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement ps=con.prepareStatement(q);

        ps.setString(1,FirstName);
        ps.setString(2,LastName);
        ps.setString(3,f_source);
        ps.setString(4,f_destination);
        ps.setString(5,f_arrTime);
        ps.setString(6,f_departTime);
        ps.setString(7,classes);
        ps.setInt(8,Person);
        ps.setString(9,f_no);
        ps.setString(10,f_name);
        ps.setString(11,Date);
        ps.setString(12,p);

        ps.executeUpdate();


        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Booking Successfully...!");
        alert.setContentText("Have a safe journey");


        System.out.println("successful");

        FXMLLoader ticket=new FXMLLoader(getClass().getResource("ticket.fxml"));
        Pane root=ticket.load();

        ticketController tc=ticket.getController();
        tc.display(FirstName,f_no,Date,f_source,f_destination,f_departTime);

        Stage stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();


    }
    flights_class fc=new flights_class();

    public void display(String fNo, String fName, String fSource, String fDepart, String arrTime, String deptTime, String charge) {

            flight_no.setText(fNo);
            flight_name.setText(fName);
            source.setText(fSource);
            destination.setText(fDepart);
            arrr_time.setText(arrTime);
            depart_time.setText(deptTime);
            price.setText(charge);

            fc.setFNo(fNo);
            fc.setFName(fName);
            fc.setFSource(fSource);
            fc.setFDepart(fDepart);
            fc.setArrTime(arrTime);
            fc.setDepartTime(deptTime);
            fc.setCharge(charge);

    }
}
