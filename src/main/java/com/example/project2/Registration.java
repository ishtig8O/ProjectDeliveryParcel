package com.example.project2;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.Collection;
import java.util.ResourceBundle;

import com.example.project2.Model.RegistrationModel;
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

public class Registration {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField TextPhone;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonLog;

    @FXML
    private TextField textAddress;

    @FXML
    private TextField textName;

    @FXML
    private Label welcomeText;

    private RegistrationModel registrationModel;


    @FXML
    void initialize() {
    }

    public Registration() {
        this.registrationModel = new RegistrationModel();
    }

    public TextField getTextName() {
        return textName;
    }

    public TextField getTextAddress() {
        return textAddress;
    }

    public TextField getTextPhone() {
        return TextPhone;
    }

    private Stage stage;
    private Scene scene;
    @FXML
    public void switchToRegistrationBack(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
        Context.getInstance().setId(null);
    }

    @FXML
    void reg(ActionEvent event) throws IOException {
        String address = textAddress.getText();
        String phone = TextPhone.getText();
        String name = textName.getText();
        registrationModel.createReg(name, address, phone);
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("menuForClient.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
}
