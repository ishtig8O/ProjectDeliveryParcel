package com.example.project2.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.example.project2.Context;
import com.example.project2.HelloApplication;
import com.example.project2.Model.TableCreateModel;
import com.example.project2.Model.TableTakeModel;
import com.example.project2.Table.TableCreateWho;
import com.example.project2.Table.TableTakeWho;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TableCreateOrderController {

@FXML
private ResourceBundle resources;

@FXML
private URL location;

@FXML
private Button buttonBack;

@FXML
private Button buttonBack1;

    @FXML
    private TableColumn<TableCreateWho, String> center_address;

    @FXML
    private TableColumn<TableCreateWho, String> client_address;

    @FXML
    private TableColumn<TableCreateWho, Integer> delivery_id;

    @FXML
    private TableColumn<TableCreateWho, Integer> package_id;

@FXML
private TableView<TableCreateWho> tableCreate;

@FXML
private Button take;

@FXML
private TableColumn<TableCreateWho, Integer> type_id;

@FXML
private TableColumn<TableCreateWho, Integer> unique_code;

@FXML
private TableColumn<TableCreateWho, Integer> weight;

    @FXML
    private TextField id;

    @FXML
    private TextField type;
    @FXML
    private TextField weight0;
@FXML
private Label welcomeText;

    private Stage stage;
    private Scene scene;


    private TableCreateModel tableCreateModel;

    public TableCreateOrderController() {
        this.tableCreateModel = new TableCreateModel(this);
    }

//    ObservableList<TableStaffModel> list = FXCollections.observableArrayList(
//            new TableStaffModel(1, "fff1", "1234435"),
//            new TableStaffModel(2, "fff2", "1234436"),
//            new TableStaffModel(3, "fff3", "1234437")
//
//
//    );

    ObservableList<TableCreateWho> listM;
    int index = -1;
    Connection connection = null;
    ResultSet rs = null;



//    public void add_staff() {
////        String name = center_name.toString();
////        String address = center_address.toString();
//        //if (name.isEmpty() || phone.isEmpty() || )
//        //tableTakeModel.add_staffi(nameText.getText(), TextAddress.getText(),);
//    }

    @FXML
    void getUp(javafx.scene.input.MouseEvent mouseEvent) {
        index = tableCreate.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }


        id.setText(package_id.getCellData(index).toString());
//        nameText.setText(center_name.getCellData(index).toString());
//        TextAddress.setText(center_address.getCellData(index).toString());

    }



    public void updateTable() {
        center_address.setCellValueFactory(new PropertyValueFactory<TableCreateWho, String>("centerAddress"));
        client_address.setCellValueFactory(new PropertyValueFactory<TableCreateWho, String>("clientAddress"));
        delivery_id.setCellValueFactory(new PropertyValueFactory<TableCreateWho, Integer>("deliveryId"));
        package_id.setCellValueFactory(new PropertyValueFactory<TableCreateWho, Integer>("packageId"));
        type_id.setCellValueFactory(new PropertyValueFactory<TableCreateWho, Integer>("typeId"));
        weight.setCellValueFactory(new PropertyValueFactory<TableCreateWho, Integer>("weight"));
        unique_code.setCellValueFactory(new PropertyValueFactory<TableCreateWho, Integer>("uniqueCode"));

        listM = tableCreateModel.getDate();


        tableCreate.setItems(listM);
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

    public void switchToTakeMenu(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource(Context.getInstance().getMainPage()));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void create() {
        tableCreateModel.create(id, type, weight0);
    }

//@FXML
//    void add_staff(ActionEvent event) {
//
//            }
//
//@FXML
//    void getUp(MouseEvent event) {
//
//            }
//
//@FXML
//    void switchToRegistrationBack(ActionEvent event) {
//
//            }

//@FXML
//    void initialize() {
//            assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'baseCreateOrder.fxml'.";
//            assert buttonBack1 != null : "fx:id=\"buttonBack1\" was not injected: check your FXML file 'baseCreateOrder.fxml'.";
//            assert center_address != null : "fx:id=\"center_address\" was not injected: check your FXML file 'baseCreateOrder.fxml'.";
//            assert client_address != null : "fx:id=\"client_address\" was not injected: check your FXML file 'baseCreateOrder.fxml'.";
//            assert delivery_id != null : "fx:id=\"delivery_id\" was not injected: check your FXML file 'baseCreateOrder.fxml'.";
//            assert package_id != null : "fx:id=\"package_id\" was not injected: check your FXML file 'baseCreateOrder.fxml'.";
//            assert tableCreate != null : "fx:id=\"tableCreate\" was not injected: check your FXML file 'baseCreateOrder.fxml'.";
//            assert take != null : "fx:id=\"take\" was not injected: check your FXML file 'baseCreateOrder.fxml'.";
//            assert type_id != null : "fx:id=\"type_id\" was not injected: check your FXML file 'baseCreateOrder.fxml'.";
//            assert unique_code != null : "fx:id=\"unique_code\" was not injected: check your FXML file 'baseCreateOrder.fxml'.";
//            assert weight != null : "fx:id=\"weight\" was not injected: check your FXML file 'baseCreateOrder.fxml'.";
//            assert welcomeText != null : "fx:id=\"welcomeText\" was not injected: check your FXML file 'baseCreateOrder.fxml'.";
//
//            }


            }
