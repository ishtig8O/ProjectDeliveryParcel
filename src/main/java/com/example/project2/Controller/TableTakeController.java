//package com.example.demo4;
//
//import java.io.IOException;
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.util.ResourceBundle;
//
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.input.MouseEvent;
//import javafx.stage.Stage;
//
//public class TableTakeController {
//
//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;
//
//    @FXML
//    private Button buttonBack;
//
//    @FXML
//    private Button buttonBack1;
//
//    @FXML
//    private TableColumn<TableTakeWho, String> center_address;
//
//    @FXML
//    private TableColumn<TableTakeWho, String> client_address;
//
//    @FXML
//    private TableColumn<TableTakeWho, Integer> delivery_id;
//
//    @FXML
//    private TableColumn<TableTakeWho, Integer> package_id;
//
//    @FXML
//    private TableView<TableTakeWho> tableTake;
//
//    @FXML
//    private Button take;
//
//    @FXML
//    private Label welcomeText;
//
////    @FXML
////    void add_staff(ActionEvent event) {
////
////    }
////
////    @FXML
////    void getUp(MouseEvent event) {
////
////    }
////
////    @FXML
////    void switchToRegistrationBack(ActionEvent event) {
////
////    }
//
////    @FXML
////    void initialize() {
////
////
////    }
//
//    private Stage stage;
//    private Scene scene;
//
//
//    private TableTakeModel tableTakeModel;
//
//    public TableTakeController() {
//        this.tableTakeModel = new TableTakeModel(this);
//    }
//
////    ObservableList<TableStaffModel> list = FXCollections.observableArrayList(
////            new TableStaffModel(1, "fff1", "1234435"),
////            new TableStaffModel(2, "fff2", "1234436"),
////            new TableStaffModel(3, "fff3", "1234437")
////
////
////    );
//
//    ObservableList<TableTakeWho> listM;
//    int index = -1;
//    Connection connection = null;
//    ResultSet rs = null;
//
//
//
////    public void add_staff() {
//////        String name = center_name.toString();
//////        String address = center_address.toString();
////        //if (name.isEmpty() || phone.isEmpty() || )
////        //tableTakeModel.add_staffi(nameText.getText(), TextAddress.getText(),);
////    }
//
//    @FXML
//    void getUp(javafx.scene.input.MouseEvent mouseEvent) {
//        index = tableTake.getSelectionModel().getSelectedIndex();
//        if (index <= -1) {
//            return;
//        }
//
//
//
////        nameText.setText(center_name.getCellData(index).toString());
////        TextAddress.setText(center_address.getCellData(index).toString());
//
//    }
//
//
//
//    public void updateTable() {
//        center_address.setCellValueFactory(new PropertyValueFactory<TableTakeWho, String>("centerAddress"));
//        client_address.setCellValueFactory(new PropertyValueFactory<TableTakeWho, String>("clientAddress"));
//        delivery_id.setCellValueFactory(new PropertyValueFactory<TableTakeWho, Integer>("deliveryId"));
//        package_id.setCellValueFactory(new PropertyValueFactory<TableTakeWho, Integer>("packageId"));
//
//        listM = tableTakeModel.getDate();
//
//
//        tableTake.setItems(listM);
//    }
//
//    @FXML
//    void initialize() {
////        courier_id.setCellValueFactory(new PropertyValueFactory<TableStaffWho, Integer>("id_staff"));
////        courier_name.setCellValueFactory(new PropertyValueFactory<TableStaffWho, String>("name"));
////        courier_phone_number.setCellValueFactory(new PropertyValueFactory<TableStaffWho, String>("phone"));
////
////        listM = tableStaffModel.getDate();
////
////
////        tableStaff.setItems(listM);
//        updateTable();
//    }
//    @FXML
//    public void switchToRegistrationBack(ActionEvent event) throws IOException {
//        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
//        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(fxmlLoader);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public void switchToTake(ActionEvent event) throws IOException {
////        Parent fxmlLoader = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
////        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
////        scene = new Scene(fxmlLoader);
////        stage.setScene(scene);
////        stage.show();
//    }
//
//
////    @FXML
////    void update() {
////        tableDeliveryModel.edit(idText, nameText, TextAddress);
////    }
//
//
//}
