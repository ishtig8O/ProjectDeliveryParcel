package com.example.project2.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.example.project2.Context;
import com.example.project2.HelloApplication;
import com.example.project2.Model.TableDeliveryModel;
import com.example.project2.Table.TableDeliveryWho;
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
    private Button delete;

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


    private Stage stage;
    private Scene scene;


    private TableDeliveryModel tableDeliveryModel;

    public TableDeliveryController() {
        this.tableDeliveryModel = new TableDeliveryModel(this);
    }


    ObservableList<TableDeliveryWho> listM;
    int index = -1;
    Connection connection = null;
    ResultSet rs = null;



    public void add_staff() {
        String name = center_name.toString();
        String address = center_address.toString();
        if (Context.getInstance().getIsAdmin()) {
            tableDeliveryModel.add_staffi(nameText.getText(), TextAddress.getText());
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "У Вас нет прав для выполнения этой операции!", ButtonType.CLOSE);
            alert.show();
        }
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
        if (Context.getInstance().getIsAdmin()) {
            tableDeliveryModel.edit(idText, nameText, TextAddress);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "У Вас нет прав для выполнения этой операции!", ButtonType.CLOSE);
            alert.show();
        }

    }

        @FXML
        void delete() {
            if (Context.getInstance().getIsAdmin()) {
                tableDeliveryModel.delete(idText);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "У Вас нет прав для выполнения этой операции!", ButtonType.CLOSE);
                alert.show();
            }
        }


}
