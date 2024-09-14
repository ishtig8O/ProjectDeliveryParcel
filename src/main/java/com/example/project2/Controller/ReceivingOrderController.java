package com.example.project2.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.example.project2.Context;
import com.example.project2.HelloApplication;
import com.example.project2.Model.ReceivingOrderModel;
import com.example.project2.Model.TableCreateModel;
import com.example.project2.Table.TableCreateWho;
import com.example.project2.Table.TableReceivingWho;
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

public class ReceivingOrderController {

@FXML
private ResourceBundle resources;

@FXML
private URL location;

@FXML
private Button buttonBack;

@FXML
private Button buttonBack1;

@FXML
private TableColumn<TableReceivingWho, Integer> delivery_id;

@FXML
private TextField id;

@FXML
private TableView<TableReceivingWho> tableCreate;

@FXML
private TableColumn<TableReceivingWho, Integer> type_id;

@FXML
private TableColumn<TableReceivingWho, String> unique_code;

@FXML
private TableColumn<TableReceivingWho, Integer> weight;

@FXML
private Label welcomeText;

@FXML
private Button find;




    private Stage stage;
    private Scene scene;


    private ReceivingOrderModel receivingOrderModel;

    public ReceivingOrderController() {
        this.receivingOrderModel = new ReceivingOrderModel(this);
    }

//    ObservableList<TableStaffModel> list = FXCollections.observableArrayList(
//            new TableStaffModel(1, "fff1", "1234435"),
//            new TableStaffModel(2, "fff2", "1234436"),
//            new TableStaffModel(3, "fff3", "1234437")
//
//
//    );

    ObservableList<TableReceivingWho> listM;
    int index = -1;
    Connection connection = null;
    ResultSet rs = null;



//    public void add_staff() {
////        String name = center_name.toString();
////        String address = center_address.toString();
//        //if (name.isEmpty() || phone.isEmpty() || )
//        //tableTakeModel.add_staffi(nameText.getText(), TextAddress.getText(),);
//    }

//    @FXML
//    void getUp(javafx.scene.input.MouseEvent mouseEvent) {
//        index = tableCreate.getSelectionModel().getSelectedIndex();
//        if (index <= -1) {
//            return;
//        }
//
//
//        id.setText(package_id.getCellData(index).toString());
////        nameText.setText(center_name.getCellData(index).toString());
////        TextAddress.setText(center_address.getCellData(index).toString());
//
//    }



    public void updateTable() {
        delivery_id.setCellValueFactory(new PropertyValueFactory<TableReceivingWho, Integer>("deliveryId"));
        type_id.setCellValueFactory(new PropertyValueFactory<TableReceivingWho, Integer>("typeId"));
        weight.setCellValueFactory(new PropertyValueFactory<TableReceivingWho, Integer>("weight"));
        unique_code.setCellValueFactory(new PropertyValueFactory<TableReceivingWho, String>("uniqueCode"));

        listM = receivingOrderModel.getDate();


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

    public void switchToMenu(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource(Context.getInstance().getMainPage()));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }


//    @FXML
//    void create() {
//        receivingOrderModel.create(id, type, weight0);
//    }



//@FXML
//    void create(ActionEvent event) {
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
//
//@FXML
//    void initialize() {
//            assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'baseCreateOrder.fxml'.";
//            assert buttonBack1 != null : "fx:id=\"buttonBack1\" was not injected: check your FXML file 'baseCreateOrder.fxml'.";
//            assert delivery_id != null : "fx:id=\"delivery_id\" was not injected: check your FXML file 'baseCreateOrder.fxml'.";
//            assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'baseCreateOrder.fxml'.";
//            assert tableCreate != null : "fx:id=\"tableCreate\" was not injected: check your FXML file 'baseCreateOrder.fxml'.";
//            assert type_id != null : "fx:id=\"type_id\" was not injected: check your FXML file 'baseCreateOrder.fxml'.";
//            assert unique_code != null : "fx:id=\"unique_code\" was not injected: check your FXML file 'baseCreateOrder.fxml'.";
//            assert weight != null : "fx:id=\"weight\" was not injected: check your FXML file 'baseCreateOrder.fxml'.";
//            assert welcomeText != null : "fx:id=\"welcomeText\" was not injected: check your FXML file 'baseCreateOrder.fxml'.";
//            assert find != null : "fx:id=\"аштв\" was not injected: check your FXML file 'baseCreateOrder.fxml'.";
//
//            }

            }
