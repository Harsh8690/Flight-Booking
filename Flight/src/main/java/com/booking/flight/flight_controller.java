package com.booking.flight;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class flight_controller implements Initializable {
    public ComboBox source;
    public ComboBox destination;
    public Button search;
    public TableView<flights_class> tableview;
    public TableColumn <flights_class,String> fNo;
    public TableColumn <flights_class,String> fName;
    public TableColumn <flights_class,String> fSource;
    public TableColumn <flights_class,String> fDepart;
    public TableColumn <flights_class,String> deptTime;
    public TableColumn <flights_class,String> arrTime;
    public TableColumn <flights_class,String> charge;
    public Pane flights_pane;
    ObservableList<flights_class> row;
    flights_class fc = new flights_class();
    private javafx.event.ActionEvent ActionEvent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> list=new ArrayList<>();
        list.add("Delhi");
        list.add("Mumbai");
        list.add("Chennai");
        list.add("Jodhpur");
        list.add("Jaipur");
        list.add("Bengaluru");
        list.add("Assam");
        list.add("Chandigarh");
        list.add("Amritsar");
        source.setItems(FXCollections.observableArrayList(list));
        destination.setItems(FXCollections.observableArrayList(list));
    }

    public void search(ActionEvent actionEvent) {

        String s=source.getSelectionModel().getSelectedItem().toString();
        String d=destination.getSelectionModel().getSelectedItem().toString();

        try {
            row = FXCollections.observableArrayList();
            Connection con = DB.getCon();
            String q = "select * from flight where source ='" + s + "' and destination = '" + d + "'";
            //   System.out.println(q);
            // PreparedStatement ps=con.prepareStatement(q);
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery(q);

            //   ResultSetMetaData rm= rs.getMetaData();

            while (rs.next()) {

//                flights_class fc = new flights_class();
                fc.setFNo(rs.getString(1));
                fc.setFName(rs.getString(2));
                fc.setFSource(rs.getString(3));
                fc.setFDepart(rs.getString(4));
                fc.setDepartTime(rs.getString(5));
                fc.setArrTime(rs.getString(6));
                fc.setCharge(rs.getString(7));

                row.add(fc);


            }
            fNo.setCellValueFactory(new PropertyValueFactory<>("FNo"));
            fName.setCellValueFactory(new PropertyValueFactory<>("FName"));
            fSource.setCellValueFactory(new PropertyValueFactory<>("FSource"));
            fDepart.setCellValueFactory(new PropertyValueFactory<>("FDepart"));
            deptTime.setCellValueFactory(new PropertyValueFactory<>("DepartTime"));
            arrTime.setCellValueFactory(new PropertyValueFactory<>("ArrTime"));
            charge.setCellValueFactory(new PropertyValueFactory<>("charge"));

            tableview.setItems(row);


        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void next(ActionEvent actionEvent) throws IOException {
            ActionEvent actionEvent1=new ActionEvent();
        String FNo=fc.getFNo();
        String FName=fc.getFName();
        String FSource=fc.getFSource();
        String FDepart= fc.getFDepart();
        String DeptTime=fc.getDepartTime();
        String ArrTime=fc.getArrTime();
        String Charge=fc.getCharge();


        FXMLLoader details=new FXMLLoader(getClass().getResource("details.fxml"));
        Pane root=details.load();

        detailsController detailsController=details.getController();
        detailsController.display(FNo,FName,FSource,FDepart,ArrTime,DeptTime,Charge);
        Stage stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
}
