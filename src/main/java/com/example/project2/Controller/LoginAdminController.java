package com.example.project2.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.project2.HelloApplication;
import com.example.project2.Model.LoginAdminModel;
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

public class LoginAdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonLogon;

    @FXML
    private TextField textLog;

    @FXML
    private TextField textPass;

    @FXML
    private Label welcomeText;

    

    @FXML
    void initialize() {
    }

    private LoginAdminModel loginAdminModel;

    public LoginAdminController() {
        this.loginAdminModel = new LoginAdminModel();
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
    }

    @FXML
    void login(ActionEvent event) throws IOException {
        String log = textLog.getText();
        String pass = textPass.getText();
        if (loginAdminModel.createLog(log, pass)) {
            Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("menuAll.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader);
            stage.setScene(scene);
            stage.show();
        }
        else {
            Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("registration.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader);
            stage.setScene(scene);
            stage.show();
//            Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
//            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//            scene = new Scene(fxmlLoader);
//            stage.setScene(scene);
//            stage.show();
        }




    }

}
