package com.example.project2.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.project2.Context;
import com.example.project2.HelloApplication;
import com.example.project2.Model.ChangeDataModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChangeDataController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField addressF;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonBack1;

    @FXML
    private Button ch;

    @FXML
    private TextField nameF;

    @FXML
    private TextField phoneF;

    @FXML
    private Label welcomeText;

    ChangeDataModel changeDataModel;

    public ChangeDataController() {
        this.changeDataModel = new ChangeDataModel();
    }

    private Stage stage;
    private Scene scene;

    @FXML
    public void switchToRegistrationBack(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToMenu(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource(Context.getInstance().getMainPage()));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void login(ActionEvent event) throws IOException {
        String name = nameF.getText();
        String phone = phoneF.getText();
        String address = addressF.getText();

        changeDataModel.changeData(name, phone, address);
    }
}
