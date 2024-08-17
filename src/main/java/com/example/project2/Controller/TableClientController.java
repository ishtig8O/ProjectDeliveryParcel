package com.example.project2.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.example.project2.HelloApplication;
import com.example.project2.Model.TableClientModel;
import com.example.project2.Table.TableClientWho;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TableClientController {

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
    private TableColumn<TableClientWho, String> client_address;

    @FXML
    private TableColumn<TableClientWho, Integer> client_id;

    @FXML
    private TableColumn<TableClientWho, String> client_name;

    @FXML
    private TableColumn<TableClientWho, String> client_phone_number;

    @FXML
    private Button delite;

    @FXML
    private TableColumn<TableClientWho, Integer> delivery_point_id;

    @FXML
    private TextField idText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField phoneText;

    @FXML
    private TableView<TableClientWho> tableStaff;

    @FXML
    private Button update;

    @FXML
    private Label welcomeText;

    @FXML
    private TextField TextAddress;

    @FXML
    private TextField TextDelivery;

//    @FXML
//    void add_staff(ActionEvent event) {
//
//    }





//    @FXML
//    void update(ActionEvent event) {
//
//    }





    private Stage stage;
    private Scene scene;


    private TableClientModel tableClientModel;

    public TableClientController() {
        this.tableClientModel = new TableClientModel(this);
    }

//    ObservableList<TableStaffModel> list = FXCollections.observableArrayList(
//            new TableStaffModel(1, "fff1", "1234435"),
//            new TableStaffModel(2, "fff2", "1234436"),
//            new TableStaffModel(3, "fff3", "1234437")
//
//
//    );

    ObservableList<TableClientWho> listM;
    int index = -1;
    Connection connection = null;
    ResultSet rs = null;



    public void add_staff() {
//        String name = client_name.toString();
//        String phone = client_phone_number.toString();
//        String address = client_address.toString();
//        Integer delivery = Integer.valueOf(delivery_point_id.toString());
        //if (name.isEmpty() || phone.isEmpty() || )
        tableClientModel.add_staffi(idText.getText(), nameText.getText(), phoneText.getText(), TextAddress.getText());
    }

    @FXML
    void getUp(javafx.scene.input.MouseEvent mouseEvent) {
        index = tableStaff.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }


        //idText.setText(client_id.getCellData(index).toString());
        nameText.setText(client_name.getCellData(index).toString());
        phoneText.setText(client_phone_number.getCellData(index).toString());
        TextAddress.setText(client_address.getCellData(index).toString());
        //TextDelivery.setText(delivery_point_id.getCellData(index).toString());
    }



    public void updateTable() {
        //
        client_id.setCellValueFactory(new PropertyValueFactory<TableClientWho, Integer>("id"));
        client_name.setCellValueFactory(new PropertyValueFactory<TableClientWho, String>("name"));
        client_phone_number.setCellValueFactory(new PropertyValueFactory<TableClientWho, String>("phone"));
        client_address.setCellValueFactory(new PropertyValueFactory<TableClientWho, String>("address"));
        delivery_point_id.setCellValueFactory(new PropertyValueFactory<TableClientWho, Integer>("delivery"));

        listM = tableClientModel.getDate();


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
    void update() {
        tableClientModel.edit(idText, nameText, phoneText, TextAddress, TextDelivery);
    }



}
