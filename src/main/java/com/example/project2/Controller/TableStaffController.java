//package com.example.demo4;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.Objects;
//import java.util.ResourceBundle;
//
//import javafx.beans.Observable;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.stage.Stage;
//
//public class TableStaffController {
//
//    @FXML
//    private Button buttonBack;
//
//    @FXML
//    private Button buttonBack1;
//
//    @FXML
//    private TableColumn<TableStaffModel, Integer> courier_id;
//
//    @FXML
//    private TableColumn<TableStaffModel, String> courier_name;
//
//    @FXML
//    private TableColumn<TableStaffModel, String> courier_phone_number;
//
//    @FXML
//    private TableView<TableStaffModel> tableStaff;
//
//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    private Button add;

package com.example.project2.Controller;

import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.example.project2.Context;
import com.example.project2.HelloApplication;
import com.example.project2.Model.TableStaffModel;
import com.example.project2.Table.TableStaffWho;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

public class TableStaffController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonBack1;

    @FXML
    private TableColumn<TableStaffWho, Integer> courier_id;

    @FXML
    private TableColumn<TableStaffWho, String> courier_name;

    @FXML
    private TableColumn<TableStaffWho, String> courier_phone_number;

    @FXML
    private TableView<TableStaffWho> tableStaff;

    @FXML
    private Button delite;

    @FXML
    private Button update;

    @FXML
    private Label welcomeText;

    @FXML
    private TextField idText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField phoneText;




    private Stage stage;
    private Scene scene;


    private TableStaffModel tableStaffModel;

    public TableStaffController() {
        this.tableStaffModel = new TableStaffModel(this);
    }

//    ObservableList<TableStaffModel> list = FXCollections.observableArrayList(
//            new TableStaffModel(1, "fff1", "1234435"),
//            new TableStaffModel(2, "fff2", "1234436"),
//            new TableStaffModel(3, "fff3", "1234437")
//
//
//    );

        ObservableList<TableStaffWho> listM;
        int index = -1;
        Connection connection = null;
        ResultSet rs = null;



    public void add_staff() {
        String name = courier_name.toString();
        String phone = courier_phone_number.toString();
        //if (name.isEmpty() || phone.isEmpty() || )
        tableStaffModel.add_staffi(idText.getText(), nameText.getText(), phoneText.getText());
    }

    @FXML
    void getUp(javafx.scene.input.MouseEvent mouseEvent) {
        index = tableStaff.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }


        idText.setText(courier_id.getCellData(index).toString());
        nameText.setText(courier_name.getCellData(index).toString());
        phoneText.setText(courier_phone_number.getCellData(index).toString());

    }



    public void updateTable() {
        courier_id.setCellValueFactory(new PropertyValueFactory<TableStaffWho, Integer>("id_staff"));
        courier_name.setCellValueFactory(new PropertyValueFactory<TableStaffWho, String>("name"));
        courier_phone_number.setCellValueFactory(new PropertyValueFactory<TableStaffWho, String>("phone"));

        listM = tableStaffModel.getDate();


        tableStaff.setItems(listM);
    }

    @FXML
    void initialize() {
//        courier_id.setCellValueFactory(new PropertyValueFactory<TableStaffWho, Integer>("id_staff"));
//        courier_name.setCellValueFactory(new PropertyValueFactory<TableStaffWho, String>("name"));
//        courier_phone_number.setCellValueFactory(new PropertyValueFactory<TableStaffWho, String>("phone"));
//
//        listM = tableStaffModel.getDate();
//
//
//        tableStaff.setItems(listM);
        updateTable();
    }
    @FXML
    public void switchToRegistrationBack(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToMenu(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource(Context.getInstance().getMainPage()));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void update() {
        tableStaffModel.edit(idText, nameText, phoneText);
    }



//    @FXML
//    void initialize() {
////        courier_id.setCellValueFactory(new PropertyValueFactory<TableStaffModel, Integer>("id"));
////        courier_name.setCellValueFactory(new PropertyValueFactory<TableStaffModel, String>("name"));
////        courier_phone_number.setCellValueFactory(new PropertyValueFactory<TableStaffModel, String>("phone"));
////
////        tableStaff.setItems(list);
//
//    }


}
