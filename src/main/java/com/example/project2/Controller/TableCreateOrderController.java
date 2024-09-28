package com.example.project2.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.project2.Context;
import com.example.project2.HelloApplication;
import com.example.project2.Model.TableCreateModel;
import com.example.project2.Table.TableCreateWho;
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

    ObservableList<TableCreateWho> listM;
    int index = -1;
    Connection connection = null;
    ResultSet rs = null;

    @FXML
    void getUp(javafx.scene.input.MouseEvent mouseEvent) {
        index = tableCreate.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        id.setText(package_id.getCellData(index).toString());
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

    public void switchToTakeMenu1(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource(Context.getInstance().getMainPage()));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void create() throws SQLException {
        tableCreateModel.create(id, type, weight0);
    }
}
