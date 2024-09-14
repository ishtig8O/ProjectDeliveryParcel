package com.example.project2.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.project2.Context;
import com.example.project2.HelloApplication;
import com.example.project2.Model.JobModel;
import com.example.project2.Model.LoginModel;
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

public class JobController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField centerId;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonBack1;

    @FXML
    private TextField uniqueCode;

    @FXML
    private Button move;

    @FXML
    private Label welcomeText;

    private JobModel jobModel;


    public JobController() {
        this.jobModel = new JobModel();
    }


    @FXML
    void initialize() {


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
        String center_id = centerId.getText();
        String unique_code = uniqueCode.getText();

        jobModel.movePackage(center_id, unique_code);


//        if (jobModel.createLog(name, phone)) {
//            Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("menuAll.fxml"));
//            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//            scene = new Scene(fxmlLoader);
//            stage.setScene(scene);
//            stage.show();
//        }
//        else {
//            Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("registration.fxml"));
//            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//            scene = new Scene(fxmlLoader);
//            stage.setScene(scene);
//            stage.show();
//            Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
//            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//            scene = new Scene(fxmlLoader);
//            stage.setScene(scene);
//            stage.show();
//        }
//    }



    }


}