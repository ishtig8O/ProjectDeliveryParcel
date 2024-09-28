package com.example.project2.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.example.project2.Context;
import com.example.project2.HelloApplication;
import com.example.project2.Model.TableTakeModel;
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
import javafx.stage.Stage;

public class TableTakeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonBack1;

    @FXML
    private TableColumn<TableTakeWho, String> center_address;

    @FXML
    private TableColumn<TableTakeWho, String> client_address;

    @FXML
    private TableColumn<TableTakeWho, Integer> delivery_id;

    @FXML
    private TableColumn<TableTakeWho, Integer> package_id;

    @FXML
    private TableView<TableTakeWho> tableTake;

    @FXML
    private Button take;

    @FXML
    private Label welcomeText;

    @FXML
    private TextField id;


    private Stage stage;
    private Scene scene;


    private TableTakeModel tableTakeModel;

    public TableTakeController() {
        this.tableTakeModel = new TableTakeModel(this);
    }

    ObservableList<TableTakeWho> listM;
    int index = -1;
    Connection connection = null;
    ResultSet rs = null;


    @FXML
    void getUp(javafx.scene.input.MouseEvent mouseEvent) {
        index = tableTake.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }

        id.setText(package_id.getCellData(index).toString());
    }



    public void updateTable() {
        center_address.setCellValueFactory(new PropertyValueFactory<TableTakeWho, String>("centerAddress"));
        client_address.setCellValueFactory(new PropertyValueFactory<TableTakeWho, String>("clientAddress"));
        delivery_id.setCellValueFactory(new PropertyValueFactory<TableTakeWho, Integer>("deliveryId"));
        package_id.setCellValueFactory(new PropertyValueFactory<TableTakeWho, Integer>("packageId"));

        listM = tableTakeModel.getDate();


        tableTake.setItems(listM);
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

    public void switchToTakeMenu(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource(Context.getInstance().getMainPage()));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void take() {
        tableTakeModel.edit(id);
    }
}
