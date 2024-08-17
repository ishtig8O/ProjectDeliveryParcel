package com.example.project2.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.example.project2.HelloApplication;
import com.example.project2.Table.TableDeliveryModel;
import com.example.project2.Table.TableDeliveryWho;
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

    public class TableDeliveryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField TextAddress;

    @FXML
    private Button add;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonBack1;

    @FXML
    private TableColumn<TableDeliveryWho, String> center_address;

    @FXML
    private TableColumn<TableDeliveryWho, Integer> center_id;

    @FXML
    private TableColumn<TableDeliveryWho, String> center_name;

    @FXML
    private Button delite;

    @FXML
    private TextField idText;

    @FXML
    private TextField nameText;

    @FXML
    private TableView<TableDeliveryWho> tableDelivery;

    @FXML
    private Button update;

    @FXML
    private Label welcomeText;

//    @FXML
//    void add_staff(ActionEvent event) {
//
//    }
//
//    @FXML
//    void getUp(MouseEvent event) {
//
//    }
//
//    @FXML
//    void switchToRegistrationBack(ActionEvent event) {
//
//    }
//
//    @FXML
//    void update(ActionEvent event) {
//
//    }
//
//    @FXML
//    void initialize() {
//
//
//    }


    private Stage stage;
    private Scene scene;


    private TableDeliveryModel tableDeliveryModel;

    public TableDeliveryController() {
        this.tableDeliveryModel = new TableDeliveryModel(this);
    }

//    ObservableList<TableStaffModel> list = FXCollections.observableArrayList(
//            new TableStaffModel(1, "fff1", "1234435"),
//            new TableStaffModel(2, "fff2", "1234436"),
//            new TableStaffModel(3, "fff3", "1234437")
//
//
//    );

    ObservableList<TableDeliveryWho> listM;
    int index = -1;
    Connection connection = null;
    ResultSet rs = null;



    public void add_staff() {
        String name = center_name.toString();
        String address = center_address.toString();
        //if (name.isEmpty() || phone.isEmpty() || )
        tableDeliveryModel.add_staffi(nameText.getText(), TextAddress.getText());
    }

    @FXML
    void getUp(javafx.scene.input.MouseEvent mouseEvent) {
        index = tableDelivery.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }



        nameText.setText(center_name.getCellData(index).toString());
        TextAddress.setText(center_address.getCellData(index).toString());

    }



    public void updateTable() {
        center_id.setCellValueFactory(new PropertyValueFactory<TableDeliveryWho, Integer>("id"));
        center_name.setCellValueFactory(new PropertyValueFactory<TableDeliveryWho, String>("name"));
        center_address.setCellValueFactory(new PropertyValueFactory<TableDeliveryWho, String>("address"));

        listM = tableDeliveryModel.getDate();


        tableDelivery.setItems(listM);
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
        tableDeliveryModel.edit(idText, nameText, TextAddress);
    }


}
