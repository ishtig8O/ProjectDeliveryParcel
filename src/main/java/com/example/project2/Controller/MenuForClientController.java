package com.example.project2.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.project2.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MenuForClientController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonGoToBaseDelivery;

    @FXML
    private Button buttonGoToCreateOrder;

    @FXML
    private Button buttonToViewOrder;

    @FXML
    private Label welcomeText;

    private Stage stage;
    private Scene scene;
    @FXML
    public void switchToBack(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }

//    @FXML
//    public void switchToBaseStaff(ActionEvent event) throws IOException {
//        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("baseStaff.fxml"));
//        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(fxmlLoader);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    @FXML
//    public void switchToBaseClient(ActionEvent event) throws IOException {
//        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("baseClient.fxml"));
//        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(fxmlLoader);
//        stage.setScene(scene);
//        stage.show();
//    }

    @FXML
    public void switchToBaseDelivery(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("basePoint.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToBaseTake(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("BaseTakeOrder.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToRec(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("receivingOrder.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }

//    @FXML
//    void switchToBack(ActionEvent event) {
//
//    }
//
//    @FXML
//    void switchToBaseDelivery(ActionEvent event) {
//
//    }
//
//    @FXML
//    void switchToBaseTake(ActionEvent event) {
//
//    }
//
//    @FXML
//    void initialize() {
//        assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'menuForStaff.fxml'.";
//        assert buttonGoToBaseDelivery != null : "fx:id=\"buttonGoToBaseDelivery\" was not injected: check your FXML file 'menuForStaff.fxml'.";
//        assert buttonGoToCreateOrder != null : "fx:id=\"buttonGoToCreateOrder\" was not injected: check your FXML file 'menuForStaff.fxml'.";
//        assert buttonToViewOrder != null : "fx:id=\"buttonToViewOrder\" was not injected: check your FXML file 'menuForStaff.fxml'.";
//        assert welcomeText != null : "fx:id=\"welcomeText\" was not injected: check your FXML file 'menuForStaff.fxml'.";
//
//    }

}
