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

    ObservableList<TableReceivingWho> listM;
    int index = -1;
    Connection connection = null;
    ResultSet rs = null;

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
}
